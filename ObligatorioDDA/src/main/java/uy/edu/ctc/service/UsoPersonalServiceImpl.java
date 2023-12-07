package uy.edu.ctc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uy.edu.ctc.entity.UsoPersonal;
import uy.edu.ctc.repository.UsoPersonalRepository;

public class UsoPersonalServiceImpl implements UsoPersonalService{

	private final UsoPersonalRepository UsoPersonalRepository;

    @Autowired
    public UsoPersonalServiceImpl(UsoPersonalRepository UsoPersonalRepository) {
        this.UsoPersonalRepository = UsoPersonalRepository;
    }

    @Override
    public Iterable<UsoPersonal> findAll() {
        return UsoPersonalRepository.findAll();
    }

    @Override
    public Page<UsoPersonal> findAll(Pageable pageable) {
        return UsoPersonalRepository.findAll(pageable);
    }

    @Override
    public Optional<UsoPersonal> findById(Long id) {
        return UsoPersonalRepository.findById(id);
    }

    @Override
    public UsoPersonal save(UsoPersonal UsoPersonal) {
        return UsoPersonalRepository.save(UsoPersonal);
    }

    @Override
    public void deleteById(Long id) {
    	UsoPersonalRepository.deleteById(id);
    }
}
