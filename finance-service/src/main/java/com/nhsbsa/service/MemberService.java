package com.nhsbsa.service;

import com.nhsbsa.controllers.AddressRepository;
import com.nhsbsa.controllers.EmployingAuthorityAdminRepository;
import com.nhsbsa.controllers.EmploymentHistoryRepository;
import com.nhsbsa.controllers.MemberRepository;
import com.nhsbsa.model.*;
import com.nhsbsa.model.updates.NameChange;
import com.nhsbsa.model.updates.WorkingPattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Mark Lishman on 18/08/2016.
 */

@Service
@Transactional
public class MemberService {

    private MemberRepository memberRepository;
    private EmployingAuthorityAdminRepository employingAuthorityAdminRepository;
    private AddressRepository addressRepository;
    private EmploymentHistoryRepository employmentHistoryRepository;

    @Autowired
    public MemberService(final MemberRepository memberRepository,
                         final AddressRepository addressRepository,
                         final EmployingAuthorityAdminRepository employingAuthorityAdminRepository,
                         final EmploymentHistoryRepository employmentHistoryRepository) {
        this.memberRepository = memberRepository;
        this.addressRepository = addressRepository;
        this.employingAuthorityAdminRepository = employingAuthorityAdminRepository;
        this.employmentHistoryRepository = employmentHistoryRepository;
    }

    public Member loadByEmail(final String emailAddress) {
        return memberRepository.findByEmailAddress(emailAddress);
    }

    public Member loadByUUID(final String uuid) {
        return memberRepository.findByUuid(uuid);
    }


    public Member getMemberDetailsForEmployer(final String employerID, final String pensionNumber) {
        final Member byPensionNumber = memberRepository.findByPensionNumber(pensionNumber);
        if (byPensionNumber == null) {
            return null; //log that it was not found
        }
        final Long employerId = Long.parseLong(employerID);
        final EmployingAuthorityAdmin employingAuthorityAdmin =
                employingAuthorityAdminRepository.findById(employerId);

        if (employingAuthorityAdmin == null) {
            return null; //log that the admin didn't exist
        }
        final long adminEmployingAuthorityId = employingAuthorityAdmin.getEmployingAuthority().getId();

        final List<EmploymentHistory> employmentHistoryList = byPensionNumber.getEmploymentHistoryList();
        for (final EmploymentHistory employmentHistory : employmentHistoryList) {
            final EmployingAuthority employingAuthority = employmentHistory.getEmployingAuthority();
            if (adminEmployingAuthorityId == employingAuthority.getId()) {
                return byPensionNumber;
            }
        }

        //log that no matches were found, this is very strange.
        //log member + employer id
        return null;
    }

    public Member getMemberDetails(final String pensionNumber) {
        return memberRepository.findByPensionNumber(pensionNumber);
    }

    public Member getMemberDetailsByUUID(final String uuid) {
        return memberRepository.findByUuid(uuid);
    }

    public Member getEmploymentHistory(final String pensionNumber) {
        return memberRepository.findByPensionNumber(pensionNumber);
    }

    public Member saveMemberDetails(final Member member) {
        return memberRepository.save(member);
    }

    public Address saveHomeAddress(final String pensionNumber, final Address homeAddress) {
        final Member member = getMemberDetails(pensionNumber);
        homeAddress.setId(member.getHomeAddress().getId());
        return addressRepository.save(homeAddress);
    }

    public String saveContactNumber(final String pensionNumber, final String contactNumber) {
        final Member member = getMemberDetails(pensionNumber);
        member.setTelephoneNumber(contactNumber);
        final Member savedMember = memberRepository.save(member);
        return savedMember.getTelephoneNumber();
    }

    public Address savePostalAddress(final String pensionNumber, final Address postalAddress) {
        final Member member = getMemberDetails(pensionNumber);
        postalAddress.setId(member.getPostalAddress().getId());
        return addressRepository.save(postalAddress);
    }

    public String saveMobileNumber(final String pensionNumber, final String mobileNumber) {
        final Member member = getMemberDetails(pensionNumber);
        member.setMobileNumber(mobileNumber);
        final Member savedMember = memberRepository.save(member);
        return savedMember.getMobileNumber();
    }

    public Member generateTestAccount(final Member member) {
        return memberRepository.save(member);
    }

    public WorkingPattern updateWorkingPattern(final String pensionNumber,
                                               final long employmentHistoryId,
                                               final boolean partTime,
                                               final BigDecimal actualHours,
                                               final BigDecimal standardHours) {
        final Member member = getMemberDetails(pensionNumber);
        final EmploymentHistory employmentHistory = employmentHistoryRepository.findOne(employmentHistoryId);
        employmentHistory.setPartTime(partTime);
        employmentHistory.setActualHours(actualHours);
        employmentHistory.setStandardHours(standardHours);

        final EmploymentHistory savedEmploymentHistory = employmentHistoryRepository.save(employmentHistory);
        return employmentHistoryToWorkingPattern(savedEmploymentHistory, member.getPensionNumber());
    }

    private WorkingPattern employmentHistoryToWorkingPattern(final EmploymentHistory employmentHistory,
                                                             final String pensionNumber) {
        return WorkingPattern.builder()
                .actualHours(employmentHistory.getActualHours())
                .standardHours(employmentHistory.getStandardHours())
                .partTime(employmentHistory.isPartTime())
                .employmentHistoryId(employmentHistory.getId())
                .pensionNumber(pensionNumber)
                .build();

    }

    public NameChange updateName(final String pensionNumber,
                                 final Title title,
                                 final String firstName,
                                 final String middleName,
                                 final String lastName) {
        final Member member = getMemberDetails(pensionNumber);
        member.setTitle(title);
        member.setFirstName(firstName);
        member.setMiddleName(middleName);
        member.setLastName(lastName);
        final Member savedMember = memberRepository.save(member);
        return memberToNameChange(pensionNumber, savedMember);
    }

    private NameChange memberToNameChange(final String pensionNumber, final Member member) {
        return NameChange.builder().pensionNumber(pensionNumber)
                .firstName(member.getFirstName())
                .middleName(member.getMiddleName())
                .lastName(member.getLastName()).build();
    }
}
