package org.edu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.edu.objects.Patient;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ConversionTest {
    private ObjectMapper mapper;

    @BeforeTest
    public void init() {
        mapper = new ObjectMapper();
    }

    @Test
    public void convertJavaToJSON() throws IOException {

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Patient patient = new Patient();
        patient.setFirstName("Jean-Marc");
        patient.setLastName("Jullien");
        patient.setDob("1991-02-03");
        patient.setAddress("Chicago");
        patient.setState("IL");
        patient.setZip("54321");
        patient.setPhone("555-123-9876");

        mapper.writeValue(new File(System.getProperty("user.dir") + "/src/main/resources/ObjectToJson.json"), patient);
    }

    @Test
    public void convertJsonToJava() throws IOException {
        Patient readPatient = mapper.readValue(new File(System.getProperty("user.dir") + "/src/main/resources/ObjectToJson.json"), Patient.class);
        System.out.println(readPatient);
    }
}
