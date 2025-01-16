package com.example.Lab11_PJ.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name="evenimente")
public class Eveniment {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String denumire;
    private String locatie;
    private LocalDate data;
    private LocalTime ora;
    private Float pret;
}
