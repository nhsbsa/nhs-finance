package com.nhsbsa.CsvDefinitions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.annotation.JsonFormat;

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
 */


@Data
@Builder
@JsonPropertyOrder(value = {"accountCode", "transactionDate", "baseAmount", "baseAmountPlusMinus", "paymentType", "reference",
        "description", "salesAnalysis", "journalSource", "contributionMonth", "staffGP", "contributionType"})

public class CsvColumns {

    @JsonProperty(value = "Account Code")
    private String accountCode;

    @JsonProperty(value = "Transaction Date")
    //@JsonSerialize(using = CustomTransDateSerializer.class)
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private String transactionDate;
    //private Date transactionDate;

    @JsonProperty(value = "Base Amount")
    @JsonSerialize(using = CustomBaseAmountSerializer.class)
    private BigDecimal baseAmount;

    @JsonProperty(value = "Base Amount(+/-)")
    @JsonSerialize(using = CustomBaseAmountSerializer.class)
    private BigDecimal baseAmountPlusMinus;

    @JsonProperty(value = "Payment Type")
    private String paymentType;

    @JsonProperty(value = "Reference")
    private String reference;

    @JsonProperty(value = "Description")
    private String description;

    @JsonProperty(value = "Sales Analysis")
    private String salesAnalysis;

    @JsonProperty(value = "Journal Source")
    private String journalSource;

    @JsonProperty(value = "Contribution Month")
    private String contributionMonth;

    @JsonProperty(value = "Staff/GP")
    @JsonSerialize(using = StaffOrGpEnum.CustomStaffGpEnumSerializer.class)
    private StaffOrGpEnum staffGP;

    @JsonProperty(value = "Contribution Type")
    private String contributionType;

}