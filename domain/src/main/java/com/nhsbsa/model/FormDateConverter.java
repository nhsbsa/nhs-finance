package com.nhsbsa.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
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
        // TODO implement this
        return new FormDate();
    }
}
