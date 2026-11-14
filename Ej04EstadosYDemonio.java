/**
 * Ejercicio 4. Estados de un hilo e hilos demonio.
 *
 * Un hilo demonio escribe un latido cada 300 ms mientras el hilo principal consulta el estado de
 * otro hilo que duerme medio segundo. Cuando termina main, termina el programa.
 */
public class Ej04EstadosYDemonio {

    public static void main(String[] args) throws InterruptedException {
        Thread siesta = new Thread(() -> dormir(500));
        Thread latido = crearLatido();

        System.out.println("1. siesta antes de start(): " + siesta.getState());
        siesta.start();
        latido.start();
        Thread.sleep(100);
        System.out.println("2. siesta mientras duerme: " + siesta.getState());
        siesta.join();
        System.out.println("3. siesta después de join(): " + siesta.getState());
        System.out.println("4. latido: " + latido.getState() + ", demonio: " + latido.isDaemon());
        Thread.sleep(450);
        System.out.println("main: termino");
    }

    /** Crea, sin iniciarlo, un hilo demonio cuya tarea es latir(). */
    static Thread crearLatido() {
        // TODO (3 líneas): crea un Thread cuya tarea sea latir(), haz que sea un hilo demonio y
        //     devuélvelo
        return null;  // provisional, para que compile: bórralo
    }

    /** Escribe «latido» cada 300 ms, para siempre. Ya está hecho. */
    static void latir() {
        while (true) {
            System.out.println("   latido");
            dormir(300);
        }
    }

    static void dormir(long milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            return;
        }
    }
}
