package com.plantas.demo.Plantas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_planta")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlantaModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name="especie_id")
    private Especie especie;
}
