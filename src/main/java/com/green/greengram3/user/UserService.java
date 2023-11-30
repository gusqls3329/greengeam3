package com.green.greengram3.user;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.UserSignupDto;
import com.green.greengram3.user.model.UserSignupProcDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public ResVo postSignup(UserSignupDto dto){
        String hashedPw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt());
        UserSignupProcDto pDto = new UserSignupProcDto();
        pDto.setUid(dto.getUid());
        pDto.setUpw(hashedPw);
        pDto.setNm(dto.getNm());
        pDto.setPic(dto.getPic());


        int affectedRows = mapper.insUser(pDto); //예외처리 : if가 0일 때 오류난거라는걸 알려고

        return new ResVo(pDto.getIuser());
    }
}
