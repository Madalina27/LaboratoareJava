package com.example.Lab10_PJ.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@Data
@Entity
@Table(name="carti")
public class Carte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ISBN;
    private String titlul;
    private String autorul;

}
