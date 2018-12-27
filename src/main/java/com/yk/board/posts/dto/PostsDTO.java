package com.yk.board.posts.dto;

import com.yk.board.posts.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class PostsDTO {

    private Long id;
    private String title;
    private String content;
    private String author;
    private Timestamp updateDate;

    @Builder
    public PostsDTO(String title, String content, String author) {

        this.title = title;
        this.content = content;
        this.author = author;
    }

    public PostsDTO(Posts posts) {
        id = posts.getId();
        title = posts.getTitle();
        author = posts.getAuthor();
        updateDate = posts.getUpdateDate();
    }



    public Posts toEntity() {

        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
