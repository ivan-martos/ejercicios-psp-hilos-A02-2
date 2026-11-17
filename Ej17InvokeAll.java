import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Ejercicio 17. invokeAll.
 *
 * Diez tareas suman los números de 1 a k * 100.000 (k de 1 a 10). En vez de entregarlas una a una
 * con submit, se entregan todas de golpe con invokeAll, que espera a que terminen. Lo que hay que
 * completar está en sumarTodas().
 */
public class Ej17InvokeAll {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Callable<Long>> tareas = new ArrayList<>();
        long esperado = 0;
        for (int k = 1; k <= 10; k++) {
            long hasta = k * 100_000L;
            tareas.add(() -> sumar(hasta));
            esperado += hasta * (hasta + 1) / 2;
        }
        System.out.println("Resultado: " + sumarTodas(tareas));
        System.out.println("Esperado:  " + esperado);
    }

    static long sumar(long hasta) {
        long suma = 0;
        for (long n = 1; n <= hasta; n++) {
            suma += n;
        }
        return suma;
    }

    /** Ejecuta todas las tareas en un grupo de 4 hilos y devuelve la suma de sus resultados. */
    static long sumarTodas(List<Callable<Long>> tareas) throws InterruptedException, ExecutionException {
        long total = 0;
        // TODO (8 líneas): crea con try-with-resources un grupo de 4 hilos. Entrégale la lista
        //     entera con invokeAll (devuelve una List<Future<Long>> cuando todas han terminado) y
        //     suma en total lo que devuelve cada Future

        return total;
    }
}
