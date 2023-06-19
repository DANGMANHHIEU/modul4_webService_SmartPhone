package com.example.ajax.repository;

import com.example.ajax.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphone extends CrudRepository<Smartphone,Long> {

}
