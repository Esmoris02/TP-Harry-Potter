package modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Random;
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
	
	public Personaje obtenerPersonajeSaludableAleatorio() {
	    List<Personaje> saludables = new ArrayList<>();

	    for (Personaje personaje : integrantes) {
	        if (personaje.estaSaludable()) {
	            saludables.add(personaje);
	        }
	    }

	    if (saludables.isEmpty()) {
	        return null;
	    }

	    Random rand = new Random();
	    int indice = rand.nextInt(saludables.size());

	    return saludables.get(indice);
	}
	
	public void atacar(Batallon enemigo) {
		Hechizo hechizoAEjecutar;
		Personaje objetivo;
		hechizosUsadosEnTurnoActual.clear();
		System.out.println("-- Inicio del Ataque --");
		for(Personaje atacante : integrantes) {
			if(atacante.estaSaludable()) {
//				objetivo = enemigo.obtenerPersonajeSaludable();
				objetivo = enemigo.obtenerPersonajeSaludableAleatorio();
				if(objetivo == null) {
					break;
				}
				hechizoAEjecutar = atacante.elegirHechizo(hechizosUsadosEnTurnoActual);
				if(hechizoAEjecutar != null) {
					if(atacante.getNivelMagia() < hechizoAEjecutar.getCoste()) {
						atacante.recuperarMana();
						System.out.println("Mana insuficiente para atacar, recuperando MP");
					}
					else {
						atacante.gastoMana(hechizoAEjecutar.getCoste());
						hechizoAEjecutar.ejecutar(atacante, objetivo);
						hechizosUsadosEnTurnoActual.add(hechizoAEjecutar);
						historialHechizos.get(atacante).add(hechizoAEjecutar);
					}

				}
			}
			
		}
		System.out.println("-- Fin del Ataque--");
		
	}
}
