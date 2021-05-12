package com.utn.tpFinal.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tariff")
public class Tariff {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_tariff")
    private Integer tariffIdd;
    @Column(name ="name")
    private String tariffName;
    @Column(name ="value")
    private Float tariffValue;
}
