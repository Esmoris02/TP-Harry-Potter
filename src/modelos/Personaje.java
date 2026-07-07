package modelos;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import efectos.Efecto;
import hechizos.HechizoBase;

public abstract class Personaje {
	protected String nombre;
	protected double nivelMagia;
	protected double puntosVida;
	protected double maximoNivelMagia;
	protected double maximoPuntosVida;
	protected double nivelProteccion;
	protected boolean aturdido;
	protected List<HechizoBase> hechizosDisponibles = new LinkedList<>();
	protected List<Efecto> efectosAAplicar = new LinkedList<>();

	public Personaje(String nombre, double nivelMagia, double puntosVida) {
		this.nombre = nombre;
		this.nivelMagia = nivelMagia;
		this.puntosVida = puntosVida;
		this.hechizosDisponibles = new ArrayList<>();
	}

	public String obtenerNombre() {
		return nombre;
	}

	public double obtenerNivelMagia() {
		return nivelMagia;
	}

	public double obtenerPuntosVida() {
		return puntosVida;
	}

	public double obtenerNivelProteccion() {
		return nivelProteccion;
	}

	public void gastoPuntosMagia(double costo) {
		if (nivelMagia >= costo) {
			this.nivelMagia -= costo;
		} else {
			System.out.println("No es posible realizar este hechizo por bajo MP.");
		}
	}

	public void recibirEfecto(Efecto efecto) {
		this.efectosAAplicar.add(efecto);
	}

	public void aplicarEfectos(List<Efecto> efectoAAplicar) {
		if (efectosAAplicar == null || efectosAAplicar.isEmpty()) {
			return; // no hay efectos que aplicar
		}

		Iterator<Efecto> it = efectosAAplicar.iterator();
		while (it.hasNext() && estaSaludable()) {
			Efecto efecto = it.next();
			efecto.aplicar(this);

			// si el efecto sabe cuándo expira, lo eliminamos
			if (efecto.haExpirado()) {
				it.remove();
			}
		}
	}

	public void reducirVida(double cantidad) {
		if (this.nivelProteccion > 0) {
			double exceso = cantidad - this.nivelProteccion;

			if (exceso > 0) {
				// El escudo absorbe lo que puede y se rompe
				System.out.println("Se ha roto el escudo de " + this.nombre);
				this.nivelProteccion = 0;
				this.puntosVida -= exceso;

				// Verificar si el exceso de daño deja fuera de combate
				if (!estaSaludable()) {
					this.puntosVida = 0;
					System.out.println(this.nombre + " ha quedado fuera de combate.");
				}

			} else {
				// El escudo absorbe todo el daño
				this.nivelProteccion -= cantidad;
				System.out.println(this.nombre + " evitó el daño con su escudo.");
			}

		} else {
			// Sin escudo, daño directo a la vida
			this.puntosVida -= cantidad;
			if (!estaSaludable()) {
				this.puntosVida = 0;
				System.out.println(this.nombre + " ha quedado fuera de combate.");
			}
		}
	}

	public void aumentarVida(double cantidad) {
		if (cantidad + puntosVida >= maximoPuntosVida) {
			puntosVida = maximoPuntosVida;
		} else {
			puntosVida += cantidad;
		}
	}

	public void aplicarProteccion(double resistencia) {
		nivelProteccion = resistencia;
	}

	public void aplicarAturdimiento() {
		aturdido = true;
	}

	public void sacarAturdimiento() {
		aturdido = false;
	}

	public boolean estaAturtido() {
		return aturdido;
	}

	public boolean estaSaludable() {
		return this.puntosVida > 0;
	}

	public void aprenderHechizo(HechizoBase hechizo) {
		this.hechizosDisponibles.add(hechizo);
	}

	public HechizoBase elegirHechizo(Set<HechizoBase> hechizosUsadosEnTurno) {
		List<HechizoBase> hechizosDisponiblesParaUsar = new LinkedList<>();
		Random rand = new Random();
		int indice;
		for (HechizoBase h : hechizosDisponibles) {
			if (!hechizosUsadosEnTurno.contains(h)) {
				hechizosDisponiblesParaUsar.add(h);
			}
		}
		if (hechizosDisponiblesParaUsar.isEmpty()) {
			return null;
		}
		indice = rand.nextInt(hechizosDisponiblesParaUsar.size());
		return hechizosDisponiblesParaUsar.get(indice);
	}

	public void recuperarMagia() {
		if (nivelMagia + this.obtenerTasaRecuperacionMagia() >= maximoNivelMagia) {
			nivelMagia = maximoNivelMagia;
		} else {
			nivelMagia += this.obtenerTasaRecuperacionMagia();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		sb.append(" (");
		sb.append(this.getClass().getSimpleName());
		sb.append("): ");

		if (estaSaludable()) {
			sb.append((int) puntosVida);
			sb.append(" HP || ");
			sb.append((int) nivelMagia);
			sb.append(" MP");

			// Filtrar efectos activos
			List<Efecto> activos = efectosAAplicar.stream().filter(e -> !e.haExpirado()).toList();

			// Mostrar solo si hay efectos activos
			if (!activos.isEmpty()) {
				sb.append("  Estados: [");
				for (int i = 0; i < activos.size(); i++) {
					sb.append(activos.get(i).toString());
					if (i < activos.size() - 1) {
						sb.append(", ");
					}
				}
				sb.append("]");
			}

		} else {
			sb.append("  [ELIMINADO]");
		}

		return sb.toString();
	}

	public abstract double obtenerMultiplicadorHechizoOscuro();

	public abstract double obtenerMultiplicadorCuracion();

	public abstract double obtenerTasaRecuperacionMagia();

	public abstract double obtenerMultiplicadorDefensa();

	public abstract double obtenerProbabilidadImpactoHechizoFatal();

}
