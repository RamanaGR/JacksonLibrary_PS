package org.edu.bindinglae;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes(
        {
                @Type(value = MemberChild.class, name = "MemberChild"),
                @Type(value = MemberAdult.class, name = "MemberAdult")
        }
)

public abstract class Member {
    private String dob;
    private String name;

    protected Member(String name, String dob) {
        this.setDob(dob);
        this.setName(name);
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
