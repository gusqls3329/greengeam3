package com.green.greengram3.user;

import com.green.greengram3.user.model.UserEntity;
import com.green.greengram3.user.model.UserFlowDto;
import com.green.greengram3.user.model.UserSelDto;
import com.green.greengram3.user.model.UserSignupProcDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSignupProcDto p);
    UserEntity selUser(UserSelDto dto);
    int delFollow( UserFlowDto dto);
    int insFollow( UserFlowDto dto);
}
