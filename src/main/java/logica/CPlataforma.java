package logica;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import conexion.Conexion;
import exepciones.PlataformaRepetidaExepcion;
import interfaces.IcPlataforma;

public class CPlataforma implements IcPlataforma {

	@Override
	public void confirmarAltaPlataforma(String nombre, String desc, String url) throws PlataformaRepetidaExepcion {
			Plataforma plataforma = new Plataforma(nombre,null,desc,url);
			ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
			mP.agregarPlataforma(plataforma);
	}
	
	@Override
	public String[] getPlataformas() { 

		ArrayList<String> plataformas;		
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia(); // obtener el manejador para leer los items
		
		plataformas = mP.listarPlataformas();	// listar las plataformas existentes en el manejador
		String [] plataforma_ret = new String [plataformas.size()];
		int i=0;
		for(String p: plataformas) {
			plataforma_ret[i] = p;
			i++;
		}
		return plataforma_ret;
	}	

	@Override
	public boolean existePlataforma(String nombre) {
		boolean existe = false;
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		existe = mP.existePlataforma(nombre);
		return existe;
		
	}
	public Plataforma buscarPlataforma(String nombre) {
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		return mP.buscarPlataforma(nombre);
	}

}
