package com.utn.tpFinal.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "meters")
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_number")
    private Integer serialNumber;

    @Column(name = "meter_model" )
    private String meterModel;

    @Column(name = "meter_brand")
    private String meterBrand;

}
