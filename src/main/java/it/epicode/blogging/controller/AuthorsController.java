package it.epicode.blogging.controller;

import it.epicode.blogging.models.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.epicode.blogging.exceptions.NotFoundException;
import it.epicode.blogging.models.Authors;
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
  public ResponseEntity<CustomResponse> getAll(Pageable pageable) {
    try {
      return CustomResponse.success(HttpStatus.OK.toString(), authorsService.getAllAuthors(pageable), HttpStatus.OK);
    } catch (Exception e) {
      return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomResponse> getAuthorById(@PathVariable int id) {
    try {
      return CustomResponse.success(HttpStatus.OK.toString(), authorsService.getById(id), HttpStatus.OK);
    } catch (NotFoundException e) {
      return CustomResponse.error(e.getMessage(), HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<CustomResponse> saveAuthor(@RequestBody Authors author) {
    try {
      return CustomResponse.success(HttpStatus.OK.toString(), authorsService.saveAuthor(author), HttpStatus.OK);
    } catch (Exception e) {
      return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<CustomResponse> updateAuthor(@PathVariable int id, @RequestBody Authors author) {
    try {
      return CustomResponse.success(HttpStatus.OK.toString(), authorsService.updateAuthors(id, author), HttpStatus.OK);
    } catch (NotFoundException e) {
      return CustomResponse.error(e.getMessage(), HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CustomResponse> deleteAuthor(@PathVariable int id) {
    try {
      authorsService.deleteAuthor(id);
      return CustomResponse.emptyResponse("Autore con id=" + id + " cancellato", HttpStatus.OK);
    } catch (NotFoundException e) {
      return CustomResponse.error(e.getMessage(), HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return CustomResponse.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
