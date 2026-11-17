import java.util.concurrent.CompletableFuture;

/**
 * Ejercicio 21. CompletableFuture encadenado.
 *
 * Se pide un precio base de forma asíncrona (tarda medio segundo). Sin esperar, se le aplica el
 * 21 % de IVA y se redondea a dos decimales; solo al final se espera el resultado. Lo que hay que
 * completar está en precioFinal().
 */
public class Ej21CompletableEncadenado {

    public static void main(String[] args) {
        System.out.println("Precio final: " + precioFinal() + " (tendría que ser 121.0)");
    }

    static double obtenerPrecioBase() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return 100.0;
    }

    /** Pide el precio base en otro hilo, le aplica el IVA, lo redondea y devuelve el resultado. */
    static double precioFinal() {
        // TODO (5 líneas): con CompletableFuture.supplyAsync(...) pide el precio base y encadena
        //     con thenApply: primero multiplica por 1.21 y luego redondea con
        //     Math.round(p * 100) / 100.0. Termina con join() para esperar y devolver el valor
        return 0.0;  // provisional, para que compile: bórralo
    }
}
