import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejercicio 8. Exclusión mutua con un cerrojo.
 *
 * Cuatro cajeros ingresan 1 euro 100.000 veces cada uno en la misma cuenta, y otros cuatro
 * intentan retirar 1 euro 100.000 veces cada uno. Al final, el saldo tiene que ser lo ingresado
 * menos lo retirado, y nunca negativo. Lo que hay que completar está en CuentaBancaria.
 */
public class Ej08Cerrojo {

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();
        AtomicInteger retirado = new AtomicInteger(0);

        try (ExecutorService cajeros = Executors.newFixedThreadPool(8)) {
            for (int i = 0; i < 4; i++) {
                cajeros.submit(() -> {
                    for (int j = 0; j < 100_000; j++) {
                        cuenta.ingresar(1);
                    }
                });
                cajeros.submit(() -> {
                    for (int j = 0; j < 100_000; j++) {
                        if (cuenta.retirar(1)) {
                            retirado.incrementAndGet();
                        }
                    }
                });
            }
        }
        System.out.println("Ingresado: " + 4 * 100_000);
        System.out.println("Retirado:  " + retirado.get());
        System.out.println("Saldo:     " + cuenta.getSaldo()
                + " (tendría que ser " + (4 * 100_000 - retirado.get()) + ")");
    }
}
