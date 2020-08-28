package org.edu.bindinglae;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum HeightClass {
    INCH("inches", 2.54),

    CENTIMETER("cm", 0.3937101);

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @JsonValue
    public double getLength() {
        return length;
    }

    private HeightClass(String unit, double length) {
        this.unit = unit;
        this.length = length;
    }


    private String unit;
    private final double length;

    public static void main(String[] args) {
        ObjectMapper om = new ObjectMapper();
        try {
            System.out.println(om.writeValueAsString(HeightClass.INCH));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

    }
}
