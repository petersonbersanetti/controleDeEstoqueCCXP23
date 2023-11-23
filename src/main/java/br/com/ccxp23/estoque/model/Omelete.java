package br.com.ccxp23.estoque.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "omelete")
public class Omelete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Long idRegistro;

    @Column(name = "tx_patrimonio")
    private String txPatrimonio;

    @Column(name = "tx_local")
    private String txLocal;

    @Column(name = "tx_modelo")
    private String txModelo;

}