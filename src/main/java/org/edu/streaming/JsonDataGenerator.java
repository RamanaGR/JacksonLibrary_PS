package org.edu.streaming;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.edu.objects.Patient;

import java.io.File;
import java.io.IOException;

public class JsonDataGenerator {
        public static void main(String[] args) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            JsonFactory jsonFactory = new JsonFactory();
            JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File(System.getProperty("user.dir")+"/src/main/resources/Generate.JSON"), JsonEncoding.UTF8);
            JsonGenerator jsonGenerator1 = jsonFactory.createGenerator(System.out);

            jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
            jsonGenerator.setCodec(mapper);

            jsonGenerator.writeStartObject();

            jsonGenerator.writeFieldName("first_name");
            jsonGenerator.writeString("Jean-Marc");
            jsonGenerator.writeFieldName("last_name");
            jsonGenerator.writeString("Jullien");

            jsonGenerator.writeStringField("dob", "3/4/2019");


            Patient patient = new Patient();
            patient.setFirstName("Jean-Marc");
            patient.setLastName("Julien");
            patient.setDob("5/12/1983");

            jsonGenerator.writeFieldName("patient_object");
            jsonGenerator.writeObject(patient);

            jsonGenerator.writeFieldName("recent_visits_array");
            jsonGenerator.writeStartArray();
            jsonGenerator.writeString("5/1/2019");
            jsonGenerator.writeString("5/2/3576");
            jsonGenerator.writeString("5/3/2019");
            jsonGenerator.writeEndArray();

            jsonGenerator.writeEndObject();
            jsonGenerator.close();
        }

}
