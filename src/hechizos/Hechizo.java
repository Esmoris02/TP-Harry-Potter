package hechizos;

import modelos.Personaje;

public interface Hechizo {
	public void ejecutar(Personaje lanzador, Personaje objetivo);

	public String obtenerNombre();

	public double obtenerCoste();

	public TipoHechizo obtenerTipo();
}
