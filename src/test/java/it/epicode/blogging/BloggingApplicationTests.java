package it.epicode.blogging;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.epicode.blogging.models.AuthorRequest;
import it.epicode.blogging.models.Authors;
import it.epicode.blogging.repository.AuthorsRepository;

@SpringBootTest
class BloggingApplicationTests {

  @Test
  void contextLoads() {
  }

  @Autowired
  AuthorsRepository authorsRepository;

  @Test
  public Authors saveAuthor(AuthorRequest authorRequest) {
    Authors autore = new Authors(authorRequest.getNome(), authorRequest.getCognome(), authorRequest.getEmail(),
        authorRequest.getDatadiNascita());
    return authorsRepository.save(autore);
  }

}
