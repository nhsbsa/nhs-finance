package com.nhsbsa.service;

import com.nhsbsa.repos.FinanceUserRepository;
import com.nhsbsa.model.FinanceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by jeffreya on 01/11/2016.
 *
 */

@Service
@Transactional
public class FinanceUserService {

    private final FinanceUserRepository financeUserRepository;

    @Autowired
    public FinanceUserService(final FinanceUserRepository financeUserRepository) {
        this.financeUserRepository = financeUserRepository;
    }

    public FinanceUser findByUuid(final String uuid) {
        return financeUserRepository.findByUuid(uuid);
    }
}
