package com.green.greengram3.user.model;

import lombok.Data;

@Data
public class UserInfoVo {
    private int feedCnt; //등록한 피드수
    private int favCnt; //내가 받은 좋아요수
    private String nm;
    private String createdAt;
    private String pic;
    private int follower; // 팔로우수 (targetIuser를 팔로우한 상황) 1
    private int following; // 팔로잉 (targetIuser가 팔로우한 상황) 2
    private int followState;
    /*
    1. loginedIuser가 targetIuser를 팔로우한 상황
    2.  targetIuser가 loginedIuser를 팔로우만 한 상황
    3. 둘다 팔로우 한 상황
     */
}
