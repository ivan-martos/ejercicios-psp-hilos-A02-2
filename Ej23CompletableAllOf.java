import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Ejercicio 23. Esperar a muchos CompletableFuture con allOf.
 *
 * Calcula el cuadrado de cada número de una lista, cada uno en una tarea asíncrona de 200 ms, y
 * devuelve la suma de los cuadrados. Tarda unos 200 ms y no 2 segundos. Lo que hay que completar
 * está en sumaCuadrados().
 */
public class Ej23CompletableAllOf {

    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long inicio = System.currentTimeMillis();
        System.out.println("Suma: " + sumaCuadrados(numeros) + " (tendría que ser 385)");
        System.out.println("Ha tardado " + (System.currentTimeMillis() - inicio) + " ms");
    }

    static int cuadradoLento(int n) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return n * n;
    }

    /** Devuelve la suma de los cuadrados de los números, calculando cada uno en paralelo. */
    static int sumaCuadrados(List<Integer> numeros) {
        int suma = 0;
        // TODO (9 líneas): crea una lista de CompletableFuture<Integer> con supplyAsync, uno por
        //     número, llamando a cuadradoLento. Espera a todos con
        //     CompletableFuture.allOf(lista.toArray(new CompletableFuture[0])).join(), y después
        //     suma en suma el join() de cada uno

        return suma;
    }
}
