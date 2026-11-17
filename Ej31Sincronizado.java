import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ejercicio 31. synchronized.
 *
 * Cuatro hilos llaman 100.000 veces a incrementar() (suma 1) y otras 100.000 a sumar(2). Al
 * final el contador tiene que valer 4 * 100.000 * (1 + 2) = 1.200.000. Lo que hay que completar
 * está en ContadorSync.
 */
public class Ej31Sincronizado {

    public static void main(String[] args) {
        ContadorSync contador = new ContadorSync();

        try (ExecutorService hilos = Executors.newFixedThreadPool(4)) {
            for (int i = 0; i < 4; i++) {
                hilos.submit(() -> {
                    for (int j = 0; j < 100_000; j++) {
                        contador.incrementar();
                        contador.sumar(2);
                    }
                });
            }
        }
        System.out.println("Valor: " + contador.valor() + " (tendría que ser 1200000)");
    }

    static class ContadorSync {

        private int valor = 0;

        /** Suma 1 al valor. */
        void incrementar() {
            // TODO (3 líneas): haz el método synchronized (en la cabecera) y suma 1 a valor
        }

        /** Suma la cantidad al valor. */
        void sumar(int cantidad) {
            // TODO (5 líneas): esta vez, sin synchronized en la cabecera: usa un bloque
            //     synchronized (this) { ... } que contenga la suma
        }

        /** Devuelve el valor. Ya está hecho: es el modelo. */
        synchronized int valor() {
            return valor;
        }
    }
}
