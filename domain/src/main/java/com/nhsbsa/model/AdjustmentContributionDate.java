package com.nhsbsa.model;

import com.nhsbsa.model.validation.AdjustmentValidationGroup;
import com.nhsbsa.model.validation.AdjustmentContributionDateValid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Natalie Hulse 24/11/2016
 * Adjustment ContributionDate
 */

@Embeddable
@Data
@Builder
@AdjustmentContributionDateValid(message = "{adjustmentContributionDate.in.range}", groups = AdjustmentValidationGroup.class)
@NoArgsConstructor
@AllArgsConstructor
public class AdjustmentContributionDate implements Serializable {

    private String contributionMonth;

    private Integer contributionYear;
}
