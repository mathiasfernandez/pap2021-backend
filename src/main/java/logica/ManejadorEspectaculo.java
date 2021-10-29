package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexion.Conexion;
import datatypes.DtFuncion;

public class ManejadorEspectaculo {
	
	private static ManejadorEspectaculo instancia = null;	
	private List<Espectaculo> espectaculos = new ArrayList<>();
	

	private ManejadorEspectaculo() {};
	
	public static ManejadorEspectaculo getInstancia() {
		if (instancia == null) 
			instancia = new ManejadorEspectaculo();
		return instancia;
	}

	
	
	public void agregarEspectaculo(Espectaculo espectaculo) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(espectaculo);
		em.getTransaction().commit();
	}
	
	
	public List<Funcion> getFuncionesEspectaculo(Espectaculo espectaculo) {
		return espectaculo.getFunciones();		
	}
	
	public Espectaculo buscarEspectaculo(String nombreEspectaculo) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Espectaculo espectaculo= em.find(Espectaculo.class, nombreEspectaculo);
		return espectaculo;		
	}
	
	public boolean removerEspectaculo(String nombreEsp) {
		Espectaculo aeliminar = null;
		for(Espectaculo p: espectaculos) {
			if(p.getNombreEsp().equals(nombreEsp)) {
				aeliminar = p;
				espectaculos.remove(aeliminar);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<String> listarEspectaculos() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select e from Espectaculo e");
		List<Espectaculo> espectaculos = (List<Espectaculo>) query.getResultList();
		
		ArrayList<String> retorno = new ArrayList<>();
		for (Espectaculo e: espectaculos) {
			retorno.add(e.getNombreEsp());
		}
		return retorno;
	}
	
	public ArrayList<String> listarFunciones(String nomEsp) {
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select f from Funcion f");
		List<Funcion> funciones = (List<Funcion>) query.getResultList();
		
		ArrayList<String> retorno = new ArrayList<>();
		for (Funcion f: funciones) {
			if(nomEsp.equals(f.getIdEsp_Func().getNombreEsp())) {
			retorno.add(f.getNombreFunc());
			}
		}
		return retorno;
	}
	
	public ArrayList<String> listarEspectaculosPlafatorma(String plataforma) {
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select e from Espectaculo e");
		List<Espectaculo> espectaculos = (List<Espectaculo>) query.getResultList();
		ArrayList<String> retorno = new ArrayList<>();
		for (Espectaculo e: espectaculos) {
			if(plataforma.equals(e.getPlataforma().getNombrePla())){	
				retorno.add(e.getNombreEsp());
			}}
		return retorno;
	}
	
	public ArrayList<String> listarEspectaculosArtista(String artista) {
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select e from Espectaculo e");
		List<Espectaculo> espectaculos = (List<Espectaculo>) query.getResultList();
		ArrayList<String> retorno = new ArrayList<>();
		for (Espectaculo e: espectaculos) {
			if(artista.equals(e.getArtista().getNickname())){	
				retorno.add(e.getNombreEsp());
			}}
		return retorno;
	}
	
	

	
	public void agregarFuncionEspectaculo(Espectaculo e, Funcion f) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.persist(f);
		em.getTransaction().commit();
	}
	
	public boolean existeEspectaculo(String nombreEspectaculo) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Espectaculo espectaculo = em.find(Espectaculo.class, nombreEspectaculo);
		if (espectaculo!=null)
			return true;
		else
			return false;
	}
	// Funcion para lista de nombres de espectaculos que no estan en paquete en plataforma
	public ArrayList<String> listarEspectaculosNOPAQUETE(String plataforma, String paquete) {		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		javax.persistence.Query query = em.createQuery("select nombreEsp from logica.Espectaculo where idesppaq_nombrepac != '" + paquete + "' or idesppaq_nombrepac is null and idpla_esp_nombrepla = '" + plataforma + "'");
		List<String> listaPla = (List<String>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		for(String s: listaPla) {
			aRetornar.add(s);
		}
		return aRetornar;
	}
	
	public ArrayList<String> listarPaquetesEsp(String nombreEsp) {		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		javax.persistence.Query query = em.createQuery("select e from Espectaculo e");
		List<Espectaculo> listaPaq = (List<Espectaculo>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Espectaculo e: listaPaq) {
			if((e.getIdEspPaq() != null) && e.getNombreEsp().equals(nombreEsp)) {
				aRetornar.add(e.getIdEspPaq().getNombrePac());
			}
		}
		return aRetornar;
	}

	public Funcion getFuncion(String idf) {
		Funcion fun = null;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select f from Funcion f ");
		List<Funcion> funciones = (List<Funcion>) query.getResultList();
		for (Funcion f: funciones) {
			if(f.getNombreFunc()==idf) {
				fun = f;
			}
		}
		return fun;
	}
	
}
