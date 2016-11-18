package com.nhsbsa.model;

import com.nhsbsa.model.validation.ContributionDateValid;
import com.nhsbsa.model.validation.SchedulePaymentValidationGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by jeffreya on 11/11/2016.
 * ContributionDate
 */

@Embeddable
@Data
@Builder
@ContributionDateValid(message = "{contributionDate.in.range}", groups = SchedulePaymentValidationGroup.class)
@NoArgsConstructor
@AllArgsConstructor
public class ContributionDate implements Serializable {

    @Range(min = 1, max = 12, message = "{contributionMonth.valid}", groups = SchedulePaymentValidationGroup.class)
    @NotNull(message = "{contributionMonth.notBlank}", groups = SchedulePaymentValidationGroup.class)
    private Integer contributionMonth;

    @Range(min = 2001, max = 999999, message = "{contributionYear.valid}", groups = SchedulePaymentValidationGroup.class)
    @NotNull(message = "{contributionYear.notBlank}", groups = SchedulePaymentValidationGroup.class)
    private Integer contributionYear;
}
