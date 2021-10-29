package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;

import conexion.Conexion;
import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
public class ManejadorUsuario {

	private static ManejadorUsuario instancia = null;	
	//private List<Usuario> usuarios = new ArrayList<>();
	
	private ManejadorUsuario() {};
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null) 
			instancia = new ManejadorUsuario();
		return instancia;
	}
	
	public void agregarUsuario(Usuario usuario) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
	
		em.persist(usuario);
	
		em.getTransaction().commit();
	}

	public Usuario buscarUsuario(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Usuario usuario = em.find(Usuario.class, nickname);
		return usuario;
	}
	
	public void actualizarUsuario(DtUsuario usr) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		Usuario usuario = em.find(Usuario.class, usr.getNickname());
		em.persist(usuario);
		if (usr instanceof DtEspectador) {
			usuario.setApellido(usr.getApellido());
			usuario.setfNac(usr.getfNac());
			usuario.setNombre(usr.getNombre());
			usuario.setImagen(usr.getImagen());
		}
		else{
			usuario.setApellido(usr.getApellido());
			usuario.setfNac(usr.getfNac());
			usuario.setNombre(usr.getNombre());
			usuario.setImagen(usr.getImagen());
			((Artista) usuario).setSitioWeb(((DtArtista) usr).getSitio_web());
			((Artista) usuario).setBibliografia(((DtArtista) usr).getBibliografia());
			((Artista) usuario).setDescripcion(((DtArtista) usr).getDescripcion());
		}
		String encriptMD5 = DigestUtils.md5Hex(usr.getContrasena());
		usuario.setContrasena(encriptMD5);
		em.getTransaction().commit();
	}
	
	public DtUsuario buscarDtUsuario(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Usuario usuario = em.find(Usuario.class, nickname);
		DtUsuario res ;
		if (usuario instanceof Artista) {
			res = new DtArtista(usuario.getNickname(),usuario.getNombre(),usuario.getApellido(),usuario.getCorreo(),usuario.getfNac(),((Artista) usuario).getDescripcion(),((Artista) usuario).getBibliografia(),((Artista) usuario).getSitioWeb(), usuario.getContrasena(),usuario.getImagen());
		}
		else
			res = new DtEspectador(usuario.getNickname(),usuario.getNombre(),usuario.getApellido(),usuario.getCorreo(),usuario.getfNac(),usuario.getContrasena(), usuario.getImagen());
				
		return res;
		}
	
	
	public boolean ExisteUsuarioNickName(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Usuario usuario = em.find(Usuario.class, nickname);
		if (usuario != null)
			return true;
		else
			return false;
	}
	
	public boolean ExisteUsuarioCorreo(String correo) {
		boolean existeUsr = false;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select u from Usuario u");
		List<Usuario> listUsuario = (List<Usuario>) query.getResultList();
		
		ArrayList<String> aux = new ArrayList<>();
		for (Usuario u: listUsuario) {
			if(u.getCorreo().equals(correo))
				existeUsr=true;
		}
		return existeUsr;
		
	}
	


	public boolean removerUsuario(String nickname) {
		/*
		Usuario aeliminar = null;
		for(Usuario u: usuarios) {
			if(u.getNickname().equals(nickname)) {
				aeliminar = u;
				usuarios.remove(aeliminar);
				return true;
			}
		}
		*/
		return false;
		
	}

	public List<Artista> getArtistas() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select u from Usuario u");
		List<Artista> listArtista = (List<Artista>) query.getResultList();
		
		List<Artista> retorno = new ArrayList<Artista>();;
		for(Usuario u: listArtista) {
			if(u instanceof Artista) {
				Artista art = (Artista) u;
				retorno.add(art);
			}
		}
		return retorno;
	}

	public List<Espectador> getEspectadores() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select u from Usuario u");		
		List<Espectador> listEspectador = (List<Espectador>) query.getResultList();
		
		List<Espectador> retorno = new ArrayList<Espectador>();;
		for(Usuario u: listEspectador) {
			if(u instanceof Espectador) {
				Espectador esp = (Espectador) u;
				retorno.add(esp);
			}
		}
		return retorno;
	}


	public ArrayList<String> obtenerUsuarios() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select u from Usuario u");
		List<Usuario> listUsuario = (List<Usuario>) query.getResultList();
		
		ArrayList<String> retorno = new ArrayList<>();
		for (Usuario u: listUsuario) {
			retorno.add(u.getNickname());
		}
		return retorno;
	}
	
	
	public ArrayList<String> usuariosSeguidos(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select u from UsuariosSeguidos u");
		List<UsuariosSeguidos> listUsuario = (List<UsuariosSeguidos>) query.getResultList();
		ArrayList<String> retorno = new ArrayList<>();
		for (UsuariosSeguidos u: listUsuario) {
			if(u.getSeguidor().getNickname().equals(nickname)) {
			retorno.add(u.getUsuarioSeguido().getNickname());
			}
			
		}
		return retorno;
	}
	
	public ArrayList<String> usuarioMeSiguen(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select u from UsuariosSeguidos u");
		List<UsuariosSeguidos> listUsuario = (List<UsuariosSeguidos>) query.getResultList();
		ArrayList<String> retorno = new ArrayList<>();
		for (UsuariosSeguidos u: listUsuario) {
			if(u.getUsuarioSeguido().getNickname().equals(nickname)) {
			retorno.add(u.getSeguidor().getNickname());
			}
			
		}
		return retorno;
	}
	
	public String[] obtenerEspectadores() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select u from Usuario u");		
		List<Espectador> listEspectador = (List<Espectador>) query.getResultList();
		List<String> nombres = new ArrayList<String>();
		List<Espectador> espectadores = new ArrayList<Espectador>();
		for(Usuario u: listEspectador) {
			if(u instanceof Espectador) {
				Espectador esp = (Espectador) u;
				espectadores.add(esp);
				nombres.add(esp.getNickname());
			}
		}
		String[] retorno = new String[espectadores.size()];
		int i = 0;
		for(String e: nombres) {
			retorno[i] = e;
			i++;
		}
		return retorno;
	}
	

	
	public Espectador getEspectador(String id) {
		Usuario u = buscarUsuario(id);
		return (Espectador) u;
	}
	
	public boolean validarLogin(String usuario, String contra) {
		boolean retorno = false;
		String contraH = DigestUtils.md5Hex(contra);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Usuario u = em.find(Usuario.class, usuario);
		if (u != null) {
			if (u.getContrasena().equals(contraH)) {
				retorno = true;
			}else{
				retorno = false;
			}
		}
		
		Query query =em.createQuery("select u from Usuario u");
		List<Usuario> listUsuario = (List<Usuario>) query.getResultList();
		for (Usuario us: listUsuario) {
			if(us.getCorreo().equals(usuario))
				if (us.getContrasena().equals(contraH)) {
					retorno = true;
				}else{
					retorno = false;
				}
		}
		
		return retorno;
	}

	public ArrayList<DtUsuario> obtenerUsuariosDTs() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query =em.createQuery("select u from Usuario u");
		List<Usuario> listUsuario = (List<Usuario>) query.getResultList();
		
		ArrayList<DtUsuario> retorno = new ArrayList<>();
		for (Usuario u: listUsuario) {
			if (u instanceof Artista) {
				DtUsuario aux = new DtArtista(u.getNickname(),u.getNombre(),u.getApellido(),u.getCorreo(),u.getfNac(),((Artista) u).getDescripcion(),((Artista) u).getBibliografia(),((Artista) u).getSitioWeb(), u.getContrasena(),u.getImagen());
				retorno.add(aux);
			}else{
				DtUsuario aux = new DtEspectador(u.getNickname(),u.getNombre(),u.getApellido(),u.getCorreo(),u.getfNac(),u.getContrasena(),u.getImagen());
				retorno.add(aux);
			}
		}
		return retorno;
	}
	
	
	
	public void seguirUsuario(UsuariosSeguidos us) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
	
		em.persist(us);
	
		em.getTransaction().commit();	
	}
	
	public void dejarDeSeguirUsuasrio(UsuariosSeguidos us) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		Query query =em.createQuery("delete from UsuariosSeguidos where seguidor_nickname =: nom AND usuarioseguido_nickname =: seg ");
		query.setParameter("nom", us.getSeguidor().getNickname());
		query.setParameter("seg", us.getUsuarioSeguido().getNickname());
		int res = query.executeUpdate();
		if(res == 0) 
			em.getTransaction().commit();
	}
	
	public void agregarImagenUser(Usuario usuario, String img) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		usuario.setImagen(img);
		em.persist(usuario);
		em.getTransaction().commit();
	}
	
	public boolean yaLoSigo(String seguidor, String seguido) {
		ArrayList<String> usuariosQueSigo = usuariosSeguidos(seguidor);
		for(String u : usuariosQueSigo) {
			if(u == seguido) {
				return true;
			}
		}	
		return false;
	}
	
}
