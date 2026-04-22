package br.mackenzie.ps2.veiculos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "veiculos")
@Data
@NoArgsConstructor
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String marca;
    
    @Column(nullable = false)
    private String modelo;
    
    @Column(nullable = false)
    private int ano;
    
    @Column(nullable = false, unique = true)
    private String placa;
    
    @Column(nullable = false)
    private String cor;

    public Veiculo(String marca, String modelo, int ano, String placa, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.cor = cor;
    }
}