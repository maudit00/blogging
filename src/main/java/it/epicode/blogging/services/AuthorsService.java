package it.epicode.blogging.services;

import it.epicode.blogging.exceptions.NotFoundException;
import it.epicode.blogging.models.AuthorRequest;
import it.epicode.blogging.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import it.epicode.blogging.models.Authors;

@Service
/**
 * AuthorsService
 */
public class AuthorsService {

  @Autowired
  private AuthorsRepository authorsRepository;
  @Autowired
  private JavaMailSenderImpl javaMailSenderImpl;

  public Page<Authors> getAllAuthors(Pageable pageable) {
    return authorsRepository.findAll(pageable);
  }

  public Authors getById(int id){
    return authorsRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Autore con id=" + id + " non trovato"));
  }

  public Authors saveAuthor(AuthorRequest authorRequest) {
    Authors autore = new Authors(authorRequest.getNome(), authorRequest.getCognome(), authorRequest.getEmail(),
        authorRequest.getDatadiNascita());
    sendMail(autore.getEmail());
    return authorsRepository.save(autore);
  }

  public Authors updateAuthors(int id, AuthorRequest authorRequest){
    Authors autore = getById(id);

    autore.setNome(authorRequest.getNome());
    autore.setCognome(authorRequest.getCognome());
    autore.setEmail(authorRequest.getEmail());
    autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
    autore.setDataDiNascita(authorRequest.getDatadiNascita());
    return authorsRepository.save(autore);
  }

  public void deleteAuthor(int id){
    Authors a = getById(id);
    authorsRepository.delete(a);
  }

  private void sendMail(String email) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(email);
    message.setSubject("Registrazione Servizio bruca");
    message.setText("Registrazione al servizio bruca avvenuta con successo");

    javaMailSenderImpl.send(message);
  }

  public Authors uploadAvatar(int id, String url){
    Authors post = getById(id);
    post.setAvatar(url);
    return authorsRepository.save(post);
  }

}
