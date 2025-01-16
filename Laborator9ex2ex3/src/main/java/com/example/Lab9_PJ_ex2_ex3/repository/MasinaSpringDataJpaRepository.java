package com.example.Lab9_PJ_ex2_ex3.repository;

import com.example.Lab9_PJ_ex2_ex3.entity.Masina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;
import java.util.List;

public interface MasinaSpringDataJpaRepository extends JpaRepository<Masina, String> {

    int countByMarca(String marca);

    @Query("select count(*) from Masina where nr_kilometri<100000")
    int countByNr_kilometriIsLessThan100000();

    @Query(" from Masina where an_fabricatie+5>:data")
    List<Masina> noi_de_peste_5_ani(@Param("data") int data);
}
