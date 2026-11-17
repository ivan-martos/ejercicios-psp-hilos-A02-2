import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * Ejercicio 34. Mapa de contadores con LongAdder.
 *
 * Cuatro hilos cuentan palabras a la vez en un mapa palabra -> LongAdder. Hay que crear el
 * contador de una palabra la primera vez que aparece, sin que dos hilos creen dos distintos. Lo
 * que hay que completar está en contar().
 */
public class Ej34MapaContadores {

    static final String[] PALABRAS = {"hilo", "tarea", "cerrojo", "futuro", "semáforo"};
    static final int VECES = 50_000;

    public static void main(String[] args) {
        ConcurrentMap<String, LongAdder> contadores = new ConcurrentHashMap<>();

        try (ExecutorService hilos = Executors.newFixedThreadPool(4)) {
            for (int i = 0; i < 4; i++) {
                hilos.submit(() -> contar(contadores));
            }
        }
        Map<String, Long> ordenado = new TreeMap<>();
        contadores.forEach((palabra, contador) -> ordenado.put(palabra, contador.sum()));
        System.out.println("Esperado: 40000 de cada palabra");
        System.out.println("Cuentas:  " + ordenado);
    }

    /** Cuenta VECES palabras: la palabra j es PALABRAS[j % PALABRAS.length]. */
    static void contar(ConcurrentMap<String, LongAdder> contadores) {
        // TODO (4 líneas): recorre las VECES palabras y, por cada una, saca su contador con
        //     computeIfAbsent(palabra, k -> new LongAdder()) y súmale 1 con increment()
    }
}
