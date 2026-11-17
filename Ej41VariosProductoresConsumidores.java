import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Ejercicio 41. Varios productores y varios consumidores.
 *
 * Tres productores meten los números de 1 a 5.000 cada uno en la misma cola. Dos consumidores
 * sacan y suman. Con varios consumidores hace falta un FIN por cada uno, y solo se pueden poner
 * cuando TODOS los productores han terminado. Lo que hay que completar está en consumir() y
 * terminarConsumidores().
 */
public class Ej41VariosProductoresConsumidores {

    static final int FIN = -1;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        BlockingQueue<Integer> cola = new LinkedBlockingQueue<>(100);
        AtomicLong suma = new AtomicLong(0);

        try (ExecutorService consumidores = Executors.newFixedThreadPool(2);
             ExecutorService productores = Executors.newFixedThreadPool(3)) {
            for (int i = 0; i < 2; i++) {
                consumidores.submit(() -> {
                    consumir(cola, suma);
                    return null;
                });
            }
            List<Future<?>> producciones = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                producciones.add(productores.submit(() -> {
                    for (int n = 1; n <= 5_000; n++) {
                        cola.put(n);
                    }
                    return null;
                }));
            }
            for (Future<?> produccion : producciones) {
                produccion.get();   // espera a que acabe cada productor
            }
            terminarConsumidores(cola, 2);
        }
        System.out.println("Suma: " + suma.get() + " (tendría que ser " + 3L * 5_000 * 5_001 / 2 + ")");
    }

    /** Saca números de la cola y los suma en suma hasta encontrar un FIN. */
    static void consumir(BlockingQueue<Integer> cola, AtomicLong suma) throws InterruptedException {
        // TODO (6 líneas): bucle infinito: saca con take(); si es FIN, termina el método; si
        //     no, súmalo a suma con addAndGet
    }

    /** Pone un FIN en la cola por cada consumidor, para que todos terminen. */
    static void terminarConsumidores(BlockingQueue<Integer> cola, int consumidores) throws InterruptedException {
        // TODO (3 líneas): pon FIN en la cola (put) tantas veces como consumidores
    }
}
