package com.previo.DAO;


import com.previo.Entities.Paciente;
import com.previo.Utils.Conexion;
import com.previo.Utils.GenericDAO;

public class PacienteDAO extends Conexion<Paciente> implements GenericDAO<Paciente> {

	public PacienteDAO() {
		super(Paciente.class);
	}
}
