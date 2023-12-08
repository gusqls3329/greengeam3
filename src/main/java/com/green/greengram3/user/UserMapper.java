package com.green.greengram3.user;

import com.green.greengram3.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSignupProcDto p);
    UserEntity selUser(UserSelDto dto);
    int delFollow( UserFlowDto dto);
    int insFollow( UserFlowDto dto);
    UserInfoVo selUserInfo(UserInfoSelDto dto);
}
