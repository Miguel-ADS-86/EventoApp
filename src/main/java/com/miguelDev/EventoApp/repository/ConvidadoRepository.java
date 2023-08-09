package com.miguelDev.EventoApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelDev.EventoApp.model.Convidado;
import com.miguelDev.EventoApp.model.Evento;


public interface ConvidadoRepository extends JpaRepository<Convidado, Long>{
    public List<Convidado> findByEvento(Evento evento);
}
