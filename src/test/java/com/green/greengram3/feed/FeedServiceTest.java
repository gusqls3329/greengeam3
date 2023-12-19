package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import({FeedService.class})
class FeedServiceTest {

    @MockBean //가짜 빈
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
    }

    @Test
    void delFeed() {
    }

    @Test
    void toggleFeedFav() {
    }
}