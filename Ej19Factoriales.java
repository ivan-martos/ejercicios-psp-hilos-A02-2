import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Ejercicio 19. Futures que devuelven una lista.
 *
 * Calcula los factoriales de 1 a 20, cada uno en una tarea, y devuelve la lista con los
 * resultados en orden. Lo que hay que completar está en factoriales().
 */
public class Ej19Factoriales {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Long> resultados = factoriales(20);
        for (int n = 1; n <= resultados.size(); n++) {
            System.out.println(n + "! = " + resultados.get(n - 1));
        }
        System.out.println("Tiene que haber 20 resultados y el último es 2432902008176640000");
    }

    static long factorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    /** Devuelve la lista [1!, 2!, ..., hasta!] calculando cada factorial en una tarea. */
    static List<Long> factoriales(int hasta) throws InterruptedException, ExecutionException {
        List<Long> resultados = new ArrayList<>();
        // TODO (10 líneas): crea con try-with-resources un grupo de 4 hilos. Entrégale una tarea
        //     factorial(n) por cada n de 1 a hasta y guarda los Future en una lista. Después
        //     recorre los Future y añade a resultados lo que devuelve cada uno

        return resultados;
    }
}
