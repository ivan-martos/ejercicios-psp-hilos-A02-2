import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Ejercicio 32. wait / notifyAll.
 *
 * Un buzón guarda como mucho UNA carta. Un remitente deposita cinco cartas y un cartero las
 * recoge. Si el buzón está lleno, el remitente espera; si está vacío, el cartero espera. Las
 * cartas tienen que llegar todas y en orden. Lo que hay que completar está en Buzon.
 */
public class Ej32EsperaNotificacion {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Buzon buzon = new Buzon();

        try (ExecutorService hilos = Executors.newFixedThreadPool(2)) {
            hilos.submit(() -> {
                for (int i = 1; i <= 5; i++) {
                    buzon.depositar("carta " + i);
                }
                return null;
            });
            Future<List<String>> recibidas = hilos.submit(() -> {
                List<String> lista = new ArrayList<>();
                for (int i = 1; i <= 5; i++) {
                    lista.add(buzon.recoger());
                }
                return lista;
            });
            System.out.println("Recibidas: " + recibidas.get());
        }
        System.out.println("Tendría que salir: [carta 1, carta 2, carta 3, carta 4, carta 5]");
    }

    static class Buzon {

        private String carta = null;   // null = buzón vacío

        /** Deja una carta; si el buzón está lleno, espera a que lo vacíen. */
        synchronized void depositar(String nueva) throws InterruptedException {
            // TODO (6 líneas): mientras carta != null espera con wait() (¡un while!). Luego
            //     guarda la nueva carta y avisa a todos con notifyAll()
        }

        /** Recoge la carta; si el buzón está vacío, espera a que llegue una. */
        synchronized String recoger() throws InterruptedException {
            // TODO (7 líneas): mientras carta == null espera con wait(). Luego guarda la carta en
            //     una variable local, pon carta = null, avisa con notifyAll() y devuelve la local
            return null;  // provisional, para que compile: bórralo
        }
    }
}
