package com.nhsbsa.webdriver.accessibility;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by MattHood on 30/09/2016.
 */
@XmlRootElement
public class Results {

    private Results resultType;

    public Results getResultType() {
        return resultType;
    }

    @XmlElement
    public void setResultType(Results resultType) {
        this.resultType = resultType;
    }
}
