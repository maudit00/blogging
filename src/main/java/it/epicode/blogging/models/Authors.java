
package it.epicode.blogging.models;

import java.time.LocalDate;
import java.util.Random;

import lombok.Data;

@Data
/**
 * Authors
 */
public class Authors {

  private int id = new Random().nextInt(1, Integer.MAX_VALUE);
  private String nome;
  private String cognome;
  private String email;
  private LocalDate dataDiNascita;
  private String avatar;

  public Authors(String nome, String cognome, String email, LocalDate dataDiNascita) {

    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.dataDiNascita = dataDiNascita;
    this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
  }

}
