package it.epicode.blogging.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.blogging.models.Authors;
import it.epicode.blogging.models.Posts;

@Service
/**
 * PostService
 */
public class PostService {
  @Autowired
  private AuthorsService authorService;

  private List<Posts> posts = new ArrayList<>();

  public List<Posts> getAllPosts() {
    return posts;
  }

  public Posts getById(int id) throws NoSuchElementException {
    Optional<Posts> p = posts.stream().filter(posts -> posts.getId() == id).findAny();

    if (p.isPresent()) {
      return p.get();
    } else {
      throw new NoSuchElementException("Post non trovato");
    }
  }

  public void savePost(Posts post) {
    posts.add(post);
  }

  public Posts updatePosts(int id, Posts post) throws NoSuchElementException{

    Posts p = getById(id);
    Authors a = authorService.getById(post.getAuthor().getId());
    if (a == null){
      throw new NoSuchElementException("Autore non trovato");
    }

    p.setTitolo(post.getTitolo());
    p.setCategoria(post.getCategoria());
    p.setContenuto(post.getContenuto());
    p.setCover(post.getCover());
    p.setTempodiLettura(post.getTempodiLettura());

    return p;
  }

  public void deletePost(int id) {
    Posts p = getById(id);
    posts.remove(p);
  }

}
