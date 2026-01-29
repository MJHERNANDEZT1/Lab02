import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Generar paréntesis bien formados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese la cantidad de pares de paréntesis (1 a 8): ");
                int n = scanner.nextInt();

                if (n < 1 || n > 8) {
                    System.out.println("Error: n debe estar entre 1 y 8.");
                } else {
                    List<String> resultado = generarParentesis(n);
                    System.out.println("Combinaciones generadas:");
                    System.out.println(resultado);
                }
            }

        } while (opcion != 0);

        scanner.close();
        System.out.println("Programa finalizado.");
    }

    // Método principal que inicia el backtracking
    public static List<String> generarParentesis(int n) {
        List<String> resultado = new ArrayList<>();
        backtracking(resultado, "", 0, 0, n);
        return resultado;
    }

    // Backtracking eficiente
    private static void backtracking(List<String> resultado, String actual,
                                     int abiertos, int cerrados, int n) {

        // Caso base: longitud completa
        if (actual.length() == 2 * n) {
            resultado.add(actual);
            return;
        }

        // Agregar '(' si aún hay disponibles
        if (abiertos < n) {
            backtracking(resultado, actual + "(", abiertos + 1, cerrados, n);
        }

        // Agregar ')' solo si no rompe la validez
        if (cerrados < abiertos) {
            backtracking(resultado, actual + ")", abiertos, cerrados + 1, n);
        }
    }
}
