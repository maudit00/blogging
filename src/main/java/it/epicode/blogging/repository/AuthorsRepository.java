package it.epicode.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.blogging.models.Authors;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorsRepository extends JpaRepository<Authors, Integer>, PagingAndSortingRepository<Authors, Integer> {
}
