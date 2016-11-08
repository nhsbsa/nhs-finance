package com.nhsbsa.model.validaton;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

@ValidFormDate
public interface FormDateValidator {
    String getDays();
    String getMonth();
    String getYear();
}
