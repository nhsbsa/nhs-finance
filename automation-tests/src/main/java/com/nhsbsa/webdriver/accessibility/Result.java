package com.nhsbsa.webdriver.accessibility;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by MattHood on 30/09/2016.
 */
@XmlRootElement
public class Result {

    private String resultType;
    private int lineNum;
    private int columnNum;
    private String errorMsg;
    private String errorSourceCode;
    private String sequenceId;
    private String decisionPass;
    private String decisionFail;

    public String getResultType() {
        return resultType;
    }

    @XmlElement
    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public int getLineNum() {
        return lineNum;
    }

    @XmlElement
    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    @XmlElement
    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    @XmlElement
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorSourceCode() {
        return errorSourceCode;
    }

    @XmlElement
    public void setErrorSourceCode(String errorSourceCode) {
        this.errorSourceCode = errorSourceCode;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    @XmlElement
    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getDecisionPass() {
        return decisionPass;
    }

    @XmlElement
    public void setDecisionPass(String decisionPass) {
        this.decisionPass = decisionPass;
    }

    public String getDecisionFail() {
        return decisionFail;
    }

    @XmlElement
    public void setDecisionFail(String decisionFail) {
        this.decisionFail = decisionFail;
    }
}
