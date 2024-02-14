package it.epicode.blogging.services;



import it.epicode.blogging.exceptions.NotFoundException;
import it.epicode.blogging.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.blogging.models.Authors;

@Service
/**
 * AuthorsService
 */
public class AuthorsService {

  @Autowired
  private AuthorsRepository authorsRepository;

  public Page<Authors> getAllAuthors(Pageable pageable) {
    return authorsRepository.findAll(pageable);
  }

  public Authors getById(int id) throws NotFoundException {
    return authorsRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Autore con id=" + id + " non trovato"));
  }

  public Authors saveAuthor(Authors author) {
    return authorsRepository.save(author);
  }

  public Authors updateAuthors(int id, Authors authors) throws NotFoundException {
    Authors autore = getById(id);

    autore.setNome(authors.getNome());
    autore.setCognome(authors.getEmail());
    autore.setEmail(authors.getEmail());
    autore.setAvatar(authors.getAvatar());
    autore.setDataDiNascita(authors.getDataDiNascita());
    return authorsRepository.save(autore);
  }

  public void deleteAuthor(int id) throws NotFoundException {
    Authors a = getById(id);
    authorsRepository.delete(a);
  }

}
