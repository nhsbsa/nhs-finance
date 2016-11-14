package com.nhsbsa.CsvDefinitions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ianfulcher on 10/11/2016.
 * <p>
 * Column Names are (and in this order):-
 * Account Code,Transaction Date,Base Amount,Base Amount(+/-),Payment Type,Reference,Description,
 * Sales Analysis,Journal Source,Contribution Month,Staff/GP,Contribution Type
 *
 * NOTE: Use the @JsonPropertyOrder for ordering the columns for the output
 */


@Data
@Builder
@JsonPropertyOrder(value = {"accountCode", "transactionDate", "baseAmount", "baseAmountPlusMinus", "paymentType", "reference",
        "description", "salesAnalysis", "journalSource", "contributionMonth", "staffGP", "contributionType"})

public class CsvColumns {

    @JsonProperty(value = "Account Code")
    @JsonSerialize(using = CustomStringSerializer.class)
    private String accountCode;

    @JsonProperty(value = "Transaction Date")
    @JsonSerialize(using = CustomTransDateSerializer.class)
    private Date transactionDate;

    @JsonProperty(value = "Base Amount")
    @JsonSerialize(using = CustomBaseAmountSerializer.class)
    private BigDecimal baseAmount;

    @JsonProperty(value = "Base Amount(+/-)")
    @JsonSerialize(using = CustomBaseAmountSerializer.class)
    private BigDecimal baseAmountPlusMinus;

    @JsonProperty(value = "Payment Type")
    @JsonSerialize(using = PaymentTypeEnum.CustomPaymentTypeEnumSerializer.class)
    private PaymentTypeEnum paymentType;

    @JsonProperty(value = "Reference")
    @JsonSerialize(using = CustomStringSerializer.class)
    private String reference;

    @JsonProperty(value = "Description")
    @JsonSerialize(using = CustomStringSerializer.class)
    private String description;

    @JsonProperty(value = "Sales Analysis")
    @JsonSerialize(using = CustomStringSerializer.class)
    private String salesAnalysis;

    @JsonProperty(value = "Journal Source")
    @JsonSerialize(using = CustomStringSerializer.class)
    private String journalSource;

    @JsonProperty(value = "Contribution Month")
    @JsonSerialize(using = CustomStringSerializer.class)
    private String contributionMonth;

    @JsonProperty(value = "Staff/GP")
    @JsonSerialize(using = StaffOrGpEnum.CustomStaffGpEnumSerializer.class)
    private StaffOrGpEnum staffGP;

    @JsonProperty(value = "Contribution Type")
    @JsonSerialize(using = ContributionTypeEnum.CustomContributionTypeEnumSerializer.class)
    private ContributionTypeEnum contributionType;

}