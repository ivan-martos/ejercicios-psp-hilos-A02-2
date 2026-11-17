import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejercicio 33. compareAndSet.
 *
 * Ocho hilos generan 100.000 valores cada uno y todos comparten un AtomicInteger con el máximo
 * visto hasta ahora. Leer, comparar y escribir son tres pasos, así que hay que usar
 * compareAndSet en un bucle. Lo que hay que completar está en registrarMaximo().
 */
public class Ej33AtomicaMaximo {

    public static void main(String[] args) {
        AtomicInteger maximo = new AtomicInteger(Integer.MIN_VALUE);

        try (ExecutorService hilos = Executors.newFixedThreadPool(8)) {
            for (int i = 0; i < 8; i++) {
                int hilo = i;
                hilos.submit(() -> {
                    for (int j = 0; j < 100_000; j++) {
                        registrarMaximo(maximo, generar(hilo, j));
                    }
                });
            }
        }
        int esperado = Integer.MIN_VALUE;
        for (int hilo = 0; hilo < 8; hilo++) {
            for (int j = 0; j < 100_000; j++) {
                esperado = Math.max(esperado, generar(hilo, j));
            }
        }
        System.out.println("Máximo:   " + maximo.get());
        System.out.println("Esperado: " + esperado);
    }

    static int generar(int hilo, int j) {
        return (int) ((hilo * 7_919L + j * 104_729L) % 1_000_003);
    }

    /** Si valor es mayor que el máximo guardado, lo sustituye. Nunca lo baja. */
    static void registrarMaximo(AtomicInteger maximo, int valor) {
        // TODO (7 líneas): bucle: lee el actual con maximo.get(); si valor <= actual, termina
        //     (return); si no, intenta maximo.compareAndSet(actual, valor) y, si falla porque otro
        //     hilo lo ha cambiado, repite el bucle.
        //     (Reto: hazlo después en una sola línea con maximo.accumulateAndGet(valor, Math::max))
    }
}
