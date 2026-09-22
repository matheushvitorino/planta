package com.plantas.demo.Regas;

import com.plantas.demo.Plantas.PlantaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="tb_rega")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegaModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name="planta_id")
    private PlantaModel planta;

}
