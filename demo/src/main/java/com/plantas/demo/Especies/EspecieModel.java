package com.plantas.demo.Especies;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plantas.demo.Plantas.PlantaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="tb_especie")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EspecieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "especie")
    @JsonIgnore
    private List<PlantaModel> plantas;

}
