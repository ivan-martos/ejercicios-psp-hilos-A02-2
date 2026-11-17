import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ejercicio 15. CountDownLatch (extra: mismo estilo, otra herramienta).
 *
 * Cinco corredores se colocan en la salida y esperan el disparo. Cuando se da la salida, cada uno
 * tarda un tiempo distinto en llegar a meta. El hilo principal espera a que lleguen los cinco
 * antes de dar la carrera por terminada. Lo que hay que completar está en correr() y arrancar().
 */
public class Ej15PistoleroLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch salida = new CountDownLatch(1);    // se abre con el disparo
        CountDownLatch llegada = new CountDownLatch(5);   // se abre cuando llegan los cinco

        try (ExecutorService corredores = Executors.newFixedThreadPool(5)) {
            for (int i = 1; i <= 5; i++) {
                int dorsal = i;
                corredores.submit(() -> correr(dorsal, salida, llegada));
            }
            Thread.sleep(500);   // los corredores se colocan
            arrancar(salida, llegada);
            System.out.println("Todos han llegado: carrera terminada");
        }
    }

    /**
     * El corredor espera el disparo, corre dorsal * 200 milisegundos y avisa de que ha llegado,
     * aunque haya una excepción.
     */
    static void correr(int dorsal, CountDownLatch salida, CountDownLatch llegada) {
        // TODO (11 líneas): espera a que se abra salida (await); escribe
        //     "El corredor " + dorsal + " sale";   tarda dorsal * 200 ms (Thread.sleep); escribe
        //     "El corredor " + dorsal + " llega a meta"; y baja llegada en uno (countDown)
        //     aunque haya una excepción. Si interrumpen al hilo, restaura la interrupción
    }

    /** Da el disparo de salida y espera a que lleguen todos los corredores. */
    static void arrancar(CountDownLatch salida, CountDownLatch llegada) throws InterruptedException {
        System.out.println("¡Disparo!");
        // TODO (2 líneas): abre salida (countDown) y espera a que se abra llegada (await)
    }
}
