package it.epicode.blogging.controller;

import java.util.List;
import java.util.NoSuchElementException;

import it.epicode.blogging.models.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.epicode.blogging.models.Posts;
import it.epicode.blogging.services.PostService;

@RestController
@RequestMapping("/post")
/**
 * PostsController
 */
public class PostsController {

  @Autowired
  private PostService postService;

  @GetMapping()
  public List<Posts> getAll() {
    return postService.getAllPosts();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Posts> getSinglePost(@PathVariable int id) {
    try {
      Posts p = postService.getById(id);
      return new ResponseEntity<Posts>(p, HttpStatus.OK);
    } catch (NoSuchElementException e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping()
  public void savePost(@RequestBody Posts post) {
    postService.savePost(post);
  }

  @PutMapping("/{id}")
  public Posts updatePost(@PathVariable int id, @RequestBody Posts post) {

    return postService.updatePosts(id, post);
  }

  @DeleteMapping("/{id}")
  public void deletePost(@PathVariable int id) {
    postService.deletePost(id);
  }

}
