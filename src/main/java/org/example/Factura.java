
package org.example;
import lombok.*;
import org.example.Cliente;
import org.example.DetalleFactura;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Entity
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;

    private String fecha;
    private int numero;
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    Set<DetalleFactura> detalleFacturas = new HashSet<>();
}
