package PruebasJunit;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JOptionPane;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exepciones.PlataformaRepetidaExepcion;
import interfaces.IcPlataforma;
import logica.Fabrica;
import logica.Plataforma;

public class TestPlataforma {
private static Fabrica fabrica = Fabrica.getInstancia();
private static IcPlataforma iconP = fabrica.getIControladorPlataforma();
	/*
	@Test

	public void test() {
		fail("Not yet implemented");
	}
	*/
/*
	@BeforeClass
	public static void PlataformaCreada() throws PlataformaRepetidaExepcion {//throws UsuarioRepetidoExepcion{
		try {
			iconP.confirmarAltaPlataforma("PlataformaTest", "hola", "http://www.hjfsdkjfhsdf.com.uy");
		}catch (PlataformaRepetidaExepcion e1) {
			e1.getMessage();
			}
	}
	*/
	@Test
	public void existePlataformaTest() {
		boolean existe = iconP.existePlataforma("plata1");
		assertTrue(existe);	
	}
	
	@Test
	public void getPlataformasTest() {
		String[] ret = iconP.getPlataformas();
		assertTrue(ret != null);	
	}
	
	@Test
	public void buscarPlataformaTest() {
		Plataforma ret = iconP.buscarPlataforma("es");
		assertTrue(ret != null);	
	}
	
	/*
	@Test
	public void ActualizarUsuarioTest() {
		Date fecha = new Date();
		DtEspectador us = new DtEspectador("usuarioTest2", "usuarioTestNombre","ApellidoTest","usuarioTest2@gmail.com",fecha, "usuarioTest", "anda");
		iconU.actualizarUsuario(us);
		DtUsuario nuevo = iconU.getDtUsuario("usuarioTest2");
		assertTrue(nuevo.getNombre()=="usuarioTestNombre");
	}
	
	@Test
	public void getArtistasTest() {
		Artista art = iconU.getArtista("artista2");
		assertTrue(art != null);
	}
	
	@Test
	public void obtenerEspectadoresTest() {
		String[] Espectadores = iconU.obtenerEspectadores();
		assertTrue(Espectadores != null);
	}
	
	@Test
	public void listarUsuariosTest() {
		String[] usuarios = iconU.listarUsuarios();
		assertTrue(usuarios != null);
	}
	
	@Test
	public void seguirUsuarioTest() {
		iconU.seguirUsuario("usuarioTest2","artista3");
		iconU.dejarDeSeguirUsuario("test", "jp");
	}
	
	
	*/
	

	
	
	
}
