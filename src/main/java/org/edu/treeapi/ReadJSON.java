package org.edu.treeapi;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadJSON {
    private static JsonNode root;

//    @BeforeMethod
//    public void setUp() throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        root = mapper.readTree(new File(System.getProperty("user.dir")+"/src/main/resources/TreeRead.JSON"));
//        ReadJSON rj = new ReadJSON();
//    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        root = mapper.readTree(new File(System.getProperty("user.dir") + "/src/main/resources/TreeRead.JSON"));
        ReadJSON rj = new ReadJSON();
        System.out.println(rj.getSingleValue("middleName"));//Adam
        System.out.println(rj.getArrayOfValues("recentVisits")); // ["1/29/2018", "4/19/2018", "9/13/2018"]
        System.out.println(rj.getValueFromObject("primaryDoctor", "lastName"));//Greene
        System.out.println(rj.getListOfObject("specialistDoctors"));
    }

    public String getSingleValue(String key) throws IOException {
        String value = root.get(key).asText();
        return ("Value of " + key + " is : " + value);
    }

    public List<String> getArrayOfValues(String keyOfArray) {
        ArrayList<String> al = new ArrayList<>();

        JsonNode arrayOfVisites = root.get(keyOfArray);
        if (arrayOfVisites.isArray()) {
            for (JsonNode jsonNode : arrayOfVisites) {
                al.add(jsonNode.asText());
            }
            return al;
        }
        return List.of(root.get(keyOfArray).asText());
    }

    public String getValueFromObject(String rootKey, String key) {
        JsonNode primaryDoctor = root.get(rootKey);
        if (primaryDoctor.isObject()) {
            return primaryDoctor.get(key).asText();
        }
        System.out.println("Id :" + primaryDoctor.get("id").asText());
        System.out.println("First Name :" + primaryDoctor.get("firstName").asText());
        System.out.println("Last Name :" + primaryDoctor.get("lastName").asText());
        return primaryDoctor.asText();
    }

    public List<String> getListOfObject(String key) {
        ArrayList<String> al = new ArrayList<>();
        JsonNode arrayOfDoctors = root.get(key);
        for (JsonNode jsonNode : arrayOfDoctors) {
            al.add(("id : " + jsonNode.get("id").asText()
                    + " firstName : " + jsonNode.get("firstName").asText()
                    + " lastName : " + jsonNode.get("lastName").asText()));
        }

        return al;
    }
}




