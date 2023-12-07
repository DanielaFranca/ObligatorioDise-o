package uy.edu.ctc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uy.edu.ctc.entity.Electrodomestico;
import uy.edu.ctc.entity.LineaBlanca;
import uy.edu.ctc.repository.ElectrodomesticoRepository;
import uy.edu.ctc.repository.LineaBlancaRepository;

public class LineaBlancaServiceImpl extends ElectrodomesticoServiceImpl implements LineaBlancaService {

	

	private final LineaBlancaRepository LineaBlancaRepository;

    
   // public LineaBlancaServiceImpl(LineaBlancaRepository LineaBlancaRepository) {
    //    this.LineaBlancaRepository = LineaBlancaRepository;
    //}

  /*  @Override
    public Iterable<LineaBlanca> findAll() {
        return LineaBlancaRepository.findAll();
    }

    @Override
    public Page<LineaBlanca> findAll(Pageable pageable) {
        return LineaBlancaRepository.findAll(pageable);
    }

    @Override
    public Optional<LineaBlanca> findById(Long id) {
        return LineaBlancaRepository.findById(id);
    }

    @Override
    public LineaBlanca save(LineaBlanca LineaBlanca) {
        return LineaBlancaRepository.save(LineaBlanca);
    }

    @Override
    public void deleteById(Long id) {
    	LineaBlancaRepository.deleteById(id);
    } */
}
