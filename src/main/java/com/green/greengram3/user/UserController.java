package com.green.greengram3.user;

import com.green.greengram3.user.model.UserSignupDto;
import com.green.greengram3.common.ResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;


    @PostMapping ("/signup")
    public ResVo postSignup(@RequestBody UserSignupDto dto){
        return service.postSignup(dto);
    }
}
