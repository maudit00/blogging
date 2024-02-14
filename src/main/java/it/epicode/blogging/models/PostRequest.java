package it.epicode.blogging.models;

import java.time.LocalTime;

import lombok.Data;

@Data
/**
 * PostsRequest
 */
public class PostRequest {

  private int idAuthor;
  private String categoria;
  private String titolo;
  private String cover;
  private String contenuto;
  private LocalTime tempodiLettura;
}
