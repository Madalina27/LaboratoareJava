package com.example.Lab9_PJ_ex2_ex3.repository;

import com.example.Lab9_PJ_ex2_ex3.entity.Masina;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class MasinaJpaRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Masina> findAll(){
        TypedQuery<Masina> query = em.createQuery("from Masina", Masina.class);
        return query.getResultList();
    }

    public Masina insert(Masina masina){
        return em.merge(masina);
    }

    public Masina findByNr_inmatriculare(String nr_inmatriculare){
        return em.find(Masina.class, nr_inmatriculare);
    }

    public void deleteByNr_inmatriculare(String nr_inmatriculare){
        Masina masina = findByNr_inmatriculare(nr_inmatriculare);
        em.remove(masina);
    }

    public List<Masina> nr_masini_marca(String marca){
        String sql ="from Masina where marca = :marca";
        TypedQuery<Masina> query = em.createQuery(sql, Masina.class);
        query.setParameter("marca", marca);
        return query.getResultList();
    }

    public List<Masina> sub_100_000km()
    {
        String sql ="from Masina where nr_kilometri<100000";
        TypedQuery<Masina> query = em.createQuery(sql, Masina.class);
        return query.getResultList();
    }

    public List<Masina> noi_de_peste_5_ani()
    {
        int an = LocalDateTime.now().getYear();
        String sql = "from Masina where an_fabricatie+5>:an";
        TypedQuery<Masina> query = em.createQuery(sql, Masina.class);
        query.setParameter("an", an);
        return query.getResultList();
    }

}
