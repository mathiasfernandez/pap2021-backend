package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("E")
public class Espectador extends Usuario {
	@OneToMany(mappedBy = "espectador",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<>();
	
	
	public Espectador() {
		super();
	}

	public Espectador(String nickname, String nombre, String apellido, String correo, Date fNac, String contra,String imagen) {
		super(nickname, nombre, apellido, correo, fNac, contra,imagen);
	}

	@Override
	public String toString() {
		return "Espectador []";
	}
	
	
}
