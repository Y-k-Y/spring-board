package com.yk.board.Controller;

import com.yk.board.posts.service.PostsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@Api(value = "Main Controller", description = "load main page", basePath = "/")
public class MainController {

    private PostsService postsService;

    @GetMapping("/")
    @ApiOperation(value = "load main page", notes = "api which loads main page")
    public String main(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
}