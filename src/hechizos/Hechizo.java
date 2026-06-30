package hechizos;

import modelos.Personaje;

public interface Hechizo {
	public void ejecutar(Personaje lanzador, Personaje objetivo);

	public String getNombre();

	public double getCoste();
}
