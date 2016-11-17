package com.nhsbsa.model;

import com.nhsbsa.model.validaton.ContributionDateValid;
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
@AllArgsConstructor
@NoArgsConstructor
@ContributionDateValid(message = "{contributionDate.in.range}")
public class ContributionDate implements Serializable {

    @Range(min = 1, max = 12, message = "{contributionMonth.valid}")
    @NotNull(message = "{contributionMonth.notBlank}")
    private Integer contributionMonth;

    @Range(min = 2001, max = 999999, message = "{contributionYear.valid}")
    @NotNull(message = "{contributionYear.notBlank}")
    private Integer contributionYear;
}
