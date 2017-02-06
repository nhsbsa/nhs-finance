package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.BasePage;
import com.nhsbsa.FormPage;

/**
 * Created by ianfulcher on 01/11/2016.
 */
public class FinancePages {

    private static BasePage currentPage;

    public static void setCurrentPage(BasePage basePage) {
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

    public static FinanceStartPage financeStartPage() {
        if (currentPage instanceof FinanceStartPage) {
            return (FinanceStartPage) currentPage;
        }
        throw new RuntimeException("Not a FinanceStartPage");
    }

    public static FinanceLoginPage financeLoginPage() {
        if (currentPage instanceof FinanceLoginPage) {
            return (FinanceLoginPage) currentPage;
        }
        throw new RuntimeException("Not a FinanceLoginPage");
    }

}