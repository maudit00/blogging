package it.epicode.blogging.services;

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
  private AuthorsService authorsService;

  public Page<Posts> getAllPosts(Pageable pageable) {
    return postRepository.findAll(pageable);
  }

  public Posts getById(int id) throws NotFoundException {
    return postRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Autore con id=" + id + " non trovato!"));

  }

  public Posts savePost(PostRequest postRequest) throws NotFoundException {
    Authors autore = authorsService.getById(postRequest.getIdAuthor());

    Posts post = new Posts();
    post.setContenuto(postRequest.getContenuto());
    post.setCover(postRequest.getCover());
    post.setCategoria(postRequest.getCategoria());
    post.setTempodiLettura(postRequest.getTempodiLettura());
    post.setTitolo(postRequest.getTitolo());
    post.setAuthor(autore);
    return postRepository.save(post);
  }

  public Posts updatePosts(int id, PostRequest postRequest) throws NotFoundException {
    Authors autore = authorsService.getById(postRequest.getIdAuthor());

    Posts post = getById(id);
    post.setContenuto(postRequest.getContenuto());
    post.setCover(postRequest.getCover());
    post.setCategoria(postRequest.getCategoria());
    post.setTempodiLettura(postRequest.getTempodiLettura());
    post.setTitolo(postRequest.getTitolo());
    post.setAuthor(autore);
    return postRepository.save(post);
  }

  public void deletePost(int id) throws NotFoundException {
    Posts post = getById(id);
    postRepository.delete(post);
  }

  public Posts uploadCover(int id, String url) throws NotFoundException {
    Posts post = getById(id);
    post.setCover(url);
    return postRepository.save(post);
  }

}
