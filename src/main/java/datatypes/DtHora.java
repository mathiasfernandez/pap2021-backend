package datatypes;

public class DtHora {
	
 private int hora;
 private int minuto;
 private int segundo;
 
public DtHora(int hora, int minuto, int segundo) {
	super();
	this.hora = hora;
	this.minuto = minuto;
	this.segundo = segundo;
}

public int getHora() {
	return hora;
}

public int getMinuto() {
	return minuto;
}


public int getSegundo() {
	return segundo;
}

@Override
public String toString() {
	return "DtHora [hora=" + hora + ", minuto=" + minuto + ", segundo=" + segundo + "]";
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DtHora other = (DtHora) obj;
	return hora == other.hora && minuto == other.minuto && segundo == other.segundo;
}

 
}
