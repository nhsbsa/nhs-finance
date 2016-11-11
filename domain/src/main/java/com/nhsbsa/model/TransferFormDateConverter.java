package com.nhsbsa.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

@Converter
public class TransferFormDateConverter implements AttributeConverter<TransferFormDate, Date> {

    @Override
    public Date convertToDatabaseColumn(TransferFormDate formDate) {
        return formDate.getDate();
    }

    @Override
    public TransferFormDate convertToEntityAttribute(Date date) {
        final TransferFormDate formDate = new TransferFormDate();
        if (date == null) {
            return formDate;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        formDate.setDays(String.valueOf(calendar.get(Calendar.DATE)));
        formDate.setMonth(String.valueOf(calendar.get(Calendar.MONTH) + 1));
        formDate.setYear(String.valueOf(calendar.get(Calendar.YEAR)));
        return formDate;
    }
}
