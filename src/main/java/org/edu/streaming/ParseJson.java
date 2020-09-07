package org.edu.streaming;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

public class ParseJson {
    public static void main(String[] args) throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser jsonParser = jsonFactory.createParser(new File(System.getProperty("user.dir")+"/src/main/resources/Generate.JSON"));

        while (jsonParser.nextToken() != null) {
            JsonToken token = jsonParser.getCurrentToken();
            //System.out.println(token);

            if(token.equals(JsonToken.FIELD_NAME)){
                String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                if(fieldName.equals("patient_object")){
                    while (jsonParser.nextToken() != JsonToken.END_OBJECT){
                        String nameField = jsonParser.getCurrentName();
                        jsonParser.nextToken();
                        if(nameField.equals("firstName")){
                            System.out.println("First Name : " + jsonParser.getValueAsString());
                        }else if (nameField.equals("lastName")){
                            System.out.println("last Name : " + jsonParser.getValueAsString());
                        }else if(nameField.equals("dob")){
                            System.out.println("dob : " + jsonParser.getValueAsString());
                        }
                    }
                }
                if(fieldName.equals("recent_visits_array")){
                    while (jsonParser.nextToken()!= JsonToken.END_ARRAY){
                        if(jsonParser.getCurrentToken().equals(JsonToken.START_OBJECT)){
                            while (jsonParser.nextToken() != JsonToken.END_OBJECT){
                                jsonParser.nextToken();
                                System.out.println(jsonParser.getValueAsString());
                            }
                        }else {
                            System.out.println(jsonParser.getValueAsString());
                        }
                    }
                }
            }
        }
        jsonParser.close();
    }
}