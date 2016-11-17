package com.nhsbsa.model;

/**
 * Created by Mark Lishman on 17/11/2016.
 */
public @interface Currency {

    String min() default "1";
    String max() default "99999999.99";
}
