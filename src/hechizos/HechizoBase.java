package hechizos;

import java.util.Objects;

public abstract class HechizoBase implements Hechizo{
	private String nombre;
	
	public HechizoBase(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HechizoBase other = (HechizoBase) obj;
		return Objects.equals(nombre, other.nombre);
	}

	
}
