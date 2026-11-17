import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Ejercicio 29. Condiciones con un cerrojo.
 *
 * Un búfer guarda como mucho 10 números. Dos productores meten los números de 1 a 5.000 cada uno
 * y dos consumidores sacan 5.000 números cada uno. Si el búfer está lleno, el productor espera; si
 * está vacío, el consumidor espera. Lo que hay que completar está en BuferAcotado.
 */
public class Ej29CondicionBufer {

    public static void main(String[] args) {
        BuferAcotado bufer = new BuferAcotado(10);
        AtomicLong suma = new AtomicLong(0);

        try (ExecutorService hilos = Executors.newFixedThreadPool(4)) {
            for (int i = 0; i < 2; i++) {
                hilos.submit(() -> {
                    for (int n = 1; n <= 5_000; n++) {
                        bufer.poner(n);
                    }
                    return null;
                });
                hilos.submit(() -> {
                    for (int n = 1; n <= 5_000; n++) {
                        suma.addAndGet(bufer.sacar());
                    }
                    return null;
                });
            }
        }
        System.out.println("Suma: " + suma.get() + " (tendría que ser " + 2L * 5_000 * 5_001 / 2 + ")");
    }

    static class BuferAcotado {

        private final ReentrantLock cerrojo = new ReentrantLock();
        private final Condition noLleno = cerrojo.newCondition();
        private final Condition noVacio = cerrojo.newCondition();
        private final Deque<Integer> cola = new ArrayDeque<>();
        private final int capacidad;

        BuferAcotado(int capacidad) {
            this.capacidad = capacidad;
        }

        /** Mete un número; si el búfer está lleno, espera a que haya hueco. */
        void poner(int numero) throws InterruptedException {
            // TODO (11 líneas): con el cerrojo cogido, mientras cola.size() == capacidad espera
            //     con noLleno.await() (¡un while, no un if!). Luego añade el número con
            //     cola.addLast y avisa a un consumidor con noVacio.signal(). Suelta en finally
        }

        /** Saca un número; si el búfer está vacío, espera a que haya alguno. */
        int sacar() throws InterruptedException {
            // TODO (11 líneas): con el cerrojo cogido, mientras la cola esté vacía espera con
            //     noVacio.await(). Luego saca con cola.removeFirst(), avisa a un productor con
            //     noLleno.signal() y devuelve el número. Suelta en finally
            return 0;  // provisional, para que compile: bórralo
        }
    }
}
