package com.example.Laboratorul9.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MasinaJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Masina> findAll() {
        String sql = "select * from masini";
        return jdbcTemplate.query(sql,new MasinaMapper());
    }

    public int insert(Masina masina) {
        String sql = "insert into masini values(?,?,?,?,?)";
        return jdbcTemplate.update(sql,masina.getNr_inmatriculare(),masina.getMarca(),masina.getAn_fabricatie(),masina.getCuloare(),masina.getNr_kilometri());
    }

    public int deleteByNr_inmatriculare(String nr_inmatriculare) {
        String sql = "delete from masini where nr_inmatriculare = ?";
        return jdbcTemplate.update(sql,nr_inmatriculare);
    }

    public Masina findByNr_inmatriculare(String nr_inmatriculare) {
        String sql = "select * from masini where nr_inmatriculare = ?";
        return jdbcTemplate.queryForObject(sql, new MasinaMapper(), nr_inmatriculare);
    }

    public List<Masina> nr_masini_marca(String marca) {
        String sql = "select * from masini where marca = ?";
        return jdbcTemplate.query(sql, new MasinaMapper(), marca);
    }

    public List<Masina> sub_100_000km()
    {
        String sql = "select * from masini where nr_kilometri<100000";
        return jdbcTemplate.query(sql, new MasinaMapper());
    }

    public List<Masina> noi_de_peste_5_ani()
    {
        int an =LocalDateTime.now().getYear();
        String sql = "select * from masini where an_fabricatie+5>?";
        return jdbcTemplate.query(sql, new MasinaMapper(), an);
    }

}

