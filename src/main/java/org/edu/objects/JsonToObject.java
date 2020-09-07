package org.edu.objects;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class JsonToObject {
    //Deserialization
    public void convertJsonToObject() {
        ObjectMapper om = new ObjectMapper();

        try (
                Patient patient = om.readValue(new File("src/main/resources/ObjectToJson.json"), Patient.class);) {
            System.out.println(patient.toString());
            System.out.println(patient.getDob());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        JsonToObject jo = new JsonToObject();
        jo.convertJsonToObject();
    }


}
