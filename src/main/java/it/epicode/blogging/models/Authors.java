
package it.epicode.blogging.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
/**
 * Authors
 */
public class Authors {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String nome;
  private String cognome;
  private String email;
  private LocalDate dataDiNascita;
  private String avatar;
  @OneToMany(mappedBy = "author")
  private List<Posts> posts;

  public Authors(String nome, String cognome, String email, LocalDate dataDiNascita) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.dataDiNascita = dataDiNascita;
    this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
  }

public Authors (){

}

}
