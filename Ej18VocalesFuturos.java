import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Ejercicio 18. Futures en orden.
 *
 * Cuenta las vocales de cada texto en una tarea distinta, y devuelve los resultados en el mismo
 * orden que los textos, aunque las tareas terminen en otro orden. Lo que hay que completar está en
 * vocalesPorTexto().
 */
public class Ej18VocalesFuturos {

    static final String[] TEXTOS = {
        "Programación concurrente", "Hilos y tareas", "El semáforo y el cerrojo",
        "Paralelismo en Java", "Sincronización", "Futuros y promesas"
    };

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] resultados = vocalesPorTexto(TEXTOS);
        for (int i = 0; i < TEXTOS.length; i++) {
            System.out.println(resultados[i] + " vocales en \"" + TEXTOS[i] + "\""
                    + (resultados[i] == contarVocales(TEXTOS[i]) ? "" : "   <-- MAL"));
        }
    }

    static int contarVocales(String texto) {
        int cuenta = 0;
        for (char c : texto.toLowerCase().toCharArray()) {
            if ("aeiouáéíóú".indexOf(c) >= 0) {
                cuenta++;
            }
        }
        return cuenta;
    }

    /** Devuelve un array con las vocales de cada texto, en el mismo orden que los textos. */
    static int[] vocalesPorTexto(String[] textos) throws InterruptedException, ExecutionException {
        int[] resultados = new int[textos.length];
        // TODO (11 líneas): crea con try-with-resources un grupo de 3 hilos. Entrégale una tarea
        //     contarVocales(texto) por cada texto y guarda los Future en una lista (en orden).
        //     Después recorre la lista y guarda en resultados[i] lo que devuelve el Future i

        return resultados;
    }
}
