/**
 * Ejercicio 1. Tu primer hilo con una lambda.
 *
 * El hilo principal lanza un hilo que saluda tres veces y, mientras tanto, saluda él también.
 */
public class Ej01PrimerHilo {

    public static void main(String[] args) throws InterruptedException {
        Thread hilo = lanzar();
        saludar();
        hilo.join();                      // espera a que termine el otro hilo
        System.out.println("main: fin");
    }

    /** Crea un hilo cuya tarea es llamar a saludar(), lo inicia y lo devuelve. */
    static Thread lanzar() {
        // TODO (3 líneas): crea un Thread cuya tarea sea una lambda que llame a saludar(),
        //     inícialo y devuélvelo
        Thread hilo = new Thread(()-> saludar());
        hilo.start();
        return hilo;
    }

    /** Escribe tres saludos con el nombre del hilo que lo ejecuta. Ya está hecho. */
    static void saludar() {
        String hilo = Thread.currentThread().getName();
        for (int i = 1; i <= 3; i++) {
            System.out.println(hilo + ": hola " + i);
        }
    }
}
