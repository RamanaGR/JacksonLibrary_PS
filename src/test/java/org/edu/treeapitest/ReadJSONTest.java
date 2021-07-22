package org.edu.treeapitest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.edu.treeapi.ReadJSON;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadJSONTest {
    ReadJSON rj;
    JsonNode root;

    @BeforeMethod
    public void setup() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        root = mapper.readTree(new File("C:\\Users\\chinn\\IdeaProjects\\JacksonLibrary\\src\\main\\resources\\TreeRead.JSON"));
        rj = new ReadJSON();
    }

    @Test(priority = 0)
    public void shouldGetSingleValue() throws IOException {
        String actual = root.get("middleName").asText();
        String expected = "Adam";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void shouldGetArrayOfValuesAsList() throws IOException {
        List<String> actual = new ArrayList<>();
        JsonNode arrayOfBp = root.get("recentVisits");
        if (arrayOfBp.isArray()) {
            for (JsonNode jsonNode : arrayOfBp) {
                actual.add(jsonNode.asText());
            }
        }

        List<String> expected = List.of("1/29/2018", "4/19/201", "9/13/2018");
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 2)
    public void shouldGetSingleValueFromObject() throws IOException {
        String actual = null;
        JsonNode primaryDoctor = root.get("primaryDoctor");
        if (primaryDoctor.isObject()) {
            actual = primaryDoctor.get("lastName").asText();
        }
        String expected = "Greene";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 3)
    public void shouldGetListOfObjects() throws IOException {
        List<String> actual = new ArrayList<>();
        JsonNode arrayOfDoctors = root.get("specialistDoctors");
        for (JsonNode jsonNode : arrayOfDoctors) {
            actual.add("id : " + jsonNode.get("id").asText()
                    + " firstName : " + jsonNode.get("firstName").asText()
                    + " lastName : " + jsonNode.get("lastName").asText());
        }
        System.out.println(actual);
        List<String> expected = List.of("id : 2 firstName : Mike lastName : Brown", "id : 3 firstName : Michelle lastName : Greene");
        Assert.assertEquals(actual, expected);
    }

}
