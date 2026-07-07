package hechizos;

import java.util.Objects;

import efectos.Efecto;
import modelos.Personaje;

public abstract class HechizoBase implements Hechizo {
	private String nombre;
	private double coste;
	private TipoHechizo tipo;
	protected Efecto efectoCausado;

	protected HechizoBase(String nombre, double coste, TipoHechizo tipo) {
		this.nombre = nombre;
		this.coste = coste;
		this.tipo = tipo;
	}

	abstract public void ejecutar(Personaje lanzador, Personaje objetivo);

	@Override
	public String obtenerNombre() {
		return this.nombre;
	}

	@Override
	public double obtenerCoste() {
		return this.coste;
	}

	@Override
	public TipoHechizo obtenerTipo() {
		return this.tipo;
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
