package com.plantas.demo.Plantas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plantas.demo.Adubacao.AdubacaoModel;
import com.plantas.demo.Especies.EspecieModel;
import com.plantas.demo.Regas.RegaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_planta")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlantaModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="o nome é obrigatório")
    private String nome;

    @ManyToOne
    @JoinColumn(name="especie_id")
    private EspecieModel especie;

    @JsonIgnore
    @OneToMany(mappedBy = "planta", cascade = CascadeType.REMOVE)
    private List<AdubacaoModel> adubacoes =  new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "planta", cascade = CascadeType.REMOVE)
    private List<RegaModel> regas =  new ArrayList<>();

}
