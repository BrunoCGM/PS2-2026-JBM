package br.mackenzie.ps2.veiculos.service;

import br.mackenzie.ps2.veiculos.model.Veiculo;
import br.mackenzie.ps2.veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo criar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public Optional<Veiculo> buscarPorPlaca(String placa) {
        return veiculoRepository.findByPlacaIgnoreCase(placa);
    }

    public Optional<Veiculo> atualizar(Long id, Veiculo veiculoAtualizado) {
        Optional<Veiculo> veiculoOpt = veiculoRepository.findById(id);
        if (veiculoOpt.isPresent()) {
            Veiculo veiculo = veiculoOpt.get();
            veiculo.setMarca(veiculoAtualizado.getMarca());
            veiculo.setModelo(veiculoAtualizado.getModelo());
            veiculo.setAno(veiculoAtualizado.getAno());
            veiculo.setPlaca(veiculoAtualizado.getPlaca());
            veiculo.setCor(veiculoAtualizado.getCor());
            return Optional.of(veiculoRepository.save(veiculo));
        }
        return Optional.empty();
    }

    public boolean deletar(Long id) {
        if (veiculoRepository.existsById(id)) {
            veiculoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}