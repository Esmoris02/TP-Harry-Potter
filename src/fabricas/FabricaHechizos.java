package fabricas;

import hechizos.AvadaKedabra;
import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Hechizo;
import hechizos.Protego;

public class FabricaHechizos {
public static Hechizo crearHechizoPorTipo(String tipo) {
        
        // Usamos switch para evaluar el tipo y devolver el objeto correcto
        switch (tipo.toLowerCase()) {
            case "ataque":
                return new Expelliarmus();
            case "oscuro":
                return new AvadaKedabra(); // O Confringo
            case "defensa":
                return new Protego();
            case "curacion":
                return new ExpectoPatronum();
            default:
                throw new IllegalArgumentException("Tipo de hechizo no reconocido: " + tipo);
        }
    }

}
