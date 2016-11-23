package com.nhsbsa.reports.rft1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.nhsbsa.reports.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
public class RFT1 {

    @Id
    @Column(name = "csv_file_id")
    @JsonIgnore
    private int csvFileID;

    @Column(name = "account_code")
    @JsonProperty(value = "Account Code")
    private String accountCode;

    @Column(name = "transaction_date")
    @JsonProperty(value = "Transaction Date")
    @JsonSerialize(using = TransferDateCSVUtils.Serializer.class)
    @JsonDeserialize(using = TransferDateCSVUtils.Deserializer.class)
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
    @JsonProperty(value = "Contributor Type")
    @JsonSerialize(using = PaymentType.Serializer.class)
    @JsonDeserialize(using = PaymentType.Deserializer.class)
    private PaymentType paymentType;

    @Column(name = "reference")
    @JsonProperty(value = "Reference")
    private String reference;

    @Column(name = "description")
    @JsonProperty(value = "Description")
    private String description;

    @Column(name = "sales_analysis")
    @JsonProperty(value = "Sales Analysis")
    private String salesAnalysis;

    @Column(name = "journal_source")
    @JsonProperty(value = "Journal Source")
    private String journalSource;

    @Column(name = "contribution_month")
    @JsonProperty(value = "Contribution Month")
    private String contributionMonth;

    @Column(name = "staff_gp")
    @JsonProperty(value = "Staff/GP")
    @JsonSerialize(using = Contributor.Serializer.class)
    @JsonDeserialize(using = Contributor.Deserializer.class)
    private Contributor staffGP;

    @Column(name = "contribution_type")
    @JsonProperty(value = "Contribution Type")
    @JsonSerialize(using = ContributionType.Serializer.class)
    @JsonDeserialize(using = ContributionType.Deserializer.class)
    private ContributionType contributionType;

}