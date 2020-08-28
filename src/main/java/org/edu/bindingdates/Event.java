package org.edu.bindingdates;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Event {
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd hh:mm")
    private Date dob;
    public Event() {
    }


    public Event(String birthDate, Date date) {
        this.dob = date;
        this.name = birthDate;
    }
}
