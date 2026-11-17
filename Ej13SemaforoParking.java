import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejercicio 13. Semáforo.
 *
 * Un parking tiene 3 plazas y llegan 8 coches a la vez. En la primera parte, cada coche espera a
 * que haya una plaza libre. En la segunda, un parking de 2 plazas recibe 4 coches que no esperan:
 * si no hay plaza se van. Lo que hay que completar está en aparcar() e intentarAparcar().
 */
public class Ej13SemaforoParking {

    static final long INICIO = System.currentTimeMillis();

    static long segundos() {
        return (System.currentTimeMillis() - INICIO) / 1000;
    }

    public static void main(String[] args) {
        System.out.println("--- Parte 1: los coches esperan (3 plazas, 8 coches) ---");
        Semaphore plazas = new Semaphore(3);
        try (ExecutorService coches = Executors.newFixedThreadPool(8)) {
            for (int i = 1; i <= 8; i++) {
                int coche = i;
                coches.submit(() -> aparcar(coche, plazas));
            }
        }

        System.out.println("--- Parte 2: los coches no esperan (2 plazas, 4 coches) ---");
        Semaphore plazasPequeno = new Semaphore(2);
        AtomicInteger aparcados = new AtomicInteger(0);
        try (ExecutorService coches = Executors.newFixedThreadPool(4)) {
            for (int i = 1; i <= 4; i++) {
                int coche = i;
                coches.submit(() -> {
                    if (intentarAparcar(coche, plazasPequeno)) {
                        aparcados.incrementAndGet();
                    }
                });
            }
        }
        System.out.println("Han aparcado " + aparcados.get() + " coches (tendrían que ser 2)");
    }

    /** El coche espera a que haya una plaza libre, está aparcado un segundo y la deja libre. */
    static void aparcar(int coche, Semaphore plazas) {
        // TODO (11 líneas): espera a que haya una plaza libre; escribe
        //     segundos() + " s: el coche " + coche + " aparca";
        //     tarda un segundo (Thread.sleep) y deja libre la plaza aunque haya una excepción.
        //     Si interrumpen al hilo, termina
    }

    /**
     * El coche intenta aparcar sin esperar. Si no hay plaza libre devuelve false (y escribe
     * "no hay plaza para el coche N"). Si la hay, la ocupa un segundo, la deja libre y devuelve true.
     */
    static boolean intentarAparcar(int coche, Semaphore plazas) {
        // TODO (14 líneas): usa tryAcquire(), que no espera: si devuelve false, escribe el mensaje
        //     y devuelve false. Si devuelve true, escribe segundos() + " s: el coche " + coche
        //     + " aparca", tarda un segundo (Thread.sleep) y deja libre la plaza aunque haya una
        //     excepción. Si interrumpen al hilo, restaura la interrupción. Devuelve true
        return false;  // provisional, para que compile: bórralo
    }
}
