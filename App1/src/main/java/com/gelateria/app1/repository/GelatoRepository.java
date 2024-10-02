package com.gelateria.app1.repository;

import com.gelateria.app1.entity.Gelato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GelatoRepository extends JpaRepository <Gelato,Integer>
{
}
