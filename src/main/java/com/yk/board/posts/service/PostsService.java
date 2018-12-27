package com.yk.board.posts.service;

import com.yk.board.posts.domain.Posts;
import com.yk.board.posts.dto.PostsDTO;

import java.util.List;

public interface PostsService {

    public List<Posts> getAllPosts();
    public void save(PostsDTO postsDTO);
    public List<PostsDTO> findAllDesc();
}
