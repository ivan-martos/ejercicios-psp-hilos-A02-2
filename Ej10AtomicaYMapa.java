import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejercicio 10. Variables atómicas y ConcurrentHashMap.
 *
 * Una web tiene cuatro servidores, y cada uno procesa 30.000 visitas. Cuatro hilos, uno por
 * servidor, cuentan a la vez el total de visitas, en una variable atómica, y las visitas de cada
 * página, en un ConcurrentHashMap.
 */
public class Ej10AtomicaYMapa {

    static final String[] PAGINAS = {"/inicio", "/tienda", "/carrito"};
    static final int VISITAS_POR_SERVIDOR = 30_000;

    public static void main(String[] args) {
        AtomicInteger total = new AtomicInteger(0);
        Map<String, Integer> porPagina = new ConcurrentHashMap<>();

        try (ExecutorService servidores = Executors.newFixedThreadPool(4)) {
            for (int i = 0; i < 4; i++) {
                servidores.submit(() -> procesar(total, porPagina));
            }
        }
        System.out.println("Esperado: 120000 visitas, 40000 en cada página");
        System.out.println("Total:    " + total.get());
        System.out.println("Páginas:  " + new TreeMap<>(porPagina));   // ordenado por página
    }

    /**
     * Procesa las visitas de un servidor: la visita j es a la página PAGINAS[j % 3]. Cada visita
     * suma 1 al total y 1 a su página.
     */
    static void procesar(AtomicInteger total, Map<String, Integer> porPagina) {
        // TODO (5 líneas): recorre las VISITAS_POR_SERVIDOR visitas (la j es a la página
        //     PAGINAS[j % PAGINAS.length]) y, por cada una, suma 1 a total y 1 a su página con
        //     un solo método del mapa
    }
}
