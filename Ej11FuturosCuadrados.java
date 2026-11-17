import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Ejercicio 11. Executor y Future.
 *
 * Suma los cuadrados de 1 a HASTA repartiendo el trabajo en TRAMOS tareas, que ejecuta un grupo
 * de hilos con tantos hilos como núcleos. Cada tarea devuelve la suma de su tramo y al final se
 * suman todas. Lo que hay que completar está en sumarEnParalelo().
 */
public class Ej11FuturosCuadrados {

    static final long HASTA = 1_000_000;
    static final int TRAMOS = 20;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long resultado = sumarEnParalelo();
        long esperado = HASTA * (HASTA + 1) * (2 * HASTA + 1) / 6;   // fórmula cerrada
        System.out.println("Resultado: " + resultado);
        System.out.println("Esperado:  " + esperado);
    }

    /** Suma los cuadrados de los números de desde a hasta, ambos incluidos. */
    static long sumarCuadrados(long desde, long hasta) {
        long suma = 0;
        for (long n = desde; n <= hasta; n++) {
            suma += n * n;
        }
        return suma;
    }

    /**
     * Reparte el intervalo de 1 a HASTA en TRAMOS tareas, que ejecuta un grupo con tantos hilos
     * como núcleos, y devuelve la suma de lo que devuelve cada tarea.
     */
    static long sumarEnParalelo() throws InterruptedException, ExecutionException {
        int nucleos = Runtime.getRuntime().availableProcessors();
        long tamano = HASTA / TRAMOS;
        long total = 0;
        // TODO (11 líneas): crea con try-with-resources un grupo de nucleos hilos. Entrégale una
        //     tarea sumarCuadrados(desde, hasta) por cada tramo (el tramo i va de i * tamano + 1
        //     a (i + 1) * tamano) y guarda los Future en una lista. Cuando las hayas entregado
        //     todas, suma en total lo que devuelve cada una

        return total;
    }
}
