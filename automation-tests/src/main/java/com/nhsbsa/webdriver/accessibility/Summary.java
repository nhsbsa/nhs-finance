package com.nhsbsa.webdriver.accessibility;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by MattHood on 30/09/2016.
 */
@XmlRootElement
public class Summary {

    private String status;
    private String sessionID;

    private int numOfErrors;
    private int numOfLikelyProblems;
    private int numOfPotentialProblems;
    private Guidelines guidelines;

    public String getStatus() {
        return status;
    }

    @XmlElement
    public void setStatus(String status) {
        this.status = status;
    }

    public String getSessionID() {
        return sessionID;
    }

    @XmlElement
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public int getNumOfErrors() {
        return numOfErrors;
    }

    @XmlElement(name="NumOfErrors")
    public void setNumOfErrors(int numOfErrors) {
        this.numOfErrors = numOfErrors;
    }

    public int getNumOfLikelyProblems() {
        return numOfLikelyProblems;
    }

    @XmlElement(name="NumOfLikelyProblems")
    public void setNumOfLikelyProblems(int numOfLikelyProblems) {
        this.numOfLikelyProblems = numOfLikelyProblems;
    }

    public int getNumOfPotentialProblems() {
        return numOfPotentialProblems;
    }

    @XmlElement(name="NumOfPotentialProblems")
    public void setNumOfPotentialProblems(int numOfPotentialProblems) {
        this.numOfPotentialProblems = numOfPotentialProblems;
    }

    public Guidelines getGuidelines() {
        return guidelines;
    }

    @XmlElement
    public void setGuidelines(Guidelines guidelines) {
        this.guidelines = guidelines;
    }
}
