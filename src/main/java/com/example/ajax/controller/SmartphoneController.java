package com.example.ajax.controller;

import com.example.ajax.model.Smartphone;
import com.example.ajax.service.ISmartphoneService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/smartphone")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Smartphone>> findAll() {
        Iterable<Smartphone> smartphones = smartphoneService.findAll();
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Smartphone> createSmartPhone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSmartPhone(@PathVariable Long id) {
        smartphoneService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Smartphone>> view(@PathVariable Long id) {
        Optional<Smartphone> smartphone = smartphoneService.findById(id);
        return new ResponseEntity<>(smartphone, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Smartphone>> update(@PathVariable Long id, @RequestBody Smartphone smartphone) {
        Optional<Smartphone> smartphone1 = smartphoneService.findById(id);
        if (!smartphone1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        smartphone.setId(smartphone1.get().getId());
        smartphoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}