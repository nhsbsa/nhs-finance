package com.nhsbsa.webdriver.accessibility;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by MattHood on 30/09/2016.
 */
@XmlRootElement
public class Guidelines {

    private String guideline;

    public String getGuideline() {
        return guideline;
    }

    @XmlElement
    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

}