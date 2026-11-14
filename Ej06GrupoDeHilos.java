import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ejercicio 6. Un grupo de hilos.
 *
 * Una tienda online tiene ocho pedidos por preparar y tres empleados. Cada pedido tarda medio
 * segundo. Los empleados son los hilos de un grupo de EMPLEADOS hilos.
 */
public class Ej06GrupoDeHilos {

    static final int EMPLEADOS = 3;

    public static void main(String[] args) {
        String[] pedidos = {"P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8"};

        long inicio = System.currentTimeMillis();
        prepararTodos(pedidos);
        System.out.println("Todos preparados en " + (System.currentTimeMillis() - inicio) + " ms");
    }

    /** Entrega cada pedido a un grupo de EMPLEADOS hilos y espera a que estén todos preparados. */
    static void prepararTodos(String[] pedidos) {
        // TODO (5 líneas): crea con try-with-resources un grupo de EMPLEADOS hilos y entrégale una
        //     tarea preparar(pedido) por cada pedido
    }

    /** Simula la preparación de un pedido: tarda medio segundo. Ya está hecho. */
    static void preparar(String pedido) {
        System.out.println(Thread.currentThread().getName() + " prepara " + pedido);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            return;
        }
    }
}
