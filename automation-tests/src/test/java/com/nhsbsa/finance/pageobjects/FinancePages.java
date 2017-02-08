package com.nhsbsa.finance.pageobjects;

import com.nhsbsa.BasePage;
import com.nhsbsa.FormPage;

/**
 * Created by ianfulcher on 01/11/2016.
 */
public class FinancePages {

    enum PageLocale {
        ENGLISH, WELSH
    }

    private static BasePage currentPage;
    private static PageLocale pageLocale;

    public static void setCurrentPage(BasePage basePage) {
        currentPage = basePage;
    }

    public static BasePage currentPage() {
        return currentPage;
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

    public static FeatureIsNotYetAvailablePage featureIsNotYetAvailablePage() {
        if (currentPage instanceof FeatureIsNotYetAvailablePage) {
            return (FeatureIsNotYetAvailablePage) currentPage;
        }
        throw new RuntimeException("Not a FeatureIsNotYetAvailablePage");
    }

    public static void setViewEnglishPage() {
        pageLocale = PageLocale.ENGLISH;
    }

    public static void setViewWelshPage() {
        pageLocale = PageLocale.WELSH;
    }

    public static boolean isWelshPage() {
        return pageLocale == PageLocale.WELSH;
    }
}