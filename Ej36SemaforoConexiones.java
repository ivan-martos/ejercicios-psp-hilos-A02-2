import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejercicio 36. Semáforo como límite de concurrencia.
 *
 * Una base de datos admite como mucho 5 conexiones a la vez. Veinte clientes la usan 100 ms cada
 * uno. Además de esperar a tener conexión, cada cliente apunta cuántas hay en uso y el máximo
 * que se ha llegado a ver, que nunca puede pasar de 5. Lo que hay que completar está en
 * usarConexion().
 */
public class Ej36SemaforoConexiones {

    public static void main(String[] args) {
        Semaphore conexiones = new Semaphore(5);
        AtomicInteger enUso = new AtomicInteger(0);
        AtomicInteger maximo = new AtomicInteger(0);

        try (ExecutorService clientes = Executors.newFixedThreadPool(20)) {
            for (int i = 0; i < 20; i++) {
                clientes.submit(() -> usarConexion(conexiones, enUso, maximo));
            }
        }
        System.out.println("Máximo de conexiones a la vez: " + maximo.get() + " (tendría que ser 5)");
        System.out.println("En uso al final: " + enUso.get() + " (tendría que ser 0)");
    }

    /** Espera una conexión libre, la usa 100 ms y la libera. */
    static void usarConexion(Semaphore conexiones, AtomicInteger enUso, AtomicInteger maximo) {
        // TODO (13 líneas): espera a que haya una conexión libre (acquire). Con ella cogida:
        //     suma 1 a enUso y guarda el resultado, actualiza maximo con
        //     maximo.accumulateAndGet(ese valor, Math::max), tarda 100 ms (Thread.sleep) y, en un
        //     finally, resta 1 a enUso y libera la conexión (en ese orden). Si interrumpen al
        //     hilo mientras esperas, restaura la interrupción y termina sin liberar nada
    }
}
