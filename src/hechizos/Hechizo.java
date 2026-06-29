package hechizos;

import java.util.Objects;

import efectos.Efecto;
import modelos.Personaje;

public abstract class Hechizo{
	protected String nombre;
	protected double coste;
	protected Efecto efectoCausado;
	
	protected Hechizo(String nombre, double coste, Efecto efectoCausado) {
		this.nombre = nombre;
		this.coste = coste;
		this.efectoCausado = efectoCausado;
	}
	
	abstract public void ejecutar(Personaje lanzador, Personaje objetivo);
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getCoste() {
		return this.coste;
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
		Hechizo other = (Hechizo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	
}
