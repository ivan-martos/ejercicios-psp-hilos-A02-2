import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejercicio 14. Variable atómica y mapa concurrente.
 *
 * Cinco mesas electorales cuentan votos a la vez. Todas escriben en el mismo contador total y en
 * el mismo mapa de votos por candidato. Al final no puede haberse perdido ningún voto. Lo que hay
 * que completar está en escrutar().
 */
public class Ej14AtomicaYMapaVotos {

    static final String[] CANDIDATOS = {"Ana", "Luis", "Marta", "Pedro"};
    static final int VOTOS_POR_MESA = 25_000;

    public static void main(String[] args) {
        AtomicInteger total = new AtomicInteger(0);
        Map<String, Integer> porCandidato = new ConcurrentHashMap<>();

        try (ExecutorService mesas = Executors.newFixedThreadPool(5)) {
            for (int i = 0; i < 5; i++) {
                mesas.submit(() -> escrutar(total, porCandidato));
            }
        }
        System.out.println("Esperado: 125000 votos, 31250 para cada candidato");
        System.out.println("Total:      " + total.get());
        System.out.println("Candidatos: " + new TreeMap<>(porCandidato));   // ordenado por nombre
    }

    /**
     * Escruta los votos de una mesa: el voto j es para CANDIDATOS[j % 4]. Cada voto suma 1 al
     * total y 1 a su candidato.
     */
    static void escrutar(AtomicInteger total, Map<String, Integer> porCandidato) {
        // TODO (5 líneas): recorre los VOTOS_POR_MESA votos (el j es para el candidato
        //     CANDIDATOS[j % CANDIDATOS.length]) y, por cada uno, suma 1 a total y 1 a su
        //     candidato con un solo método del mapa
    }
}
