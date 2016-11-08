package com.nhsbsa.model;

import javax.validation.constraints.Future;
import java.util.Date;

/**
 * Created by Mark Lishman on 07/11/2016.
 */

public class TransferFormDate extends FormDate {

    @Future
    public Date getDate() {
        return super.getDate();
    }

}