import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Ejercicio 40. Productor y consumidor con una cola bloqueante.
 *
 * Un productor mete los números de 1 a 10.000 en una cola de capacidad 10 y, al final, un número
 * especial (-1) que significa "no hay más". Un consumidor saca números y los suma hasta que
 * encuentra el -1. Lo que hay que completar está en producir() y consumir().
 */
public class Ej40ColaBloqueante {

    static final int FIN = -1;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        BlockingQueue<Integer> cola = new ArrayBlockingQueue<>(10);

        try (ExecutorService hilos = Executors.newFixedThreadPool(2)) {
            hilos.submit(() -> {
                producir(cola, 10_000);
                return null;
            });
            Future<Long> suma = hilos.submit(() -> consumir(cola));
            System.out.println("Suma: " + suma.get() + " (tendría que ser " + 10_000L * 10_001 / 2 + ")");
        }
    }

    /** Mete los números de 1 a n en la cola y después el FIN. */
    static void producir(BlockingQueue<Integer> cola, int n) throws InterruptedException {
        // TODO (4 líneas): mete cada número con cola.put(...) (espera si la cola está llena) y,
        //     al terminar el bucle, mete FIN
    }

    /** Saca números de la cola y los suma hasta encontrar el FIN. Devuelve la suma. */
    static long consumir(BlockingQueue<Integer> cola) throws InterruptedException {
        long suma = 0;
        // TODO (6 líneas): bucle infinito: saca con cola.take() (espera si está vacía); si es
        //     FIN, sal del bucle; si no, súmalo a suma

        return suma;
    }
}
