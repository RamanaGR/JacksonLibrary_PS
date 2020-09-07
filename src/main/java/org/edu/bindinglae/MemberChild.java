package org.edu.bindinglae;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"age", "dob"})
public class MemberChild extends Member {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;
    //@JsonIgnore
    private String parent;

    public MemberChild(String name, String parent, int age, String dob) {
        super(name, dob);
        this.setParent(parent);
        this.setAge(age);
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }


}
