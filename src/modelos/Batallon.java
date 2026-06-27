package modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import hechizos.Hechizo;

public class Batallon {
	private List<Personaje> integrantes;
	private Map<Personaje, List<Hechizo>> historialHechizos;
	private Set<Hechizo> hechizosUsadosEnTurnoActual;
	
	public Batallon() {
		this.integrantes = new ArrayList<>();
		this.historialHechizos = new HashMap<>();
		this.hechizosUsadosEnTurnoActual = new HashSet<>();		
	}
	
	public void agregarPersonaje(Personaje personaje) {
		this.integrantes.add(personaje);
		this.historialHechizos.put(personaje, new ArrayList<>());
	}
	
	public boolean tienePersonajesSaludables() {
		for (Personaje personaje : integrantes) {
			if(personaje.estaSaludable()) {
				return true;
			}
		}
		return false;
	}
	
	public Personaje obtenerPersonajeSaludable() {
		for (Personaje personaje : integrantes) {
			if(personaje.estaSaludable()) {
				return personaje;
			}
		}
		return null;
		
	}
	
	public void atacar(Batallon enemigo) {
		Hechizo hechizoAEjecutar;
		Personaje objetivo;
		hechizosUsadosEnTurnoActual.clear();
		System.out.println("-- Inicio del Ataque --");
		for(Personaje atacante : integrantes) {
			if(atacante.estaSaludable()) {
				objetivo = enemigo.obtenerPersonajeSaludable();
				if(objetivo == null) {
					break;
				}
				hechizoAEjecutar = atacante.elegirHechizo(hechizosUsadosEnTurnoActual);
				if(hechizoAEjecutar != null) {
					hechizoAEjecutar.ejecutar(atacante, objetivo);
					hechizosUsadosEnTurnoActual.add(hechizoAEjecutar);
					historialHechizos.get(atacante).add(hechizoAEjecutar);
				}
			}
			
		}
		System.out.println("-- Fin del Ataque--");
		
	}
}
