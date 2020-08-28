package org.edu.bindingdates;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomeDateSerialize extends StdSerializer<Date> {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm");

    public CustomeDateSerialize(Class<Date> t) {
        super(t);
    }

    public CustomeDateSerialize() {
        this(null);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(sdf.format(date) + "(Chicago Local Time)");
    }
}
