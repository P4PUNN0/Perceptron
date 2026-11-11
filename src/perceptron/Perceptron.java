import java.io.*;
import java.util.Random;

public class Perceptron {
    private double[] pesos;
    private double sesgo;
    private Random random;

    public Perceptron(int numPesos, double sesgoInicial, int semilla) {
        this.pesos = new double[numPesos];
        this.sesgo = sesgoInicial;
        this.random = new Random(semilla);
        for (int i = 0; i < numPesos; i++) {
            pesos[i] = random.nextDouble() * 2 - 1;
        }
    }

    public void setPesos(double[] nuevosPesos) {
        System.arraycopy(nuevosPesos, 0, pesos, 0, pesos.length);
    }

    public double[] getPesos() {
        return pesos;
    }

    public void printPesos() {
        System.out.print("Pesos: ");
        for (double peso : pesos) {
            System.out.printf("%.3f ", peso);
        }
        System.out.println();
    }

    public void setSesgo(double nuevoSesgo) {
        this.sesgo = nuevoSesgo;
    }

    public double getSesgo() {
        return sesgo;
    }

    public void leerPesos(double[] nuevosPesos) {
        if (nuevosPesos.length == pesos.length) {
            setPesos(nuevosPesos);
        } else {
            System.out.println("Error: Tamaño incorrecto de pesos.");
        }
    }

    public void guardarPesos(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (double peso : pesos) {
                bw.write(peso + "\n");
            }
            bw.write(sesgo + "\n");
            System.out.println("Pesos guardados en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
        }
    }

    public void leerArchivoPesos(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            for (int i = 0; i < pesos.length; i++) {
                pesos[i] = Double.parseDouble(br.readLine());
            }
            sesgo = Double.parseDouble(br.readLine());
            System.out.println("Pesos cargados desde " + nombreArchivo);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    private int funcionActivacion(double h) {
        return (h >= 0) ? 1 : 0;
    }

    public int inferencia(int[] entradas) {
        if (entradas.length != pesos.length) {
            throw new IllegalArgumentException("Número incorrecto de entradas.");
        }
        double suma = sesgo;
        for (int i = 0; i < entradas.length; i++) {
            suma += entradas[i] * pesos[i];
        }
        return funcionActivacion(suma);
    }

    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron(2, 0.5, 42);
        perceptron.printPesos();

        int[][] datosEntrada = {
            {0, 0}, {0, 1}, {1, 0}, {1, 1}
        };

        System.out.println("Pruebas:");
        for (int[] entrada : datosEntrada) {
            int salida = perceptron.inferencia(entrada);
            System.out.printf("Entrada: [%d, %d] -> Salida: %d%n", entrada[0], entrada[1], salida);
        }
    }
}
