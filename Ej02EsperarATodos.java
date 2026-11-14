import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 2. Esperar a varios hilos con join.
 *
 * Cinco copias de seguridad simuladas, de un segundo cada una. Con un hilo por carpeta, las cinco
 * tienen que tardar un segundo en total, y el hilo principal tiene que esperar a que terminen
 * todas antes de decir cuánto se ha tardado.
 */
public class Ej02EsperarATodos {

    public static void main(String[] args) throws InterruptedException {
        String[] carpetas = {"fotos", "documentos", "musica", "proyectos", "correo"};

        long inicio = System.currentTimeMillis();
        copiarTodas(carpetas);
        System.out.println("Todas copiadas en " + (System.currentTimeMillis() - inicio) + " ms");
    }

    /** Copia todas las carpetas a la vez, un hilo por carpeta, y espera a que terminen todas. */
    static void copiarTodas(String[] carpetas) throws InterruptedException {
        List<Thread> hilos = new ArrayList<>();
        // TODO (8 líneas): lanza un hilo por carpeta, con la tarea copiar(carpeta), y guárdalo en
        //     la lista hilos. Cuando estén todos lanzados, espera a que terminen todos
       for(String carpeta: carpetas){
           Thread hilo = new Thread(()-> copiar(carpeta));
           hilos.add(hilo);
           hilo.start();
       }
       //esperar a que terminen todos  los hilos
        for (Thread hilo: hilos){
            hilo.join();
        }
    }

    /** Simula la copia de una carpeta: tarda un segundo. Ya está hecho. */
    static void copiar(String carpeta) {
        String hilo = Thread.currentThread().getName();
        System.out.println(hilo + " copia " + carpeta);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println(hilo + " termina " + carpeta);
    }
}
