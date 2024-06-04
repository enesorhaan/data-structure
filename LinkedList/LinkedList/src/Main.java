import org.w3c.dom.Node;

public class Main {
    public static void main(String[] args) {
        BListe bl = new BListe();
        bl.initialize(23);
        bl.addElementLast(6);
        bl.addElementFront(563);
        bl.printLinkedList();
        bl.deleteNode(23);
        bl.printLinkedList();
        bl.addElementLast(67);
        bl.addElementFront(87);
        bl.printLinkedList();
        System.out.println("Listedeki eleman sayısı..." + bl.elementCount());
    }

    public static class Node {
        int data;
        public Node next;
    }

    public static class BListe {
        Node head = null;

        public void initialize(int data) {
            head = new Node();
            head.data = data;
            head.next = null;
        }

        public void addElementLast(int data) {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = null;
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        public void printLinkedList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " => ");
                temp = temp.next;
            }
            System.out.println("Null");
        }

        public int elementCount() {
            Node temp = head;
            int count = 0;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }

        public void addElementFront(int data) {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            head = newNode;
        }

        public boolean deleteNode(int data) {
            boolean durum = false;
            Node current = head;
            Node tmp = null;
            if (current.data == data) {
                tmp = current.next;
                head = tmp;
            } else {
                while (current.next != null) {
                    if (current.next.data == data) {
                        tmp = current.next;
                        current.next = tmp.next;
                        durum = true;
                        break;
                    }
                    current = current.next;
                }
            }

            return durum;
        }



    }
}