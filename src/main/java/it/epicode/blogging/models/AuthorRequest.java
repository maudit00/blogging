package it.epicode.blogging.models;

import lombok.Data;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
public class AuthorRequest {
  @NotNull(message = "Nome obbligatorio")
  @NotEmpty(message = "Nome non vuoto")
  private String nome;
  @NotNull(message = "Cognome obbligatorio")
  @NotEmpty(message = "Cognome non vuoto")
  private String cognome;
  @Email(message = "Inserire email valida")
  private String email;
  @NotNull(message = "data di nascita obbligatoria")
  private LocalDate datadiNascita;
}
