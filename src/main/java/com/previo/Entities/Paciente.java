package com.previo.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "paciente")
@Entity
@NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String documento;
	
	private String nombre;
	
	private String apellido;
	
	private String genero;
	
	@Column(name="fechanacimiento")
	private Date fechaNacimiento;
	
	private String telefono;
	
	private String direccion;
	
	private float peso;
	
	private float estatura;
	
	//private String contextura;
	
	@Transient
	private float imc;

	public Paciente(String documento, String nombre, String apellido, String genero, Date fechaNacimiento,
			String telefono, String direccion, float peso, float estatura) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.peso = peso;
		this.estatura = estatura;
		//this.contextura = contextura;
	}
	
	
}
