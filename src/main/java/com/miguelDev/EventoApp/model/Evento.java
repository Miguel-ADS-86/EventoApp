package com.miguelDev.EventoApp.model;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_evento")
public class Evento implements Serializable{
	
	private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long codigo;
   private String nome;
   private String local;
   private String data;
   private String horario;
   
    public Evento() {}
    
    public Evento(Long codigo,String nome,String local,String data,String horario) {
    	this.codigo = codigo;
    	this.nome = nome;
    	this.local = local;
    	this.data = data;
    	this.horario = horario;
    	
    }
    
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(codigo, other.codigo);
	}
   
    
   
}
