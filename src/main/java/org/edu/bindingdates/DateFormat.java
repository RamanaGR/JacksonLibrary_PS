package org.edu.bindingdates;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.edu.objects.Patient;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public void dateFormatWithObjectMapper() throws Exception {
        ObjectMapper om = new ObjectMapper();
        try (
                Patient patient = om.readValue(new File("src/main/resources/ObjectToJson.json"), Patient.class);) {
            System.out.println(patient.toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            System.out.println("printing sdf : -- " + sdf);
            om.setDateFormat(sdf);
            System.out.println("printing sdf after setdateformat : -- " + sdf.toString());
            Date date = sdf.parse(patient.getDob());
            // Event event = new Event("BirthDate",date);
            EventJsonSerialize event = new EventJsonSerialize("BirthDate", date);
            System.out.println(date);
            System.out.println(om.writeValueAsString(event));
        }
    }

    public static void main(String[] args) throws Exception {
        DateFormat df = new DateFormat();
        df.dateFormatWithObjectMapper();
    }
}
