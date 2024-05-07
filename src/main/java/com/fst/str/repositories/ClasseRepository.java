package com.fst.str.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fst.str.entities.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{

}
