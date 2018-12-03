package com.github.pauloj2000.mf2018.lonic.negocio;

/**
 * Created by Paulo Sales on 25/11/18.
 */
public class Loinc {
    private String loincNum;
    private String shortname;
    private String longName;
    private String submittedUnits;

    public String getLoincNum() {
        return loincNum;
    }

    public String getShortname() {
        return shortname;
    }

    public String getLongName() {
        return longName;
    }

    public String getSubmittedUnits() {
        return submittedUnits;
    }

    public void setLoincNum(String loincNum) {
        this.loincNum = loincNum;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public void setSubmittedUnits(String submittedUnits) {
        this.submittedUnits = submittedUnits;
    }
}
