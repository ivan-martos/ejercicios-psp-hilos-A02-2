import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Ejercicio 16. Executor y Future.
 *
 * Busca el máximo de un array grande repartiéndolo en TRAMOS tareas, que ejecuta un grupo con
 * tantos hilos como núcleos. Cada tarea devuelve el máximo de su tramo. Lo que hay que completar
 * está en maximoEnParalelo().
 */
public class Ej16MaximoFuturos {

    static final int TAMANO = 4_000_000;
    static final int TRAMOS = 8;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] datos = new int[TAMANO];
        Random azar = new Random(42);
        for (int i = 0; i < TAMANO; i++) {
            datos[i] = azar.nextInt(1_000_000_000);
        }
        System.out.println("Máximo en paralelo:   " + maximoEnParalelo(datos));
        System.out.println("Máximo en secuencial: " + Arrays.stream(datos).max().getAsInt());
    }

    /** Devuelve el máximo de datos[desde] a datos[hasta - 1] (hasta no incluido). */
    static int maximoTramo(int[] datos, int desde, int hasta) {
        int maximo = Integer.MIN_VALUE;
        for (int i = desde; i < hasta; i++) {
            if (datos[i] > maximo) {
                maximo = datos[i];
            }
        }
        return maximo;
    }

    /**
     * Reparte el array en TRAMOS tareas, las ejecuta con un grupo de hilos y devuelve el mayor de
     * los máximos que devuelve cada tarea.
     */
    static int maximoEnParalelo(int[] datos) throws InterruptedException, ExecutionException {
        int nucleos = Runtime.getRuntime().availableProcessors();
        int tamano = datos.length / TRAMOS;
        int maximo = Integer.MIN_VALUE;
        // TODO (11 líneas): crea con try-with-resources un grupo de nucleos hilos. Entrégale una
        //     tarea maximoTramo(datos, desde, hasta) por cada tramo (el tramo i va de i * tamano
        //     a (i + 1) * tamano, sin incluir el final) y guarda los Future en una lista. Cuando
        //     las hayas entregado todas, quédate en maximo con el mayor valor que devuelve cada una

        return maximo;
    }
}
