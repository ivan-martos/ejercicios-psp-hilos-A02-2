import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Ejercicio 27. Cerrojo sobre una colección no segura.
 *
 * Una biblioteca guarda las copias de cada libro en un HashMap, que NO es seguro para hilos.
 * Seis lectores piden prestado un libro y, si lo consiguen, lo devuelven, 20.000 veces cada uno.
 * Al final, cada libro tiene que tener las copias del principio (2). Lo que hay que completar está
 * en Biblioteca.
 */
public class Ej27CerrojoBiblioteca {

    static final String[] LIBROS = {"Quijote", "Celestina", "Lazarillo"};

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        for (String libro : LIBROS) {
            biblioteca.devolver(libro);
            biblioteca.devolver(libro);   // 2 copias de cada libro
        }
        AtomicInteger prestamos = new AtomicInteger(0);
        AtomicInteger rechazados = new AtomicInteger(0);

        try (ExecutorService lectores = Executors.newFixedThreadPool(6)) {
            for (int i = 0; i < 6; i++) {
                lectores.submit(() -> {
                    for (int j = 0; j < 20_000; j++) {
                        String libro = LIBROS[j % LIBROS.length];
                        if (biblioteca.prestar(libro)) {
                            prestamos.incrementAndGet();
                            biblioteca.devolver(libro);
                        } else {
                            rechazados.incrementAndGet();
                        }
                    }
                });
            }
        }
        System.out.println("Préstamos: " + prestamos.get() + "   Rechazados: " + rechazados.get());
        for (String libro : LIBROS) {
            System.out.println(libro + ": " + biblioteca.getCopias(libro) + " copias (tendrían que ser 2)");
        }
    }

    static class Biblioteca {

        private final ReentrantLock cerrojo = new ReentrantLock();
        private final Map<String, Integer> copias = new HashMap<>();

        /** Presta una copia si queda alguna. Devuelve true si se ha prestado. */
        boolean prestar(String titulo) {
            // TODO (10 líneas): con el cerrojo cogido, si copias.getOrDefault(titulo, 0) es 0 o
            //     menos devuelve false; si no, pon en el mapa una copia menos y devuelve true
            return false;  // provisional, para que compile: bórralo
        }

        /** Devuelve una copia al mapa (si el libro no estaba, empieza con 1). */
        void devolver(String titulo) {
            // TODO (6 líneas): con el cerrojo cogido, suma 1 a las copias de titulo con
            //     copias.merge(titulo, 1, Integer::sum)
        }

        /** Devuelve las copias que quedan. Ya está hecho: es el modelo. */
        int getCopias(String titulo) {
            cerrojo.lock();
            try {
                return copias.getOrDefault(titulo, 0);
            } finally {
                cerrojo.unlock();
            }
        }
    }
}
