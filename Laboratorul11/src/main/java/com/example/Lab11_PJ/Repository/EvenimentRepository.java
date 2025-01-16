package com.example.Lab11_PJ.Repository;

import com.example.Lab11_PJ.Entity.Eveniment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EvenimentRepository extends JpaRepository<Eveniment, Long> {

    @Query("from Eveniment where locatie=:location")
    List<Eveniment> find_by_location(@Param("location") String location);

    @Query("from Eveniment where data=:date")
    List<Eveniment> find_by_date(@Param("date") LocalDate date);
}
