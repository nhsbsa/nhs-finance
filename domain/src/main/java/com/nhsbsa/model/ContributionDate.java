package com.nhsbsa.model;

import com.nhsbsa.model.validaton.ContributionDateValid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by jeffreya on 11/11/2016.
 * ContributionDate
 */

@Embeddable
@Data
@Builder
@ContributionDateValid
@AllArgsConstructor
@NoArgsConstructor
public class ContributionDate implements Serializable {

    private Integer contributionMonth;

    private Integer contributionYear;
}
