package com.yk.board.posts.service;

import com.yk.board.posts.domain.Posts;
import com.yk.board.posts.dto.PostsDTO;

import java.util.List;

public interface PostsService {

    public List<Posts> getAllPosts();
    public List<PostsDTO> findAllDesc();
    public void save(PostsDTO postsDTO);
    public void delete(Long id);
    public void modify(PostsDTO postsDTO, Long id);
}
