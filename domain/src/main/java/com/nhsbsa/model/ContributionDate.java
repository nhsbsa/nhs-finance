package com.nhsbsa.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Created by jeffreya on 11/11/2016.
 */
@Embeddable
public class ContributionDate {

    @Range(min = 1, max = 12, message = "{contributionMonth.valid}")
    @NotNull(message = "{contributionMonth.notBlank}")
    private Integer contributionMonth;

    @Range(min = 2001, max = 999999, message = "{contributionYear.valid}")
    @NotNull(message = "{contributionYear.notBlank}")
    private Integer contributionYear;
}
