import java.util.concurrent.locks.ReentrantLock;

/**
 * Una cuenta bancaria segura para hilos: el saldo solo se lee o se cambia con el cerrojo cogido,
 * así que no hay dos hilos a la vez dentro de ingresar(), retirar() o getSaldo().
 */
public class CuentaBancaria {

    private final ReentrantLock cerrojo = new ReentrantLock();
    private int saldo = 0;

    /** Suma la cantidad al saldo. */
    public void ingresar(int cantidad) {
        // TODO (6 líneas): suma la cantidad al saldo con el cerrojo cogido, como en getSaldo()
        cerrojo.lock();
        try{
            saldo += cantidad;
        }finally {
            cerrojo.unlock();
        }
    }

    /** Resta la cantidad si hay saldo suficiente. Devuelve true si la ha podido retirar. */
    public boolean retirar(int cantidad) {
        // TODO (10 líneas): con el cerrojo cogido, si el saldo no llega devuelve false; si llega,
        //     resta la cantidad y devuelve true

        return true;
    }

    /** Devuelve el saldo. Ya está hecho: es el modelo para los otros dos métodos. */
    public int getSaldo() {
        cerrojo.lock();
        try {
            return saldo;
        } finally {
            cerrojo.unlock();
        }
    }
}
