import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Ejercicio 45. Fork/Join.
 *
 * Suma un array grande dividiéndolo recursivamente: si el trozo es pequeño se suma directamente;
 * si es grande, se parte en dos, una mitad se lanza en otro hilo (fork) y la otra se calcula aquí,
 * y al final se juntan los resultados (join). Lo que hay que completar está en SumaTarea.
 */
public class Ej45ForkJoin {

    public static void main(String[] args) {
        long[] datos = new long[5_000_000];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = i + 1;
        }
        long resultado = ForkJoinPool.commonPool().invoke(new SumaTarea(datos, 0, datos.length));
        long n = datos.length;
        System.out.println("Suma:     " + resultado);
        System.out.println("Esperado: " + n * (n + 1) / 2);
    }

    static class SumaTarea extends RecursiveTask<Long> {

        private static final int UMBRAL = 100_000;
        private final long[] datos;
        private final int desde;
        private final int hasta;   // no incluido

        SumaTarea(long[] datos, int desde, int hasta) {
            this.datos = datos;
            this.desde = desde;
            this.hasta = hasta;
        }

        @Override
        protected Long compute() {
            // TODO (14 líneas): si hasta - desde <= UMBRAL, suma datos[desde..hasta) con un bucle
            //     y devuelve la suma. Si no: calcula la mitad (desde + (hasta - desde) / 2), crea
            //     izquierda = new SumaTarea(datos, desde, mitad) y derecha = new SumaTarea(datos,
            //     mitad, hasta); lanza izquierda.fork(), calcula derecha.compute() aquí y devuelve
            //     izquierda.join() + el resultado de la derecha
            return 0L;  // provisional, para que compile: bórralo
        }
    }
}
