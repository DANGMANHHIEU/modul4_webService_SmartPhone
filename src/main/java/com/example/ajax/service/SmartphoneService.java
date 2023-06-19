package com.example.ajax.service;

import com.example.ajax.model.Smartphone;
import com.example.ajax.repository.ISmartphone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SmartphoneService implements ISmartphoneService{
    @Autowired
    private ISmartphone smartphone;
    @Override
    public Iterable<Smartphone> findAll() {
        return smartphone.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return smartphone.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphones) {
        return smartphone.save(smartphones);
    }

    @Override
    public void remove(Long id) {
            smartphone.deleteById(id);
    }
}
