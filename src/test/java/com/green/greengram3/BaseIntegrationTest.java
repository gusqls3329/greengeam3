package com.green.greengram3;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Import(CharEncodingConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //렌덤한 포트를 이용해서
@AutoConfigureMockMvc
@Transactional //트랜젝션 걸때사용
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //DB를 바꾸지 않겠다
public class BaseIntegrationTest { //컨트롤러, 서비스, 메퍼까지 테스트함
    @Autowired protected MockMvc mvc;
    @Autowired protected ObjectMapper om;
}
