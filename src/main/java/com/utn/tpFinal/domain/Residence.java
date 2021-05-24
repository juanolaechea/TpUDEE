package com.utn.tpFinal.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Residences")
public class Residence {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "residence_id")
    private Integer residenceId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="dni_client", nullable = false)
    @JsonBackReference
    private User client;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "id_address")
    private Address address;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "serial_number")
    private Meter meter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_tariff", nullable = false)
    @JsonBackReference
    private Tariff tariff;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_invoice")
    private List<Invoice> invoiceList;




}
