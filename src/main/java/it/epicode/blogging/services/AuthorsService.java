package it.epicode.blogging.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.epicode.blogging.models.Authors;

@Service
/**
 * AuthorsService
 */
public class AuthorsService {

  public List<Authors> authors = new ArrayList<>();

  public List<Authors> getAllAuthors() {
    return authors;
  }

  public Authors getById(int id) throws NoSuchElementException {
    Optional<Authors> p = authors.stream().filter(posts -> posts.getId() == id).findAny();

    if (p.isPresent()) {
      return p.get();
    } else {
      throw new NoSuchElementException("Autore non trovato");
    }
  }

  public void saveAuthor(Authors author) {
    authors.add(author);
  }

  public Authors updateAuthors(int id, Authors authors) {
    Authors a = getById(id);

    a.setNome(authors.getNome());
    a.setCognome(authors.getCognome());
    a.setEmail(authors.getEmail());
    a.setDataDiNascita(authors.getDataDiNascita());
    return a;
  }

  public void deleteAuthor(int id) {
    Authors a = getById(id);
    authors.remove(a);
  }

}
