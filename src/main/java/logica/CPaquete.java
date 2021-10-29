package logica;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import java.util.Date;

import java.util.List;


import logica.ManejadorPaquete;
import java.util.List;
import conexion.Conexion;
import datatypes.DtPaquete;
import interfaces.IcPaquete;

public class CPaquete implements IcPaquete {

	@Override
	public void confirmarAltaPaquete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DtPaquete seleccionarPaquete(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Funcion para lista de nombres de paquetes
	public ArrayList<String> listarPaquetes(){
		ArrayList<String> retorno = new ArrayList<>();
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		retorno = mP.listarPaquetes();
		
		return retorno;
	}
	
	
	// Funcion para lista de nombres de plataformas
	public ArrayList<String> listarPlataformas(){
		ArrayList<String> retorno = new ArrayList<>();
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		retorno = mP.listarPlataformas();
		
		return retorno;
	}
	
	// Funcion para lista de nombres de espectaculos que no estan en paquete en plataforma
	public ArrayList<String> listaEspectaculosNOPAQUETE(String plataforma, String paquete) {	
		ArrayList<String> retorno = new ArrayList<>();
		ManejadorEspectaculo mP = ManejadorEspectaculo.getInstancia();
		retorno = mP.listarEspectaculosNOPAQUETE(plataforma, paquete);
		
		return retorno;
	}

	// Funcion para agregar espectaculo a paquete
	public void agregarEspectaculoAPaquete(String paquete, String Espectaculo) {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		Paquete pac = mP.buscarPaquete(paquete);
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		Espectaculo esp = mE.buscarEspectaculo(Espectaculo);
		pac.agregarEspectaculo(esp);
		esp.setIdEspPaq(pac);
		
		mP.agregarEspectaculoAPaquete(pac, esp);
	}	

	//agregar paquete a bd
		public void agregarPaquete(String nombrePac, String descripcion, Date fInicio, Date fFinal, Integer descuento, Date fechaDeAlta,
				List<Espectaculo> espectaculos){
			ManejadorPaquete mP = ManejadorPaquete.getInstancia();
			Paquete paquete = new Paquete(nombrePac,descripcion,fInicio,fFinal,descuento,fechaDeAlta,espectaculos);
			mP.agregarPaquete(paquete);
		}
		
		public boolean ExistePaquete(String nombre) {
			ManejadorPaquete mP = ManejadorPaquete.getInstancia();
			boolean retorno = mP.ExistePaquete(nombre);
			return retorno;
		}

	// Funcion obtener info de un paquete
	public DtPaquete infoPaquete(String nombre) {
		DtPaquete retorno = new DtPaquete();
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		Paquete pac = mP.buscarPaquete(nombre);
		retorno = pac.getInfo();
		
		return retorno;
	}
	
}
