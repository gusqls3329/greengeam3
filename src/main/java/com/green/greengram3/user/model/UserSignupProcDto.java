package com.green.greengram3.user.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class UserSignupProcDto {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private String pic;
}
