package it.epicode.blogging.controller;

import it.epicode.blogging.models.AuthorRequest;
import it.epicode.blogging.models.CustomResponse;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

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

  @Autowired
  private Cloudinary cloudinary;

  @GetMapping
  public Page<Authors> getAll(Pageable pageable) {
    return authorsService.getAllAuthors(pageable);
  }

  @GetMapping("/{id}")
  public Authors getAuthorById(@PathVariable int id) throws NotFoundException {
    return authorsService.getById(id);
  }

  @PostMapping
  public Authors saveAuthor(@RequestBody AuthorRequest authorRequest) {
    return authorsService.saveAuthor(authorRequest);
  }

  @PutMapping("/{id}")
  public Authors updateAuthor(@PathVariable int id, @RequestBody AuthorRequest authorRequest) throws NotFoundException {
    return authorsService.updateAuthors(id, authorRequest);
  }

  @DeleteMapping("/{id}")
  public void deleteAuthor(@PathVariable int id) throws NotFoundException {
    authorsService.deleteAuthor(id);
  }

  @PatchMapping("/{id}/upload")
  public Authors updatePost(@PathVariable int id, @RequestParam("upload") MultipartFile file)
      throws IOException, NotFoundException {
    return authorsService.uploadAvatar(id,
        (String) cloudinary.uploader().upload(file.getBytes(), new HashMap()).get("url"));
  }

}
