import java.util.Scanner;

public class Ejercicio03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Calcular número de Fibonacci");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese un número n (0 a 30): ");
                int n = scanner.nextInt();

                if (n < 0 || n > 30) {
                    System.out.println("Error: n debe estar entre 0 y 30.");
                } else {
                    int[] memo = new int[n + 1];
                    for (int i = 0; i <= n; i++) {
                        memo[i] = -1; // inicializamos memoria
                    }

                    int resultado = fibonacci(n, memo);
                    System.out.println("Resultado: " + resultado);
                }
            }

        } while (opcion != 0);

        scanner.close();
        System.out.println("Programa finalizado.");
    }

    // Función recursiva con memoización
    public static int fibonacci(int n, int[] memo) {

        // Casos base
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Si ya fue calculado, se devuelve
        if (memo[n] != -1) {
            return memo[n];
        }

        // Se calcula y se guarda
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }
}
