package br.mackenzie.ps2.veiculos;

import br.mackenzie.ps2.veiculos.model.Veiculo;
import br.mackenzie.ps2.veiculos.repository.VeiculoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(VeiculoRepository veiculoRepository) {
        return args -> {
            // Limpar dados antigos se existirem
            veiculoRepository.deleteAll();

            // Criar e salvar dados de teste
            Veiculo veiculo1 = new Veiculo("Toyota", "Corolla", 2020, "ABC-1234", "Preto");
            Veiculo veiculo2 = new Veiculo("Honda", "Civic", 2021, "XYZ-5678", "Branco");
            Veiculo veiculo3 = new Veiculo("Ford", "Fiesta", 2019, "DEF-9012", "Vermelho");
            Veiculo veiculo4 = new Veiculo("Chevrolet", "Cruze", 2022, "GHI-3456", "Prata");
            Veiculo veiculo5 = new Veiculo("Volkswagen", "Gol", 2018, "JKL-7890", "Azul");

            veiculoRepository.save(veiculo1);
            veiculoRepository.save(veiculo2);
            veiculoRepository.save(veiculo3);
            veiculoRepository.save(veiculo4);
            veiculoRepository.save(veiculo5);

            System.out.println("✓ Dados de teste carregados no banco H2!");
        };
    }
}
