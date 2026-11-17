import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Ejercicio 20. Future con tiempo límite.
 *
 * Una tarea tarda un tiempo en terminar. Hay que esperar su resultado como mucho un tiempo
 * límite: si se pasa, se cancela la tarea y se devuelve "TIMEOUT". Lo que hay que completar está
 * en esperarConLimite().
 */
public class Ej20FuturoConTiempoLimite {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Tarea de 200 ms, límite 1000 ms: " + esperarConLimite(200, 1000));
        System.out.println("Tarea de 3000 ms, límite 500 ms: " + esperarConLimite(3000, 500));
        System.out.println("Tendría que salir: terminada y TIMEOUT");
    }

    static String tareaLenta(int ms) throws InterruptedException {
        Thread.sleep(ms);
        return "terminada";
    }

    /** Ejecuta tareaLenta(ms) y espera su resultado como mucho limiteMs milisegundos. */
    static String esperarConLimite(int ms, int limiteMs) throws InterruptedException, ExecutionException {
        String resultado = "";
        // TODO (12 líneas): crea con try-with-resources un grupo de 1 hilo y entrégale la tarea
        //     tareaLenta(ms). Pide el resultado con get(limiteMs, TimeUnit.MILLISECONDS). Si salta
        //     TimeoutException, cancela la tarea con cancel(true) y deja resultado = "TIMEOUT"

        return resultado;
    }
}
