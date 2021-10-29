package datatypes;

import java.util.Objects;

public class DtRegistro {
		
	private String nickname;
	private String nombreFun;
	
	
	public DtRegistro() {
		super();
	}
	
	public DtRegistro(String nickname, String nombreFun) {
		super();
		this.nickname = nickname;
		this.nombreFun = nombreFun;
	}
	
	public String getNickname() {
		return nickname;
	}

	public String getNombreFun() {
		return nombreFun;
	}

	@Override
	public String toString() {
		return "DtRegistro [nickname=" + nickname + ", nombreFun=" + nombreFun + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtRegistro other = (DtRegistro) obj;
		return Objects.equals(nickname, other.nickname) && Objects.equals(nombreFun, other.nombreFun);
	}
	
	
	
}
