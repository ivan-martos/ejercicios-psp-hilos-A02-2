import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Ejercicio 7. Tareas con resultado: Callable y Future.
 *
 * Cuenta los primos de 1 a HASTA repartiendo el intervalo en TRAMOS tareas. Cada tarea devuelve
 * cuántos primos hay en su tramo, y el hilo principal suma los resultados.
 */
public class Ej07CallableFuture {

    static final long HASTA = 20_000_000L;
    static final int TRAMOS = 20;             // HASTA es múltiplo de TRAMOS

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long inicio = System.currentTimeMillis();
        long total = contarEnParalelo();
        System.out.println(total + " primos hasta " + HASTA + " en "
                + (System.currentTimeMillis() - inicio) + " ms");
    }

    /**
     * Reparte el intervalo de 1 a HASTA en TRAMOS tareas, que ejecuta un grupo con tantos hilos como
     * núcleos, y devuelve la suma de lo que devuelve cada tarea.
     */
    static long contarEnParalelo() throws InterruptedException, ExecutionException {
        int nucleos = Runtime.getRuntime().availableProcessors();
        long tamano = HASTA / TRAMOS;
        long total = 0;
        // TODO (11 líneas): crea con try-with-resources un grupo de nucleos hilos. Entrégale una
        //     tarea contarPrimos(desde, hasta) por cada tramo (el tramo i va de i * tamano + 1 a
        //     (i + 1) * tamano) y guarda los Future en una lista. Cuando las hayas entregado
        //     todas, suma en total lo que devuelve cada una
        return total;
    }

    /** Cuenta los primos entre desde y hasta, ambos incluidos. Ya está hecho. */
    static long contarPrimos(long desde, long hasta) {
        long cuenta = 0;
        for (long n = desde; n <= hasta; n++) {
            if (esPrimo(n)) {
                cuenta++;
            }
        }
        return cuenta;
    }

    static boolean esPrimo(long n) {
        if (n < 2) {
            return false;
        }
        if (n % 2 == 0) {
            return n == 2;
        }
        for (long d = 3; d * d <= n; d += 2) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }
}
