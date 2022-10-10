package com.ayi.curso.rest.serv.ayispringrestful.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "client_detail")
public class ClientDetail implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client_detail")
    private Long idClientDetail;

    @Column(name = "prime")
    private Boolean prime;

    @Column(name = "acumulated_points")
    private Long acumulatedPoints;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "clientDetail")
    @JoinColumn(name = "id_client")
    private Client client;
}
