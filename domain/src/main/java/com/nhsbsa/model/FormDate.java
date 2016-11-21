package com.nhsbsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nhsbsa.model.validation.ValidFormDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ValidFormDate
public class FormDate {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private String days;
    private String month;
    private String year;

    @JsonIgnore
    public Date getDate() {

        if (StringUtils.isEmpty(days) ||
                StringUtils.isEmpty(month) ||
                StringUtils.isEmpty(year)) {
            return null;
        }

        final String formattedDate = String.format("%s/%s/%s", getDays(), getMonth(), getYear());

        try {
            if (StringUtils.isNotEmpty(formattedDate)) {
                DATE_FORMAT.setLenient(false);
                return DATE_FORMAT.parse(formattedDate);
            }
        } catch (ParseException e) {
            return null;
        }
        return null;
    }

}