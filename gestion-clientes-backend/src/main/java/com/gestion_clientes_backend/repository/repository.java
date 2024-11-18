package com.gestion_clientes_backend.repository;

import com.gestion_clientes_backend.models.models;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<models, Long> {

}
