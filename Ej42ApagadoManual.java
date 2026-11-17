import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejercicio 42. Apagar un ExecutorService a mano.
 *
 * Hasta ahora el try-with-resources lo cerraba solo. Aquí hay que hacerlo a mano: dejar de aceptar
 * tareas (shutdown), esperar a que terminen las pendientes (awaitTermination) y, si no terminan a
 * tiempo, forzar la parada (shutdownNow). Lo que hay que completar está en ejecutar().
 */
public class Ej42ApagadoManual {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hechas: " + ejecutar(40) + " (tendrían que ser 40)");
    }

    /** Ejecuta las tareas en un grupo de 4 hilos y devuelve cuántas se han completado. */
    static int ejecutar(int tareas) throws InterruptedException {
        AtomicInteger hechas = new AtomicInteger(0);
        // TODO (14 líneas): crea un grupo de 4 hilos SIN try-with-resources. Entrégale tantas
        //     tareas como tareas; cada una espera 50 ms (Thread.sleep, captura la excepción
        //     y restaura la interrupción) y suma 1 a hechas. Después llama a shutdown() y espera
        //     con awaitTermination(10, TimeUnit.SECONDS); si devuelve false, llama a shutdownNow()

        return hechas.get();
    }
}
