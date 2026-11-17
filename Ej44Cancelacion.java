import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejercicio 44. Cancelar una tarea.
 *
 * Una tarea cuenta iteraciones sin parar, una cada 10 ms, hasta que la interrumpen. El programa
 * la deja correr un rato y la cancela con cancel(true). Lo importante es que la tarea responda a
 * la interrupción y pare de verdad. Lo que hay que completar está en trabajar() y
 * cancelarTrasPausa().
 */
public class Ej44Cancelacion {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger iteraciones = new AtomicInteger(0);
        boolean cancelada = cancelarTrasPausa(iteraciones, 300);
        int antes = iteraciones.get();
        Thread.sleep(200);
        int despues = iteraciones.get();
        System.out.println("Cancelada: " + cancelada + " (tendría que ser true)");
        System.out.println("Iteraciones: " + antes + " (tendrían que ser unas 30)");
        System.out.println("¿Sigue contando? " + (despues != antes) + " (tendría que ser false)");
    }

    /** Cuenta una iteración cada 10 ms hasta que interrumpan al hilo. */
    static void trabajar(AtomicInteger iteraciones) {
        // TODO (9 líneas): mientras !Thread.currentThread().isInterrupted(): suma 1 a iteraciones
        //     y duerme 10 ms. Si Thread.sleep lanza InterruptedException, restaura la interrupción
        //     con Thread.currentThread().interrupt() para que el bucle termine
    }

    /** Lanza trabajar(), espera ms milisegundos y la cancela. Devuelve lo que devuelve cancel. */
    static boolean cancelarTrasPausa(AtomicInteger iteraciones, int ms) throws InterruptedException {
        boolean cancelada = false;
        // TODO (8 líneas): crea con try-with-resources un grupo de 1 hilo. Entrégale
        //     trabajar(iteraciones) y guarda el Future. Espera ms milisegundos (Thread.sleep) y
        //     guarda en cancelada lo que devuelve futuro.cancel(true)

        return cancelada;
    }
}
