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
		hechizosUsadosEnTurnoActual.clear();
		for (Personaje atacante : integrantes) {
			procesarTurnoDe(atacante, enemigo);
		}
		esperarEnter();
		limpiarPantalla();
	}

	private void procesarTurnoDe(Personaje atacante, Batallon enemigo) {
		atacante.aplicarEfectos(atacante.getEfectosAAplicar());

		if (atacante.estaAturtido()) {
			atacante.sacarAturdimiento();
			return;
		}

		if (!atacante.estaSaludable())
			return;

		Personaje objetivo = enemigo.obtenerPersonajeSaludableAleatorio();
		if (objetivo == null)
			return;

		HechizoBase hechizo = atacante.elegirHechizo(hechizosUsadosEnTurnoActual);
		if (hechizo == null) {
			System.out.println(atacante.obtenerNombre()
					+ "no puede repetir el mismo hechizo en el turno del batallon, así que no lanza nada");
			return;
		}

		if (atacante.obtenerNivelMagia() < hechizo.obtenerCoste()) {
			atacante.recuperarMagia();
			System.out.println(atacante.obtenerNombre() + "no tiene magia insuficiente para ejecutar "
					+ hechizo.obtenerNombre() + ", así que recupera nivel de magia.");
		} else {
			atacante.gastoPuntosMagia(hechizo.obtenerCoste());
			hechizo.ejecutar(atacante, objetivo);
			hechizosUsadosEnTurnoActual.add(hechizo);
			historialHechizos.get(atacante).add(hechizo);
		}
	}

	public List<Personaje> obtenerIntegrantes() {
		return integrantes;
	}

	private static void limpiarPantalla() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private void esperarEnter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPresione ENTER para continuar...");
		sc.nextLine();
	}
}
