import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejercicio 24. Tareas programadas.
 *
 * Un latido escribe "tic 1", "tic 2"... cada 200 milisegundos. Después de un número de latidos
 * hay que parar. Lo que hay que completar está en latir().
 */
public class Ej24Programada {

    public static void main(String[] args) throws InterruptedException {
        latir(5);
        System.out.println("Tendrían que haberse escrito tic 1 a tic 5");
    }

    /** Escribe "tic N" cada 200 ms y vuelve cuando se han escrito veces latidos. */
    static void latir(int veces) throws InterruptedException {
        AtomicInteger contador = new AtomicInteger(0);
        CountDownLatch terminado = new CountDownLatch(veces);
        // TODO (9 líneas): crea con try-with-resources un ScheduledExecutorService de 1 hilo
        //     (Executors.newScheduledThreadPool(1)). Prográmale con scheduleAtFixedRate(tarea, 0,
        //     200, TimeUnit.MILLISECONDS) una tarea que escriba "tic " + contador.incrementAndGet()
        //     y baje terminado en uno. Espera a que terminado llegue a cero (await)
    }
}
