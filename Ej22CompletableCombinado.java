import java.util.concurrent.CompletableFuture;

/**
 * Ejercicio 22. Combinar dos CompletableFuture.
 *
 * Se pide un nombre y una edad, cada uno en una tarea asíncrona que tarda un segundo. Como las
 * dos se hacen a la vez, la ficha completa tarda un segundo y no dos. Lo que hay que completar
 * está en ficha().
 */
public class Ej22CompletableCombinado {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        String texto = ficha();
        long ms = System.currentTimeMillis() - inicio;
        System.out.println(texto + " (tendría que ser \"Ana tiene 30 años\")");
        System.out.println("Ha tardado " + ms + " ms (tendría que rondar los 1000, no los 2000)");
    }

    static void dormir(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static String obtenerNombre() {
        dormir(1000);
        return "Ana";
    }

    static int obtenerEdad() {
        dormir(1000);
        return 30;
    }

    /** Pide nombre y edad a la vez y devuelve "NOMBRE tiene EDAD años". */
    static String ficha() {
        // TODO (6 líneas): crea dos CompletableFuture con supplyAsync, uno para el nombre y otro
        //     para la edad. Combínalos con thenCombine(otro, (nombre, edad) -> ...) para construir
        //     el texto, y termina con join()
        return "";  // provisional, para que compile: bórralo
    }
}
