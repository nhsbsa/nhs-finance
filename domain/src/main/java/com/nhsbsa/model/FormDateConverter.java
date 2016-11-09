package com.nhsbsa.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

@Converter
public class FormDateConverter implements AttributeConverter<FormDate, Date> {

    @Override
    public Date convertToDatabaseColumn(FormDate formDate) {
        return formDate.getDate();
    }

    @Override
    public FormDate convertToEntityAttribute(Date date) {
        final FormDate formDate = new FormDate();
        if (date == null) {
            return formDate;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        formDate.setDays(String.valueOf(calendar.get(Calendar.DATE)));
        formDate.setMonth(String.valueOf(calendar.get(Calendar.MONTH)));
        formDate.setYear(String.valueOf(calendar.get(Calendar.YEAR)));
        return formDate;
    }
}
