package uy.edu.ctc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uy.edu.ctc.entity.Electrodomestico;
import uy.edu.ctc.repository.ElectrodomesticoRepository;

public abstract class ElectrodomesticoServiceImpl implements ElectrodomesticoService {

	private final ElectrodomesticoRepository ElectrodomesticoRepository;

    @Autowired
    public ElectrodomesticoServiceImpl(ElectrodomesticoRepository ElectrodomesticoRepository) {
        this.ElectrodomesticoRepository = ElectrodomesticoRepository;
    }

    @Override
    public Iterable<Electrodomestico> findAll() {
        return ElectrodomesticoRepository.findAll();
    }

    @Override
    public Page<Electrodomestico> findAll(Pageable pageable) {
        return ElectrodomesticoRepository.findAll(pageable);
    }

    @Override
    public Optional<Electrodomestico> findById(Long id) {
        return ElectrodomesticoRepository.findById(id);
    }

    @Override
    public Electrodomestico save(Electrodomestico Electrodomestico) {
        return ElectrodomesticoRepository.save(Electrodomestico);
    }

    @Override
    public void deleteById(Long id) {
    	ElectrodomesticoRepository.deleteById(id);
    }
}
