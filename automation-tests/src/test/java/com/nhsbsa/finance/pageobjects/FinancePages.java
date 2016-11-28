package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.BasePage;
import com.nhsbsa.FormPage;

/**
 * Created by ianfulcher on 01/11/2016.
 */
public class FinancePages {

    // TODO Use generics

    private static BasePage currentPage;

    public static FinanceStartPage financeStartPage;
    public static FinanceLoginPage financeLoginPage;
    public static EmployerAccountInfoPage employerAccountInfoPage;

    public static BasePage currentPage() {
        return currentPage;
    }

    public static void setCurentPage(BasePage basePage) {
        currentPage = basePage;
    }

    public static FormPage currentFormPage() {
        if (currentPage instanceof FormPage) {
            return (FormPage) currentPage;
        }
        throw new RuntimeException("Not a FormPage");
    }

    public static ContributionsAndPaymentPage contributionsAndPaymentPage() {
        if (currentPage instanceof ContributionsAndPaymentPage) {
            return (ContributionsAndPaymentPage) currentPage;
        }
        throw new RuntimeException("Not a ContributionsAndPaymentPage");
    }

    public static SchedulePaymentPage schedulePaymentPage() {
        if (currentPage instanceof SchedulePaymentPage) {
            return (SchedulePaymentPage) currentPage;
        }
        throw new RuntimeException("Not a SchedulePaymentPage");
    }

}