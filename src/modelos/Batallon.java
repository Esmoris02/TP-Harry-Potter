package modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Random;
import java.util.Scanner;

import hechizos.HechizoBase;

public class Batallon {
	private List<Personaje> integrantes;
	private Map<Personaje, List<HechizoBase>> historialHechizos;
	private Set<HechizoBase> hechizosUsadosEnTurnoActual;

	public Batallon() {
		this.integrantes = new ArrayList<>();
		this.historialHechizos = new HashMap<>();
		this.hechizosUsadosEnTurnoActual = new HashSet<>();
	}

	public void agregarPersonaje(Personaje personaje) {
		this.integrantes.add(personaje);
	    int indice = integrantes.indexOf(personaje) + 1;
	    personaje.modificarNombre(String.valueOf(indice));
	    System.out.println("-" + personaje.obtenerNombre());
	    this.historialHechizos.put(personaje, new ArrayList<>());
	}

	public boolean tienePersonajesSaludables() {
		for (Personaje personaje : integrantes) {
			if (personaje.estaSaludable()) {
				return true;
			}
		}
		return false;
	}

	protected Personaje obtenerPersonajeSaludableAleatorio() {
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
		HechizoBase hechizoAEjecutar;
		Personaje objetivo;
		hechizosUsadosEnTurnoActual.clear();
		System.out.println("-- Inicio del Ataque --");
		for (Personaje atacante : integrantes) {
			atacante.aplicarEfectos(atacante.efectosAAplicar);
			if (!atacante.estaAturtido()) {
				if (atacante.estaSaludable()) {
					objetivo = enemigo.obtenerPersonajeSaludableAleatorio();
					if (objetivo == null) {
						return;
					}
					hechizoAEjecutar = atacante.elegirHechizo(hechizosUsadosEnTurnoActual);
					if (hechizoAEjecutar != null) {
						if (atacante.obtenerNivelMagia() < hechizoAEjecutar.getCoste()) {
							atacante.recuperarMana();
							System.out.println("Nivel de magia insuficiente para ejecutar "
									+ hechizoAEjecutar.getNombre() + ", recuperando nivel de magia");
						} else {
							atacante.gastoNivelMagia(hechizoAEjecutar.getCoste());
							hechizoAEjecutar.ejecutar(atacante, objetivo);
							hechizosUsadosEnTurnoActual.add(hechizoAEjecutar);
							historialHechizos.get(atacante).add(hechizoAEjecutar);
						}
					}

				}
			} else {
				atacante.sacarAturdimiento();
			}

		}
		System.out.println("-- Fin del Ataque--");
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPresione ENTER...");
		sc.nextLine();
		limpiarPantalla();

		
	}
	
	public static void limpiarPantalla() {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	}
}
