package com.previo.Test;

import com.previo.DAO.PacienteDAO;
import com.previo.Entities.Paciente;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacienteDAO p = new PacienteDAO();
		
		
		
		for(Paciente pa: p.list())
			System.out.println(pa.toString());
	}

}
