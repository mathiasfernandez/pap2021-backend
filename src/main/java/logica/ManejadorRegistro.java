package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.RegistroID;
import logica.Registro;
import logica.ManejadorUsuario;
import logica.ManejadorEspectaculo;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexion.Conexion;
import datatypes.ModoCanje;
public class ManejadorRegistro {
	private static ManejadorRegistro instancia = null;	
	private List<Registro> registros = new ArrayList<>();
	
	private ManejadorRegistro() {};
	
	public static ManejadorRegistro getInstancia() {
		if (instancia == null) 
			instancia = new ManejadorRegistro();
		return instancia;
	}
	
    public void crearRegistroID(String idEspectador, String idFuncion) {
		RegistroID regid = new RegistroID();
		regid.setEspectador(idEspectador);
		regid.setFuncion(idFuncion);
	}
	public void confirmarRegistro(RegistroID id,Date fechaAlta,ModoCanje canje) {
		Registro registro = new Registro();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Espectador esp = mU.getEspectador(id.getEspectador());
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		Funcion fun = mE.getFuncion(id.getFuncion());
		registro.setEspectador(esp);
		registro.setFuncion(fun);
		registro.setFecha(fechaAlta);
		registro.setCanje(canje);
		//registro.setId_reg(id);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
	
		em.persist(registro);
	
		em.getTransaction().commit();
	}
	
	public Registro buscarRegistro(String nombreRegistro) {
		Registro aretornar = null;
		for(Registro r: registros) {
//			if(r.getClass().equals(nombreRegistro))
			aretornar=r;
		}
		return aretornar;
	}
	
	public boolean removerRegistro(ModoCanje registro) {
		Registro aeliminar = null;
		for(Registro r: registros) {
			if(r.getCanje().equals(registro)) {
				aeliminar = r;
				registros.remove(aeliminar);
				return true;
			}
		}
		return false;
	}
}
