package it.epicode.blogging.controller;

import java.util.List;
import java.util.NoSuchElementException;

import it.epicode.blogging.exceptions.NotFoundException;
import it.epicode.blogging.models.Authors;
import it.epicode.blogging.models.CustomResponse;
import it.epicode.blogging.models.PostRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
  public ResponseEntity<CustomResponse> getAll(Pageable pageable) {
    try {
      return CustomResponse.success(HttpStatus.OK.toString(), postService.getAllPosts(pageable), HttpStatus.OK);
    } catch (Exception e) {
      return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomResponse> getPostById(@PathVariable int id) {
    try {
      return CustomResponse.success(HttpStatus.OK.toString(), postService.getById(id), HttpStatus.OK);
    } catch (NotFoundException e) {
      return CustomResponse.error(e.getMessage(), HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<CustomResponse> savePost(@RequestBody PostRequest postRequest) {
    try {
      return CustomResponse.success(HttpStatus.OK.toString(), postService.savePost(postRequest), HttpStatus.OK);
    } catch (Exception e) {
      return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<CustomResponse> updatePost(@PathVariable int id, @RequestBody PostRequest postRequest){
    try {
      return CustomResponse.success(HttpStatus.OK.toString(), postService.updatePosts(id, postRequest), HttpStatus.OK);
    }
    catch (NotFoundException e){
      return CustomResponse.error(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    catch (Exception e){
      return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<CustomResponse> deletePost(@PathVariable int id) {
    try {
      postService.deletePost(id);
      return CustomResponse.emptyResponse("Post con id=" + id + " cancellato", HttpStatus.OK);
    } catch (NotFoundException e) {
      return CustomResponse.error(e.getMessage(), HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  }
