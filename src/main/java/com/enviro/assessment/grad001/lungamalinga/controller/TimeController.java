package com.enviro.assessment.grad001.lungamalinga.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// format the time for when inn inputing data in the database [logs]
public class TimeController {

    String formattedNow;

    public TimeController(){
        /**
         * get current time and date then format it
         */
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formattedNow = now.format(formatter);
    }

    public String getFormattedNow() {
        return formattedNow;
    }
}
