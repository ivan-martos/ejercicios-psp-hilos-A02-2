/**
 * Ejercicio 5. Prioridades.
 *
 * El doble de hilos que núcleos cuentan durante dos segundos, para que compitan por la CPU: la
 * mitad con la prioridad máxima y la otra mitad con la mínima. ¿Cuentan más los de prioridad
 * máxima?
 */
public class Ej05Prioridades {

    static final long DURACION = 2000;

    public static void main(String[] args) throws InterruptedException {
        int numHilos = Runtime.getRuntime().availableProcessors() * 2;
        long[] cuentas = new long[numHilos];
        Thread[] hilos = new Thread[numHilos];
        long fin = System.currentTimeMillis() + DURACION;

        for (int i = 0; i < numHilos; i++) {
            int prioridad;
            if (i % 2 == 0) {
                prioridad = Thread.MAX_PRIORITY;
            } else {
                prioridad = Thread.MIN_PRIORITY;
            }
            hilos[i] = crearContador(cuentas, i, fin, prioridad);
        }
        for (Thread hilo : hilos) {
            hilo.start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }

        long totalMaxima = 0;
        long totalMinima = 0;
        for (int i = 0; i < numHilos; i++) {
            if (i % 2 == 0) {
                totalMaxima += cuentas[i];
            } else {
                totalMinima += cuentas[i];
            }
        }
        System.out.println("Hilos: " + numHilos);
        System.out.println("Prioridad máxima (10): " + totalMaxima);
        System.out.println("Prioridad mínima (1):  " + totalMinima);
    }

    /**
     * Crea, sin iniciarlo, un hilo con la prioridad indicada que cuenta hasta el instante fin y
     * deja la cuenta en cuentas[indice].
     */
    static Thread crearContador(long[] cuentas, int indice, long fin, int prioridad) {
        // TODO (9 líneas): crea un Thread cuya tarea sume 1 a una variable local cuenta mientras
        //     System.currentTimeMillis() sea menor que fin y, al terminar, guarde la cuenta en
        //     cuentas[indice]. Ponle la prioridad y devuélvelo

        return null;

    }

}
