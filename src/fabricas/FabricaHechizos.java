package fabricas;

import java.util.Random;
import hechizos.HechizoBase;
import hechizos.AvadaKedavra;
import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Protego;
import hechizos.Confringo;

public class FabricaHechizos {
	
	// Instanciamos un Random para variar entre los distintos tipos de hechizos
	private static Random rand = new Random();
public static HechizoBase crearHechizoPorTipo(String tipo) {
        
        // Usamos switch para evaluar el tipo y devolver el objeto correcto
        switch (tipo.toLowerCase()) {
            case "ataque":
                return new Expelliarmus();
            case "oscuro":
            {
            	int type = rand.nextInt(2);
            	
            	if(type == 0)
            		return new Confringo();
            	return new AvadaKedavra();
            }
            case "defensa":
                return new Protego();
            case "curacion":
                return new ExpectoPatronum();
            default:
                throw new IllegalArgumentException("Tipo de hechizo no reconocido: " + tipo);
        }
    }

}
