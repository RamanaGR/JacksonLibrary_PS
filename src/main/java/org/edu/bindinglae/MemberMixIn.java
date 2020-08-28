package org.edu.bindinglae;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MemberMixIn {
    @JsonIgnore
    private String name;
    @JsonIgnore
    private String age;
}
