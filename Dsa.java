import java.util.*;

public class Dsa {
    Node head;
    int size;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        Node currNode = head;

        while (currNode.next != null) {
            currNode = currNode.next;

        }
        currNode.next = newNode;
        size++;
    }

    public void deleteGreater() {
        while (head != null && head.data > 25) {
            head = head.next;
            size--;
        }
        Node currNode = head;

        while (currNode != null && currNode.next != null) {
            if (currNode.next.data > 25) {
                currNode.next = currNode.next.next;
                size--;
            } else {
                currNode = currNode.next;
            }
        }
    }

    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Dsa list = new Dsa();

        System.out.println("Enter the number between 1 to 50");
        System.out.println("Enter 52 to stop:");

        while (true) {
            int num = sc.nextInt();
            if (num == 52) {
                break;
            }
            if (num < 1 || num > 50) {
                System.out.println("invalid input Enter a number between 1 to 50");
                continue;
            }
            list.addLast(num);
        }
        System.out.println("Original Linked List:");
        list.printList();
        list.deleteGreater();
        System.out.println("Linked List after deletion:");
        list.printList();
        sc.close();
    }
}