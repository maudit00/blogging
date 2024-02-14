package it.epicode.blogging.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorRequest {
    private String nome;
    private String cognome;
    private String email;
    private LocalDate datadiNascita;
}
