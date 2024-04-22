package com.example.demo.repositories;


import com.example.demo.model.entities.RecursosEducativos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface RecursosEducativosRepository extends JpaRepository<RecursosEducativos, Long> {


}
