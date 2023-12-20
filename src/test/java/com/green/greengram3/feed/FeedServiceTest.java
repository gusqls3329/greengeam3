package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsDto;
import com.green.greengram3.feed.model.FeedSelDto;
import com.green.greengram3.feed.model.FeedSelVo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class) // 스프링컨테이너를 사용할 수 있도록
@Import({FeedService.class}) // 특정한 class를 사용 할 수 있도록 빈등록
//만약 위 두 어노테이션이 없다면,아래  @Autowired service를 사용할 수 없다.
class FeedServiceTest {

    @MockBean //가짜 빈을 만들어서 객체의 주소값을 service에 밀어 줄수 있도록
    private FeedMapper mapper;

    @MockBean
    private FeedPicsMapper picsMapper;

    @MockBean
    private FeedFavMapper favMapper;

    @MockBean
    private FeedCommentMapper commentMapper;

    @Autowired
    private FeedService service;

    @Test
    void postFeed() {
        when(mapper.insFeed(any())).thenReturn(1);
        when(picsMapper.insFeedPics(any())).thenReturn(3);

        FeedInsDto dto = new FeedInsDto();
        dto.setIfeed(110);
        ResVo vo = service.postFeed(dto);
        assertEquals(dto.getIfeed(),vo.getResult());

        verify(mapper).insFeed(any()); //안의 메소드 호출했는지 확인
        verify(picsMapper).insFeedPics(any());

        FeedInsDto dto2 = new FeedInsDto();
        dto.setIfeed(200);
        ResVo vo2 = service.postFeed(dto2);
        assertEquals(dto2.getIfeed(),vo2.getResult());

    }

    @Test
    void getFeedAll() {
        FeedSelVo feedSelVo1 = new FeedSelVo();
        feedSelVo1.setIfeed(1);
        feedSelVo1.setContents("1번 feedSelVo");

        FeedSelVo feedSelVo2 = new FeedSelVo();
        feedSelVo2.setIfeed(2);
        feedSelVo2.setContents("2번 feedSelVo");

        List<FeedSelVo> list = new ArrayList<>();
        list.add(feedSelVo1);
        list.add(feedSelVo2);

        when(mapper.selFeedAll(any())).thenReturn(list);

        List<String> feed1Pics = Arrays.stream(new String[]{"a.jpg","b.jpg"}).toList(); //배열을 리스트로 변경

        List<String> feed2Pics = new ArrayList<>();
        feed2Pics.add("가.jpg");
        feed2Pics.add("나.jpg");
        when( picsMapper.selFeedPicsAll(1)).thenReturn(feed1Pics);
        when( picsMapper.selFeedPicsAll(2)).thenReturn(feed2Pics);

        FeedSelDto dto  = new FeedSelDto();
        List<FeedSelVo> result = service.getFeedAll(dto);

        assertEquals(list,result); //ture라면 list만 검증하기

        for (FeedSelVo vo : list) {
            assertNotNull(vo.getPics()); // pics에 값이 잘 담아졌는지 확인

        }
    }

    @Test
    void delFeed() {
    }

    @Test
    void toggleFeedFav() {
    }
}