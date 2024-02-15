package it.epicode.blogging.models;

import java.time.LocalTime;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
/**
 * PostsRequest
 */
public class PostRequest {

  private int idAuthor;
  private String categoria;
  @NotNull(message = "Titolo obbligatorio")
  @NotEmpty(message = "Titolo non vuoto")
  private String titolo;
  @URL
  private String cover;
  @NotNull(message = "Coontenuto obbligatorio")
  @NotEmpty(message = "Contenuto non vuoto")
  private String contenuto;
  private LocalTime tempodiLettura;
}
