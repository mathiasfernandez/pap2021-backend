package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexion.Conexion;

public class ManejadorPlataforma {

	private static ManejadorPlataforma instancia = null;	
	//private List<Plataforma> plataformas = new ArrayList<>();
	
	private ManejadorPlataforma() {};
	
	public static ManejadorPlataforma getInstancia() {
		if (instancia == null) 
			instancia = new ManejadorPlataforma();
		return instancia;
	}
	
	public void agregarPlataforma(Plataforma plataforma) {
		//plataformas.add(plataforma);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(plataforma);
		em.getTransaction().commit();
	}
	
	public Plataforma buscarPlataforma(String nombrePlataforma) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Plataforma plataforma= em.find(Plataforma.class, nombrePlataforma);
		return plataforma;
	}
	
	public boolean removerPlataforma(String nickname) {
		/*
		Plataforma aeliminar = null;
		for(Plataforma p: plataformas) {
			if(p.getNombrePla().equals(nickname)) {
				aeliminar = p;
				plataformas.remove(aeliminar);
				return true;
			}
		}
	*/
		return false;
	}
		
	public ArrayList<String> listarPlataformas() {		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		javax.persistence.Query query = em.createQuery("select p from Plataforma p");
		List<Plataforma> listaPla = (List<Plataforma>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Plataforma s: listaPla) {
			aRetornar.add(s.getNombrePla());
		}
		return aRetornar;
	}
	
	// busca si ya existe la plataforma mediante el nombre
	public boolean existePlataforma(String nombrePlataforma) {	
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Plataforma plataforma = em.find(Plataforma.class, nombrePlataforma);
		if (plataforma!=null)
			return true;
		else
			return false;
	}
}
