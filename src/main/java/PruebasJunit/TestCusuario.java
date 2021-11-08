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

import datatypes.DtEspectador;
import datatypes.DtUsuario;
import exepciones.UsuarioRepetidoExepcion;
import interfaces.IcUsuario;
import logica.Artista;
import logica.Espectador;
import logica.Fabrica;
import logica.ManejadorUsuario;

public class TestCusuario {
private static Fabrica fabrica = Fabrica.getInstancia();
private static IcUsuario iconU = fabrica.getIControladorUsuario();
	/*
	@Test

	public void test() {
		fail("Not yet implemented");
	}
	*/

	@BeforeClass
	public static void UsuarioCreado() throws UsuarioRepetidoExepcion {//throws UsuarioRepetidoExepcion{
		Date fecha = new Date();
		try {
		DtEspectador us = new DtEspectador("usuarioTest2", "usuarioTest","ApellidoTest","usuarioTest2@gmail.com",fecha, "usuarioTest", "anda");
		iconU.confirmarAltaUsuario(us);
		}catch (UsuarioRepetidoExepcion e1) {
			e1.getMessage();
			}
		try {
			DtEspectador us2 = new DtEspectador("usuarioTest2dsfsdfsdf", "usuarioTest","ApellidoTest","usuarioTest2@gmail.com",fecha, "usuarioTest", "anda");
			iconU.confirmarAltaUsuario(us2);
			}catch (UsuarioRepetidoExepcion e1) {
		e1.getMessage();
		}
		try {
			DtEspectador us3 = new DtEspectador("usuarioTest3", "usuarioTest","ApellidoTest","usuarioTest3@gmail.com",fecha, "usuarioTest", "anda");
			iconU.confirmarAltaUsuario(us3);
			}catch (UsuarioRepetidoExepcion e1) {
		e1.getMessage();
		}
	}
	
	@Test
	public void BusquedaUsuarioTest() {
		DtUsuario nuevo = iconU.getDtUsuario("usuarioTest2");
		assertTrue(nuevo.getNickname()=="usuarioTest2");	
	}
	
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
	
	
	
	

	
	
	
}
