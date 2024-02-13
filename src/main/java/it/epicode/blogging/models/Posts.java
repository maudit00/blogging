package it.epicode.blogging.models;

import java.time.LocalTime;
import java.util.Random;

import lombok.Data;

@Data
/**
 * Post
 */
public class Posts {

  private int id = new Random().nextInt(1, Integer.MAX_VALUE);
  private String categoria;
  private String titolo;
  private String cover;
  private String contenuto;
  private Authors author;
  private LocalTime tempodiLettura;

}
