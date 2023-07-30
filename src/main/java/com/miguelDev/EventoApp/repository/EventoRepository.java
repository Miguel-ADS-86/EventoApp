package com.miguelDev.EventoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelDev.EventoApp.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
