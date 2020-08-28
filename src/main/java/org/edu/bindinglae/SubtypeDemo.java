package org.edu.bindinglae;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class SubtypeDemo {
    public static void main(String[] args) {
        try {
            ObjectMapper om = new ObjectMapper();
            //om.enableDefaultTyping();
            //om.addMixIn(MemberChild.class,MemberMixIn.class);
            om.setAnnotationIntrospector(new IgnoranceIntrospector());
            om.enable(SerializationFeature.INDENT_OUTPUT);
            MemberAdult adult = new MemberAdult("5/29/87", "John smith", "1234567");
            MemberChild child = new MemberChild("Tommy smith", "John Smith", 5, "3/4/2014");
            List<Member> memberList = new ArrayList<>();
            memberList.add(child);
            memberList.add(adult);
            Patients serializedPatients = new Patients();
            serializedPatients.setMembers(memberList);
            String jsonDataString = om.writeValueAsString(serializedPatients);
            System.out.println(jsonDataString);
        } catch (JsonProcessingException ignored) {
        } catch (IOException ex) {
        }
    }
}
