package com.utn.tpFinal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "residences")
public class Residence {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "recidence_id")
    private Integer recidenceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_dni")
    private Client ciente;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serial_number")
    private Meter meter;

    @ManyToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id")
    private List<Invoice> invoiceList;




}
