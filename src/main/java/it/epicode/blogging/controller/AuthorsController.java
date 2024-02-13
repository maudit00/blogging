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
@RequestMapping("/authors")
/**
 * AuthorsController
 */
public class AuthorsController {

  @Autowired
  private AuthorsService authorsService;

  @GetMapping
  public List<Authors> getAll(){
    return authorsService.getAllAuthors();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Authors> setSingleAuthor(@PathVariable int id) {
    try {
      Authors a = authorsService.getById(id);
      return new ResponseEntity<Authors>(a, HttpStatus.OK);
    } catch (NoSuchElementException e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public void saveAuthor(@RequestBody Authors author) {
    authorsService.saveAuthor(author);
  }

  @PutMapping("/{id}")
  public Authors updateAuthor(@PathVariable int id, @RequestBody Authors author) {
    return authorsService.updateAuthors( id, author);
  }

  @DeleteMapping("/{id}")
  public void deleteAuthor(@PathVariable int id) {
    authorsService.deleteAuthor(id);
  }

}
