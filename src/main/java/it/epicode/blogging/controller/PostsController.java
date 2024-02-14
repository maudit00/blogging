package it.epicode.blogging.controller;

import java.util.List;
import java.util.NoSuchElementException;

import it.epicode.blogging.exceptions.NotFoundException;
import it.epicode.blogging.models.Authors;
import it.epicode.blogging.models.CustomResponse;
import it.epicode.blogging.models.PostRequest;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.epicode.blogging.models.Posts;
import it.epicode.blogging.services.PostService;

@RestController
@RequestMapping("/posts")
/**
 * PostsController
 */
public class PostsController {

  @Autowired
  private PostService postService;

  @GetMapping
  public Page<Posts> getAll(Pageable pageable) {
    return postService.getAllPosts(pageable);
  }

  @GetMapping("/{id}")
  public Posts getPostById(@PathVariable int id) throws NotFoundException {
    return postService.getById(id);
  }

  @PostMapping
  public Posts savePost(@RequestBody PostRequest postRequest) throws NotFoundException{
    return postService.savePost(postRequest);
  }

  @PutMapping("/{id}")
  public Posts updatePost(@PathVariable int id, @RequestBody PostRequest postRequest) throws NotFoundException{
   return postService.updatePosts(id,postRequest) ;
  }
  @DeleteMapping("/{id}")
  public void deletePost(@PathVariable int id) throws NotFoundException {
    postService.deletePost(id);
  }

  }
