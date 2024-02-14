package it.epicode.blogging.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import it.epicode.blogging.repository.AuthorsRepository;
import it.epicode.blogging.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.blogging.exceptions.NotFoundException;
import it.epicode.blogging.models.Authors;
import it.epicode.blogging.models.PostRequest;
import it.epicode.blogging.models.Posts;

@Service
/**
 * PostService
 */
public class PostService {
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private AuthorsRepository authorsRepository;

  public Page<Posts> getAllPosts(Pageable pageable) {
    return postRepository.findAll(pageable);
  }

  public Posts getById(int id) throws NotFoundException {
    return postRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Autore con id=" + id + " non trovato!"));

  }

  public void savePost(PostRequest postRequest) {
    Authors autore = authorsRepository.getAuthorsById(postRequest.getIdAuthor());

    Posts post = new Posts();
    post.setContenuto(postRequest.getContenuto());
    post.setCover(postRequest.getCover());
    post.setCategoria(postRequest.getCategoria());
    post.setTempodiLettura(postRequest.getTempodiLettura());
    post.setTitolo(postRequest.getTitolo());
    post.setAuthor(autore);
  }

  public Posts updatePosts(int id, Posts post) throws NotFoundException {
    Authors autore = authorsRepository.(postRequest.getIdAuthor());

    Posts p = new Posts();

  }

  public void deletePost(int id)  {
  }

}
