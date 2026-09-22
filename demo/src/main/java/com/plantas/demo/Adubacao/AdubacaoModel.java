package com.plantas.demo.Adubacao;

import com.plantas.demo.Plantas.PlantaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="tb_adubacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdubacaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="a descrição é obrigatória")
    private String descricao;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name="planta_id")
    private PlantaModel planta;
}
