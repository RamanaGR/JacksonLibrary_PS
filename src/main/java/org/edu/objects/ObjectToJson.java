package org.edu.objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class ObjectToJson {
    public void convertJavaObjectToJson() {
        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);
        Patient patient = new Patient();
        patient.setFirstName("Ramana");
        patient.setLastName("Vedang");
        patient.setDob("1995-04-04");
        patient.setPhone("9505014847");
        patient.setAddress("BVRM");
        patient.setCity("BVRM-3");
        patient.setState("AP");
        patient.setZip("534201");
        try {
            om.writeValue(new File("src/main/resources/ObjectToJson.json"), patient);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ObjectToJson oj = new ObjectToJson();
        oj.convertJavaObjectToJson();
    }
}
