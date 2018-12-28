package com.yk.board.posts.service;

import com.yk.board.posts.domain.Posts;
import com.yk.board.posts.dto.PostsDTO;
import com.yk.board.posts.repository.PostsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    PostsService postsService;

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void savePosts(){

        // given
        PostsDTO postsDTO = PostsDTO.builder()
                            .title("안녕하세요")
                            .content("반갑습니다.")
                            .author("윤여경")
                            .build();

        // when
        postsService.save(postsDTO);

        // then
        List<Posts> list = postsService.getAllPosts();
        Posts posts = list.get(0);
        assertThat(posts.getTitle()).isEqualTo(postsDTO.getTitle());
        assertThat(posts.getContent()).isEqualTo(postsDTO.getContent());
        assertThat(posts.getAuthor()).isEqualTo(postsDTO.getAuthor());
    }

    @Test
    public void deletePosts(){

        // when
        postsService.delete(14L);

        // then
        assertThat(postsRepository.count()).isEqualTo(14L);
    }
}