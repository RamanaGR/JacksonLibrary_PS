package org.edu.treeapi;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class WriteJSON {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(new File(System.getProperty("user.dir")+"/src/main/resources/TreeWrite.JSON"));

        //Removing one property
        ((ObjectNode)root).remove("middleName");
        //Adding one property
        ((ObjectNode)root).put("nickName", "Jane");

        //Adding an array
        ((ObjectNode)root).putArray("recentWeight");
        ((ObjectNode)root).withArray("recentWeight").add("180");
        ((ObjectNode)root).withArray("recentWeight").add("184");
        ((ObjectNode)root).withArray("recentWeight").add("182");

        //Removing array
        ((ObjectNode)root).withArray("recentWeight").removeAll();

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
    }

}
