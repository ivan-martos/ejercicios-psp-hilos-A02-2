/**
 * Ejercicio 43. Hilos a mano con Thread y join.
 *
 * Sin ExecutorService: se crean los hilos con new Thread, se arrancan con start() y se espera a
 * que terminen con join(). Cada hilo suma su trozo del array y guarda el resultado en su propia
 * posición de un array de sumas parciales (así no hay carrera). Lo que hay que completar está en
 * sumarConHilos().
 */
public class Ej43HilosManuales {

    public static void main(String[] args) throws InterruptedException {
        int[] datos = new int[10_000_000];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = i % 100;
        }
        long esperado = 0;
        for (int dato : datos) {
            esperado += dato;
        }
        System.out.println("Suma con hilos: " + sumarConHilos(datos, 8));
        System.out.println("Esperado:       " + esperado);
    }

    /** Divide el array en hilos trozos iguales, suma cada uno en un hilo y devuelve el total. */
    static long sumarConHilos(int[] datos, int hilos) throws InterruptedException {
        long total = 0;
        // TODO (15 líneas): crea long[] parciales = new long[hilos] y Thread[] threads. En un
        //     bucle, para cada h: calcula el trozo (de h * tamano a (h + 1) * tamano, con
        //     tamano = datos.length / hilos), crea un Thread cuya lambda sume ese trozo en
        //     parciales[h] (usa una copia final del índice) y arráncalo con start(). Después, en
        //     otro bucle, haz join() a cada hilo. Por último suma los parciales en total

        return total;
    }
}
