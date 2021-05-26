package com.utn.tpFinal.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "meters")
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meter")
    private Integer meterId;

    @Column(name = "serial_number")
    private Integer serialNumber;

    @Column(name = "password")
    private Integer password;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_model")
    private Model model;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "id_measurement")
    private List<Measurement> measurementList;


}
