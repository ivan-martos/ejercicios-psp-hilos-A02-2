import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejercicio 12. Exclusión mutua con un cerrojo.
 *
 * Un cine tiene 50.000 plazas y ocho taquillas intentan vender 1 entrada 10.000 veces cada una
 * (80.000 intentos). Al final tienen que haberse vendido exactamente 50.000 entradas: ni una más
 * (sobreventa) ni una menos. Lo que hay que completar está en Cine.
 */
public class Ej12CerrojoCine {

    public static void main(String[] args) {
        Cine cine = new Cine(50_000);
        AtomicInteger vendidasSegunTaquillas = new AtomicInteger(0);

        try (ExecutorService taquillas = Executors.newFixedThreadPool(8)) {
            for (int i = 0; i < 8; i++) {
                taquillas.submit(() -> {
                    for (int j = 0; j < 10_000; j++) {
                        if (cine.vender(1)) {
                            vendidasSegunTaquillas.incrementAndGet();
                        }
                    }
                });
            }
        }
        System.out.println("Vendidas (taquillas): " + vendidasSegunTaquillas.get());
        System.out.println("Vendidas (cine):      " + cine.getVendidas() + " (tendría que ser 50000)");
        System.out.println("Libres:               " + cine.libres() + " (tendría que ser 0)");
    }
}
