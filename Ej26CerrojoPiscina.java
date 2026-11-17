import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Ejercicio 26. Cerrojo con dos límites.
 *
 * Una piscina admite 100 personas. Cuatro puertas intentan dejar entrar gente 100.000 veces cada
 * una y otras cuatro intentan dejarla salir 100.000 veces. El número de personas dentro nunca
 * puede ser negativo ni superar el aforo, y al final tiene que ser entradas menos salidas. Lo que
 * hay que completar está en Piscina.
 */
public class Ej26CerrojoPiscina {

    public static void main(String[] args) {
        Piscina piscina = new Piscina(100);
        AtomicInteger entradas = new AtomicInteger(0);
        AtomicInteger salidas = new AtomicInteger(0);

        try (ExecutorService puertas = Executors.newFixedThreadPool(8)) {
            for (int i = 0; i < 4; i++) {
                puertas.submit(() -> {
                    for (int j = 0; j < 100_000; j++) {
                        if (piscina.entrar()) {
                            entradas.incrementAndGet();
                        }
                    }
                });
                puertas.submit(() -> {
                    for (int j = 0; j < 100_000; j++) {
                        if (piscina.salir()) {
                            salidas.incrementAndGet();
                        }
                    }
                });
            }
        }
        System.out.println("Entradas: " + entradas.get() + "   Salidas: " + salidas.get());
        System.out.println("Dentro:   " + piscina.getDentro()
                + " (tendría que ser " + (entradas.get() - salidas.get()) + ", entre 0 y 100)");
    }

    static class Piscina {

        private final ReentrantLock cerrojo = new ReentrantLock();
        private final int aforo;
        private int dentro = 0;

        Piscina(int aforo) {
            this.aforo = aforo;
        }

        /** Deja entrar a una persona si no se ha llegado al aforo. Devuelve true si ha entrado. */
        boolean entrar() {
            // TODO (10 líneas): con el cerrojo cogido, si dentro ya es igual al aforo devuelve
            //     false; si no, suma 1 a dentro y devuelve true
            return false;  // provisional, para que compile: bórralo
        }

        /** Deja salir a una persona si hay alguien dentro. Devuelve true si ha salido. */
        boolean salir() {
            // TODO (10 líneas): con el cerrojo cogido, si dentro es 0 devuelve false; si no,
            //     resta 1 a dentro y devuelve true
            return false;  // provisional, para que compile: bórralo
        }

        /** Devuelve cuántas personas hay dentro. Ya está hecho: es el modelo. */
        int getDentro() {
            cerrojo.lock();
            try {
                return dentro;
            } finally {
                cerrojo.unlock();
            }
        }
    }
}
