package com.example.Lab10_PJ.repository;

import com.example.Lab10_PJ.entity.Carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarteRepository extends JpaRepository<Carte, Integer> {

    @Query("from Carte where autorul=:autor")
    List<Carte> find_all_by_autor(@Param("autor") String autor);
}
