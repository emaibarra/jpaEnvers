package org.example;

import lombok.*;
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
public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_articulo;

    private int cantidad;
    private String denominacion;
    private int precio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "articulo_id")
    Set<DetalleFactura> detalleFacturas = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "fk_articulo"),
            inverseJoinColumns = @JoinColumn(name = "fk_categoria")
    )
    Set<Categoria> categorias = new HashSet<>();


}