package it.epicode.blogging.models;

import java.time.LocalTime;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
/**
 * Post
 */
public class Posts {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String categoria;
  private String titolo;
  private String cover;
  private String contenuto;
  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "author_id")
  private Authors author;
  private LocalTime tempodiLettura;

}
