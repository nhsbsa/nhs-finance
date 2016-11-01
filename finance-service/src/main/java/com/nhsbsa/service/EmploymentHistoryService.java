package com.nhsbsa.service;

import com.nhsbsa.controllers.EmploymentHistoryRepository;
import com.nhsbsa.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class EmploymentHistoryService {

    private EmploymentHistoryRepository employmentHistoryRepository;

    @Autowired
    public EmploymentHistoryService(final EmploymentHistoryRepository employmentHistoryRepository) {
        this.employmentHistoryRepository = employmentHistoryRepository;
    }

    public EmploymentHistory getEmploymentHistory(final long id) {
        return employmentHistoryRepository.findByIdAndFetchEagerly(id);
    }

}
