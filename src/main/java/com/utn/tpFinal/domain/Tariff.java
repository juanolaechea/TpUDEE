package com.utn.tpFinal.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tariff")
public class Tariff {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "tariff_id")
    private Integer tariffIdd;
    @Column(name ="tariff_name")
    private String tariffName;
    @Column(name ="tariff_value")
    private Float tariffValue;
}
