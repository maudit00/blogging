package it.epicode.blogging.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.epicode.blogging.models.Authors;
import it.epicode.blogging.models.Posts;
import it.epicode.blogging.services.PostService;
import it.epicode.blogging.services.AuthorsService;

@RestController
@RequestMapping("http://localhost:8080/")
/**
 * AuthorsController
 */
public class AuthorsController {

  @Autowired
  private AuthorsService authorsService;

  @GetMapping("authors")
  public List<Authors> getAll(){
    return authorsService.getAllAuthors();
  }

  @GetMapping("authors/{id}")
  public ResponseEntity<Authors> setSingleAuthor(@PathVariable int id) {
    try {
      Authors a = authorsService.getById(id);
      return new ResponseEntity<Authors>(a, HttpStatus.OK);
    } catch (NoSuchElementException e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("authors")
  public void saveAuthor(@RequestBody Authors author) {
    authorsService.savePost(author);
  }

  @PutMapping("authors/{id}")
  public Authors updateAuthor(@PathVariable int id, @RequestBody Authors author) {
    return authorsService.updateAuthors( id, author);
  }

  @DeleteMapping("posts/{id}")
  public void deleteAuthor(@PathVariable int id) {
    authorsService.deleteAuthor(id);
  }

}
