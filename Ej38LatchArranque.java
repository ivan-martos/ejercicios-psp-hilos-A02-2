import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Ejercicio 38. CountDownLatch con tiempo límite.
 *
 * Un servicio necesita que arranquen tres componentes (base de datos, caché y red) antes de
 * ofrecerse. Se espera como mucho un tiempo: si algún componente no llega, el arranque falla.
 * Lo que hay que completar está en arrancarComponente() y esperarComponentes().
 */
public class Ej38LatchArranque {

    public static void main(String[] args) {
        System.out.println("Arranque normal: " + arrancar(100, 200, 300));
        System.out.println("Arranque con la red lenta: " + arrancar(100, 200, 3000));
        System.out.println("Tendría que salir: true y false");
    }

    /** Arranca los tres componentes con esos tiempos y espera como mucho 1 segundo. */
    static boolean arrancar(int msBaseDatos, int msCache, int msRed) {
        CountDownLatch listos = new CountDownLatch(3);
        try (ExecutorService hilos = Executors.newFixedThreadPool(3)) {
            hilos.submit(() -> arrancarComponente("base de datos", msBaseDatos, listos));
            hilos.submit(() -> arrancarComponente("caché", msCache, listos));
            hilos.submit(() -> arrancarComponente("red", msRed, listos));
            return esperarComponentes(listos, 1);
        }
    }

    /** Tarda ms milisegundos, escribe "<nombre> listo" y avisa al latch, aunque haya excepción. */
    static void arrancarComponente(String nombre, int ms, CountDownLatch listos) {
        // TODO (10 líneas): tarda ms milisegundos (Thread.sleep) y escribe nombre + " listo".
        //     En un finally, baja listos en uno (countDown). Si interrumpen al hilo, restaura la
        //     interrupción
    }

    /** Espera a que lleguen los tres como mucho segundos segundos. Devuelve true si llegaron. */
    static boolean esperarComponentes(CountDownLatch listos, long segundos) {
        // TODO (6 líneas): devuelve listos.await(segundos, TimeUnit.SECONDS), que da true si el
        //     latch ha llegado a cero y false si se ha acabado el tiempo. Si interrumpen al hilo
        //     (InterruptedException), restaura la interrupción y devuelve false
        return false;  // provisional, para que compile: bórralo
    }
}
