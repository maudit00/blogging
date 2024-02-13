package it.epicode.blogging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import it.epicode.blogging.models.Posts;
import it.epicode.blogging.services.PostService;

@RestController
@RequestMapping("http://localhost:8080/")
/**
 * PostsController
 */
public class PostsController {

  @Autowired
  private PostService postService;

  @GetMapping("posts")
  public List<Posts> getAll(){
    return postService.getAllPosts()
  }

  @GetMapping("posts/{id}")
  public List<Posts> getSinglePost(@PathVariable int id) {
    return postService.getById();
  }

  @PostMapping("posts")
  public void savePost(@RequestBody Posts post) {
    postService.savePost(post);
  }

  @PutMapping("posts/{id}")
  public Posts updatePost(@PathVariable int id, Posts post) {
    return postService.updatePosts(id, post);
  }

  @DeleteMapping("posts/{id}")
  public void deletePost(@PathVariable int id) {
    postService.deletePost(id);
  }

}
