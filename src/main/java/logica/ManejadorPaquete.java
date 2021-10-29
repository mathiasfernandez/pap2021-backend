//TODO modificar con conexion a bd
package logica;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import conexion.Conexion;
import datatypes.DtPaquete;

public class ManejadorPaquete {

	private static ManejadorPaquete instancia = null;	
	private List<Paquete> paquetes = new ArrayList<>();
	
	private ManejadorPaquete() {};
	
	public static ManejadorPaquete getInstancia() {
		if (instancia == null) 
			instancia = new ManejadorPaquete();
		return instancia;
	}
	
	public void agregarPaquete(Paquete Paquete) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(Paquete);
		em.getTransaction().commit();
	}
	
	public boolean ExistePaquete(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Paquete paquete = em.find(Paquete.class, nombre);
		if (paquete != null)
			return true;
		else
			return false;
	}
	
	public Paquete buscarPaquete(String nombrePaquete) {
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		javax.persistence.Query query = em.createQuery("select p from Paquete p ");
		Paquete paquete = null;
		List<Paquete> paquetes = (List<Paquete>) query.getResultList();
		for (Paquete p: paquetes) {
			if(p.getNombrePac().equals(nombrePaquete)) {
				 paquete = p;
				 break;
			}
		}
		return paquete;
	}
	
	public boolean removerPaquete(String nombrePlataforma) {
		Paquete aeliminar = null;
		for(Paquete p: paquetes) {
			if(p.getNombrePac().equals(nombrePlataforma)) {
				aeliminar = p;
				paquetes.remove(aeliminar);
				return true;
			}
		}
		return false;
	}
	
	// Funcion para lista de nombres de paquetes
	public ArrayList<String> listarPaquetes(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		javax.persistence.Query query = em.createQuery("select nombrePac from Paquete");
		List<String> listaPla = (List<String>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		for(String s: listaPla) {
			aRetornar.add(s);
		}
		return aRetornar;
	}
	
	public void agregarEspectaculoAPaquete(Paquete p, Espectaculo e) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.merge(e);
		em.getTransaction().commit();
	}
}
