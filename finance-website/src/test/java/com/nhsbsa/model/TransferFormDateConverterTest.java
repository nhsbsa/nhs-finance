package com.nhsbsa.model;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

/**
 * Created by Mark Lishman on 10/11/2016.
 */
public class TransferFormDateConverterTest {
    private TransferFormDateConverter converter;

    @Before
    public void before() {
        converter = new TransferFormDateConverter();
    }

    @Test
    public void convertToDatabaseColumn() throws ParseException {
        TransferFormDate formDate = new TransferFormDate();
        formDate.setDays("21");
        formDate.setMonth("12");
        formDate.setYear("2016");

        Date date = converter.convertToDatabaseColumn(formDate);

        assertThat(date, is(equalTo(new SimpleDateFormat("yyyyMMdd").parse("20161221"))));

    }

    @Test
    public void convertToEntityAttribute() throws ParseException {
        Date date = new SimpleDateFormat("yyyyMMdd").parse("20161221");

        TransferFormDate formDate = converter.convertToEntityAttribute(date);

        assertThat(formDate.getDays(), is(equalTo("21")));
        assertThat(formDate.getMonth(), is(equalTo("12")));
        assertThat(formDate.getYear(), is(equalTo("2016")));
    }

    @Test
    public void convertToEntityAttributeWithNullDate() throws ParseException {

        TransferFormDate formDate = converter.convertToEntityAttribute(null);

        assertThat(formDate.getDays(), is(nullValue()));
        assertThat(formDate.getMonth(), is(nullValue()));
        assertThat(formDate.getYear(), is(nullValue()));
    }

}