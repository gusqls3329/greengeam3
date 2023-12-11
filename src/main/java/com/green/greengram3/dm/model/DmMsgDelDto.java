package com.green.greengram3.dm.model;

import lombok.Data;

@Data
public class DmMsgDelDto {
    private int idm;
    private int iuser; //내가 쓴글인지 확인하기 위해
    private int seq;
}
