import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Ejercicio 30. Dos cerrojos sin interbloqueo.
 *
 * Dos cuentas con 1.000 euros cada una. Cuatro hilos transfieren 1 euro 50.000 veces: dos de A a B
 * y dos de B a A. Para mover dinero hay que coger el cerrojo de las DOS cuentas, y si cada hilo las
 * coge en un orden distinto se produce un interbloqueo (el programa se queda colgado). La solución
 * es coger siempre primero el cerrojo de la cuenta con menor id. Al final, la suma tiene que seguir
 * siendo 2.000. Lo que hay que completar está en transferir().
 */
public class Ej30CerrojoTransferencias {

    public static void main(String[] args) {
        Cuenta a = new Cuenta(1, 1000);
        Cuenta b = new Cuenta(2, 1000);

        try (ExecutorService hilos = Executors.newFixedThreadPool(4)) {
            for (int i = 0; i < 2; i++) {
                hilos.submit(() -> {
                    for (int j = 0; j < 50_000; j++) {
                        transferir(a, b, 1);
                    }
                });
                hilos.submit(() -> {
                    for (int j = 0; j < 50_000; j++) {
                        transferir(b, a, 1);
                    }
                });
            }
        }
        System.out.println("A: " + a.getSaldo() + "   B: " + b.getSaldo());
        System.out.println("Suma: " + (a.getSaldo() + b.getSaldo()) + " (tendría que ser 2000)");
    }

    static class Cuenta {

        final int id;
        final ReentrantLock cerrojo = new ReentrantLock();
        int saldo;

        Cuenta(int id, int saldo) {
            this.id = id;
            this.saldo = saldo;
        }

        int getSaldo() {
            cerrojo.lock();
            try {
                return saldo;
            } finally {
                cerrojo.unlock();
            }
        }
    }

    /** Pasa cantidad de origen a destino si origen tiene saldo. Devuelve true si lo ha hecho. */
    static boolean transferir(Cuenta origen, Cuenta destino, int cantidad) {
        // TODO (16 líneas): decide cuál de las dos cuentas tiene el id menor (primera) y cuál el
        //     mayor (segunda). Coge el cerrojo de primera y, dentro de un try/finally, el de
        //     segunda (otro try/finally). Con las dos cogidas: si origen.saldo < cantidad
        //     devuelve false; si no, resta a origen, suma a destino y devuelve true
        return false;  // provisional, para que compile: bórralo
    }
}
