package com.nhsbsa.CsvDefinitions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ianfulcher on 10/11/2016.
 */

@Entity
@Table(name = "csv_data")
@Data
@Builder
@JsonPropertyOrder(value = {"accountCode", "transactionDate", "baseAmount", "baseAmountPlusMinus", "paymentType", "reference",
        "description", "salesAnalysis", "journalSource", "contributionMonth", "staffGP", "contributionType"})
public class CsvColumns {

    @Id
    @Column(name = "csv_file_id")
    @JsonIgnore
    private int csvFileID;

    @Column(name = "account_code")
    @JsonProperty(value = "Account Code")
    @JsonSerialize(using = CustomStringSerializer.class)
    private String accountCode;

    @Column(name = "transaction_date")
    @JsonProperty(value = "Transaction Date")
    @JsonSerialize(using = CustomTransDateSerializer.class)
    private Date transactionDate;

    @Column(name = "base_amount")
    @JsonProperty(value = "Base Amount")
    @JsonSerialize(using = CustomBaseAmountSerializer.class)
    private BigDecimal baseAmount;

    @Column(name = "base_amount_plus_minus")
    @JsonProperty(value = "Base Amount(+/-)")
    @JsonSerialize(using = CustomBaseAmountSerializer.class)
    private BigDecimal baseAmountPlusMinus;

    @Column(name = "payment_type")
    @JsonProperty(value = "Payment Type")
    @JsonSerialize(using = PaymentTypeEnum.CustomPaymentTypeEnumSerializer.class)
    private PaymentTypeEnum paymentType;

    @Column(name = "reference")
    @JsonProperty(value = "Reference")
    @JsonSerialize(using = CustomStringSerializer.class)
    private String reference;

    @Column(name = "description")
    @JsonProperty(value = "Description")
    @JsonSerialize(using = CustomStringSerializer.class)
    private String description;

    @Column(name = "sales_analysis")
    @JsonProperty(value = "Sales Analysis")
    @JsonSerialize(using = CustomStringSerializer.class)
    private String salesAnalysis;

    @Column(name = "journal_source")
    @JsonProperty(value = "Journal Source")
    @JsonSerialize(using = CustomStringSerializer.class)
    private String journalSource;

    @Column(name = "contribution_month")
    @JsonProperty(value = "Contribution Month")
    @JsonSerialize(using = CustomStringSerializer.class)
    private String contributionMonth;

    @Column(name = "staff_gp")
    @JsonProperty(value = "Staff/GP")
    @JsonSerialize(using = StaffOrGpEnum.CustomStaffGpEnumSerializer.class)
    private StaffOrGpEnum staffGP;

    @Column(name = "contribution_type")
    @JsonProperty(value = "Contribution Type")
    @JsonSerialize(using = ContributionTypeEnum.CustomContributionTypeEnumSerializer.class)
    private ContributionTypeEnum contributionType;

}