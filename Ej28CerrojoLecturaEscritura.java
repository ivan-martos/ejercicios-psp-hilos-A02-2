import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Ejercicio 28. Cerrojo de lectura y escritura.
 *
 * Una caché guarda pares clave-valor. Muchos hilos pueden leer a la vez, pero cuando uno escribe
 * nadie más puede leer ni escribir. Cuatro hilos escriben 250 claves cada uno y cuatro leen sin
 * parar. Al final tiene que haber 1.000 claves. Lo que hay que completar está en Cache.
 */
public class Ej28CerrojoLecturaEscritura {

    public static void main(String[] args) {
        Cache cache = new Cache();

        try (ExecutorService hilos = Executors.newFixedThreadPool(8)) {
            for (int i = 0; i < 4; i++) {
                int escritor = i;
                hilos.submit(() -> {
                    for (int j = 0; j < 250; j++) {
                        int n = escritor * 250 + j;
                        cache.poner("k" + n, "v" + n);
                    }
                });
                hilos.submit(() -> {
                    for (int j = 0; j < 100_000; j++) {
                        cache.obtener("k" + (j % 1000));
                    }
                });
            }
        }
        System.out.println("Tamaño: " + cache.tamano() + " (tendría que ser 1000)");
        System.out.println("k999 = " + cache.obtener("k999") + " (tendría que ser v999)");
    }

    static class Cache {

        private final ReentrantReadWriteLock cerrojo = new ReentrantReadWriteLock();
        private final Map<String, String> datos = new HashMap<>();

        /** Guarda el valor. Solo un hilo a la vez puede escribir, y sin lectores. */
        void poner(String clave, String valor) {
            // TODO (6 líneas): coge el cerrojo de escritura (cerrojo.writeLock().lock()), mete
            //     el par en datos y suéltalo en un finally
        }

        /** Devuelve el valor, o null si no está. Varios hilos pueden leer a la vez. */
        String obtener(String clave) {
            // TODO (6 líneas): igual, pero con el cerrojo de lectura (cerrojo.readLock())
            return null;  // provisional, para que compile: bórralo
        }

        /** Devuelve cuántas claves hay. Ya está hecho: es el modelo. */
        int tamano() {
            cerrojo.readLock().lock();
            try {
                return datos.size();
            } finally {
                cerrojo.readLock().unlock();
            }
        }
    }
}
