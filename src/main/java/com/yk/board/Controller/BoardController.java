package com.yk.board.Controller;

import com.yk.board.posts.dto.PostsDTO;
import com.yk.board.posts.service.PostsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Api(value = "board Controller", description = "board manipulation api", basePath = "/board")
public class BoardController {

    PostsService postsService;

    @PostMapping("/board/posts")
    @ApiOperation(value = "save posts", notes = "api which save posts")
    public void savePosts(@RequestBody PostsDTO postsDTO){

        postsService.save(postsDTO);
    }
}
