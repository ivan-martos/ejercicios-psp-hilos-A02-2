import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejercicio 25. Hilos virtuales (hace falta Java 21 o superior).
 *
 * Se lanzan 10.000 tareas que esperan 100 ms cada una. Con hilos normales tardaría muchísimo;
 * con un hilo virtual por tarea tarda un par de segundos como mucho. Lo que hay que completar está
 * en lanzar().
 */
public class Ej25HilosVirtuales {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        int hechas = lanzar(10_000);
        System.out.println("Tareas hechas: " + hechas + " (tendrían que ser 10000)");
        System.out.println("Ha tardado " + (System.currentTimeMillis() - inicio) + " ms");
    }

    /** Lanza las tareas, espera a que terminen y devuelve cuántas se han hecho. */
    static int lanzar(int tareas) {
        AtomicInteger hechas = new AtomicInteger(0);
        // TODO (8 líneas): crea con try-with-resources un Executors.newVirtualThreadPerTaskExecutor().
        //     Entrégale tantas tareas como tareas. Cada una espera 100 ms (Thread.sleep) y
        //     suma 1 a hechas. Pista: si la lambda termina con "return null;" es un Callable y
        //     puede lanzar InterruptedException sin try/catch

        return hechas.get();
    }
}
