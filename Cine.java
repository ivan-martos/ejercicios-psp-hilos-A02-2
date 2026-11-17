import java.util.concurrent.locks.ReentrantLock;

/**
 * Un cine con aforo limitado, seguro para hilos: el número de entradas vendidas solo se lee o se
 * cambia con el cerrojo cogido, así que no hay dos hilos a la vez dentro de vender(), libres()
 * o getVendidas().
 */
public class Cine {

    private final ReentrantLock cerrojo = new ReentrantLock();
    private final int aforo;
    private int vendidas = 0;

    public Cine(int aforo) {
        this.aforo = aforo;
    }

    /** Vende las entradas si caben en el aforo. Devuelve true si las ha podido vender. */
    public boolean vender(int cantidad) {
        // TODO (10 líneas): con el cerrojo cogido, si vendidas + cantidad supera el aforo
        //     devuelve false; si cabe, suma la cantidad a vendidas y devuelve true
        return false;  // provisional, para que compile: bórralo
    }

    /** Devuelve cuántas entradas quedan por vender. */
    public int libres() {
        // TODO (6 líneas): con el cerrojo cogido, devuelve el aforo menos las vendidas
        return 0;  // provisional, para que compile: bórralo
    }

    /** Devuelve las entradas vendidas. Ya está hecho: es el modelo para los otros dos métodos. */
    public int getVendidas() {
        cerrojo.lock();
        try {
            return vendidas;
        } finally {
            cerrojo.unlock();
        }
    }
}
