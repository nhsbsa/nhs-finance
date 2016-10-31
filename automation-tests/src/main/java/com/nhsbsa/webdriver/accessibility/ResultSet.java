package com.nhsbsa.webdriver.accessibility;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by MattHood on 30/09/2016.
 */
@XmlRootElement(name = "resultset")
public class ResultSet {

    private Summary summary;
    private Results results;

    public Summary getSummary() {
        return summary;
    }

    @XmlElement
    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Results getResults() {
        return results;
    }

    @XmlElement
    public void setResults(Results results) {
        this.results = results;
    }
}