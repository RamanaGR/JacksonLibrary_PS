package org.edu.bindingdates;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class EventJsonSerialize {
    private String birthDate;
    @JsonSerialize(using = CustomeDateSerialize.class)
    private Date dob;

    public EventJsonSerialize(String birthDate, Date date) {
        this.birthDate = birthDate;
        this.dob = date;
    }


    public EventJsonSerialize() {
    }
}
