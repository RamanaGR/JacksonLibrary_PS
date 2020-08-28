package org.edu.bindinglae;

public class MemberAdult extends Member {
    private String memberId;

    public String getMemberId() {
        return memberId;
    }

    public MemberAdult(String dob, String name, String memberId) {
        super(name, dob);
        this.memberId = memberId;

    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
