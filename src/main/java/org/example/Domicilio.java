package org.example;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Audited
@Entity
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_domicilio;

    private String calle;
    private int nro;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

}
