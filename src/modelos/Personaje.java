package modelos;

import java.util.List;
import java.util.Random;
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
	// futura implementación de hechizos
	public List<HechizoBase> hechizosDisponibles = new LinkedList<>();
	public List<Efecto> efectosAAplicar = new LinkedList<>();

	public Personaje(String nombre, double nivelMagia, double puntosVida) {
		this.nombre = nombre;
		this.nivelMagia = nivelMagia;
		this.puntosVida = puntosVida;
		// futura implementación de hechizos
		// this.hechizosDisponibles = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public double getNivelMagia() {
		return nivelMagia;
	}

	public double getPuntosVida() {
		return puntosVida;
	}

	public double getProtegido() {
		return nivelProteccion;
	}

	public void gastoMagia(double cantidad) {
		if(nivelMagia <= cantidad) {
			this.nivelMagia -= cantidad;			
		} else {
			System.out.println("No es posible realizar este hechizo por bajo nivel de magia.");
		}
	}

	public void recibirEfecto(Efecto efecto) {
		this.efectosAAplicar.add(efecto);
	}

	protected void aplicarEfectos(List<Efecto> efectoAAplicar) {
		if (efectosAAplicar == null || efectosAAplicar.isEmpty()) {
	        return; // no hay efectos que aplicar
	    }
		
		Iterator<Efecto> it = efectosAAplicar.iterator();
		while (it.hasNext()) {
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
	            System.out.println(this.nombre + " recibió " + exceso + " puntos de daño tras romperse el escudo.");
	        } else {
	            // El escudo absorbe todo el daño
	            this.nivelProteccion -= cantidad;
	            System.out.println(this.nombre + " evitó el daño con su escudo.");
	        }
	    } else {
	        // Sin escudo, daño directo a la vida
	        this.puntosVida -= cantidad;
	        System.out.println(this.nombre + " ha perdido " + cantidad + " puntos de vida.");
	        if (this.puntosVida <= 0) {
	            this.puntosVida = 0;
	            System.out.println(this.nombre + " ha quedado fuera de combate.");
	        }
	    }
	}
	
	public void aumentarVida(double cantidad) {
		if(cantidad + puntosVida >= maximoPuntosVida) {
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

	public void recuperarMana() {
		if(nivelMagia + this.obtenerTasaRecuperacionMagia() >= maximoNivelMagia) {
			nivelMagia = maximoNivelMagia;
		} else {
			nivelMagia += this.obtenerTasaRecuperacionMagia();			
		}
	}

	/*
	 * public void lanzarHechizo(Hechizo nombreHechizo, Personaje objetivo) {
	 * for(Hechizo h : hechizosDisponibles) {
	 * if(h.getClass().getSimpleName().equals(nombreHechizo)) {//Devuelve el objeto
	 * real dentro de la lista y compara con el nombre de hechizo solicitado.
	 * h.ejecutar(this, objetivo); //Si encuentra ejecuta return; } throw new
	 * IllegalArgumentException("No conoce el hechizo"); } }
	 */

	public abstract double obtenerMultiplicadorHechizoOscuro();

	public abstract double obtenerMultiplicadorCuracion();
	public abstract double obtenerTasaRecuperacionMagia();

	public abstract double obtenerMultiplicadorDefensa();

	public abstract double obtenerProbabilidadImpactoHechizoFatal();

}
