package hechizos;

import modelos.Personaje;

public interface Hechizo {
	public String getNombre();
	public void ejecutar(Personaje lanzador, Personaje objetivo);
}
