import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Ejercicio 37. Semáforos para alternar turnos.
 *
 * Dos hilos tienen que escribir "ping" y "pong" alternándose, cinco veces cada uno: ping, pong,
 * ping, pong... Se consigue con dos semáforos: cada hilo espera el suyo, escribe y da el turno al
 * otro. Lo que hay que completar está en turno().
 */
public class Ej37SemaforoPingPong {

    public static void main(String[] args) {
        Semaphore turnoPing = new Semaphore(1);   // empieza ping
        Semaphore turnoPong = new Semaphore(0);

        try (ExecutorService hilos = Executors.newFixedThreadPool(2)) {
            hilos.submit(() -> {
                turno("ping", turnoPing, turnoPong, 5);
                return null;
            });
            hilos.submit(() -> {
                turno("pong", turnoPong, turnoPing, 5);
                return null;
            });
        }
        System.out.println("Tendría que haber salido ping pong ping pong... cinco veces");
    }

    /** Escribe la palabra veces veces, esperando su turno cada vez y dándoselo luego al otro. */
    static void turno(String palabra, Semaphore mio, Semaphore siguiente, int veces) throws InterruptedException {
        // TODO (5 líneas): repite veces veces: espera el semáforo mio (acquire), escribe la
        //     palabra y da un permiso al semáforo siguiente (release)
    }
}
