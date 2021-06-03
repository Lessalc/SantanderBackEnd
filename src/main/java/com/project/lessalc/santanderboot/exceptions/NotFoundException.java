package com.project.lessalc.santanderboot.exceptions;

import com.project.lessalc.santanderboot.util.MessageUtils;

public class NotFoundException extends RuntimeException {
    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }

}
