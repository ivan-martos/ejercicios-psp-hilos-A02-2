/**
 * Ejercicio 3. Interrumpir un hilo.
 *
 * Un hilo vigila la temperatura cada medio segundo, sin parar. Al cabo de 2,2 segundos, el hilo
 * principal le pide que termine y espera a que lo haga.
 */
public class Ej03Interrumpir {

    public static void main(String[] args) throws InterruptedException {
        Thread vigilante = new Thread(() -> vigilar());
        vigilante.start();

        Thread.sleep(2200);               // deja vigilar 2,2 segundos
        parar(vigilante);
        System.out.println("main: el vigilante ha terminado");
    }

    /** Pide al hilo que termine y espera a que lo haga. */
    static void parar(Thread hilo) throws InterruptedException {
        // TODO (2 líneas): pide al hilo que termine y espera a que lo haga
        hilo.interrupt();
        hilo.join();
    }

    /** Lee la temperatura cada medio segundo hasta que lo interrumpen. Ya está hecho. */
    static void vigilar() {
        int lecturas = 0;
        try {
            while (true) {
                Thread.sleep(500);
                lecturas++;
                System.out.println("Vigilante: lectura " + lecturas + ", 21 grados");
            }
        } catch (InterruptedException e) {
            System.out.println("Vigilante: me piden que pare después de " + lecturas + " lecturas");
        }
    }
}
