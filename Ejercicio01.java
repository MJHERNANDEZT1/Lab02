import java.util.Scanner;

public class Ejercicio01 {

    // Definición del nodo
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // ===== MÉTODO DE ORDENAMIENTO =====
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left, right);
    }

    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // ===== IMPRIMIR LISTA =====
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // ===== MAIN DINÁMICO =====
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListNode head = null;
        ListNode tail = null;

        System.out.print("Ingrese la cantidad inicial de elementos: ");
        int cantidad = sc.nextInt();

        int contador = 0;

        while (contador < cantidad) {
            System.out.print("Ingrese el valor del nodo: ");
            int valor = sc.nextInt();

            ListNode nuevo = new ListNode(valor);

            if (head == null) {
                head = nuevo;
                tail = nuevo;
            } else {
                tail.next = nuevo;
                tail = nuevo;
            }

            contador++;

            if (contador < cantidad) {
                System.out.print("¿Desea agregar otro elemento? (s/n): ");
                char opcion = sc.next().toLowerCase().charAt(0);

                if (opcion != 's') {
                    break;
                }
            }
        }

        System.out.println("\nLista original:");
        printList(head);

        head = sortList(head);

        System.out.println("\nLista ordenada:");
        printList(head);

        sc.close();
    }
}
