package com.rhempresax.rhempresax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhempresax.rhempresax.entity.Empregado;

@Repository
public interface IEmpregadoRepository extends JpaRepository<Empregado, Long> {

}
