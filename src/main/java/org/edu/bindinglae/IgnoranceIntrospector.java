package org.edu.bindinglae;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

class IgnoranceIntrospector extends JacksonAnnotationIntrospector {
    public boolean hasIgnoreMarker(AnnotatedMember member) {
        return member.getDeclaringClass() == Member.class && member.getName().equals("dob")
                || member.getDeclaringClass() == MemberChild.class
                && member.getName().equals("parent")
                || super.hasIgnoreMarker(member);
    }
}
