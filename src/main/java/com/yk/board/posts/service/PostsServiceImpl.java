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
    @Transactional(readOnly = true)
    public List<PostsDTO> findAllDesc(){

        return postsRepository.findAllDesc()
                .map(PostsDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(PostsDTO postsDTO) {

        postsRepository.save(postsDTO.toEntity());
    }

    @Override
    @Transactional
    public void delete(Long id) {

        postsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void modify(PostsDTO postsDTO, Long id) {

        Posts posts = postsRepository.getOne(id);
        posts.modify(postsDTO.getTitle(), postsDTO.getContent(), postsDTO.getAuthor());
    }
}