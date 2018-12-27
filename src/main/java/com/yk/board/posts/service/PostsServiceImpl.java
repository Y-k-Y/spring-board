package com.yk.board.posts.service;

import com.yk.board.posts.domain.Posts;
import com.yk.board.posts.dto.PostsDTO;
import com.yk.board.posts.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostsServiceImpl implements PostsService{

    PostsRepository postsRepository;

    @Override
    public List<Posts> getAllPosts() {

        return postsRepository.findAll();
    }

    @Override
    @Transactional
    public void save(PostsDTO postsDTO) {

        postsRepository.save(postsDTO.toEntity());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostsDTO> findAllDesc(){

        return postsRepository.findAllDesc()
                .map(PostsDTO::new)
                .collect(Collectors.toList());
    }
}
