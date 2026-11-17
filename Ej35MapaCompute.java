import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejercicio 35. Operación condicional atómica con compute.
 *
 * Una tienda tiene 50.000 manzanas. Ocho cajas intentan vender 1 manzana 10.000 veces cada una
 * (80.000 intentos). Hay que vender exactamente 50.000, ni una más. Comprobar el stock y restarlo
 * tiene que ser una sola operación atómica del mapa. Lo que hay que completar está en retirar().
 */
public class Ej35MapaCompute {

    public static void main(String[] args) {
        Map<String, Integer> stock = new ConcurrentHashMap<>();
        stock.put("manzanas", 50_000);
        AtomicInteger vendidas = new AtomicInteger(0);

        try (ExecutorService cajas = Executors.newFixedThreadPool(8)) {
            for (int i = 0; i < 8; i++) {
                cajas.submit(() -> {
                    for (int j = 0; j < 10_000; j++) {
                        if (retirar(stock, "manzanas", 1)) {
                            vendidas.incrementAndGet();
                        }
                    }
                });
            }
        }
        System.out.println("Vendidas: " + vendidas.get() + " (tendrían que ser 50000)");
        System.out.println("Stock:    " + stock.get("manzanas") + " (tendría que ser 0)");
    }

    /** Resta la cantidad del producto si hay stock suficiente. Devuelve true si la ha restado. */
    static boolean retirar(Map<String, Integer> stock, String producto, int cantidad) {
        AtomicBoolean retirada = new AtomicBoolean(false);
        // TODO (8 líneas): llama a stock.compute(producto, (clave, actual) -> ...). Dentro: si
        //     actual es null o menor que cantidad, devuelve actual sin tocarlo; si no, pon
        //     retirada a true y devuelve actual - cantidad
        return retirada.get();
    }
}
