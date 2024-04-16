import java.util.*;

public class Main {
    public static void main(String[] args) {
// Öncelik kuyruğu oluşturma
        // 7.4.5.6
        Node pq = newNode(4, 1);
        pq = push(pq, 5, 2);
        pq = push(pq, 6, 3);
        pq = push(pq, 7, 0);

        while (isEmpty(pq) == 0) {
            System.out.printf("%d ", peek(pq));
            pq = pop(pq);
        }

    }

    // Node
    static class Node {
        int data;
        // Düşük değerler yüksek önceliği gösterir
        int priority;
        Node next;
    }

    static Node node = new Node();

    // Yeni node oluşturulması
    static Node newNode(int d, int p) {
        Node temp = new Node();
        temp.data = d;
        temp.priority = p;
        temp.next = null;

        return temp;
    }

    // baştaki değeri döndür
    static int peek(Node head) {
        return (head).data;
    }

    //  En yüksek önceliğe sahip elemanı listeden kaldırır
    static Node pop(Node head) {
        Node temp = head;
        (head) = (head).next;
        return head;
    }

    // Önceliğe göre itme işlevi
    static Node push(Node head, int d, int p) {
        Node start = (head);

        // Yeni node oluşturma
        Node temp = newNode(d, p);

        // Özel Durum: Liste başlığının yeni düğüme göre daha az önceliği vardır. Head düğümünden önce yeni düğüm eklemek ve kafa head değiştirmek için.
        if ((head).priority > p) {
            // head ten önce yeni düğüm eklemek
            temp.next = head;
            (head) = temp;
        } else {
            // Listede gezme ve yeni düğüm ekleme konumu
            while (start.next != null &&
                    start.next.priority < p) {
                start = start.next;
            }

            // Ya listenin sonunda veya gereken konumda
            temp.next = start.next;
            start.next = temp;
        }
        return head;
    }

    // liste boş mu kontrol etme
    static int isEmpty(Node head) {
        return ((head) == null) ? 1 : 0;
    }
}


//public class Main {
//    public static void main(String[] args) {
//        Queue q = new Queue();
//        q.enqueue(10);
//        q.enqueue(20);
//        q.dequeue();
//        q.dequeue();
//        q.enqueue(30);
//        q.enqueue(40);
//        q.enqueue(50);
//        q.dequeue();
//        System.out.println("Queue Front : " + q.front.key);
//        System.out.println("Queue Rear : " + q.rear.key);
//}
//    static class QNode {
//        int key;
//        QNode next;
//
//        public QNode(int key) {
//            this.key = key;
//            this.next = null;
//        }
//    }
//    static class Queue {
//        QNode front, rear;
//        public Queue() {
//            this.front = this.rear = null;
//        }
//        void enqueue(int key) {
//            // Bağıl liste node oluşturma
//            QNode temp = new QNode(key);
//            // Kuyruk boş ise, yeni node hem front hem rear olacaktır.
//            if (this.rear == null) {
//                this.front = this.rear = temp;
//                return;
//            }
//            // Kuyruğun sonuna eleman eklenir ve rear değiştirilir.
//            this.rear.next = temp;
//            System.out.println(key + " added...");
//            this.rear = temp;
//        }
//        void dequeue() {
//            // Kuyruk boş ise, NULL döndür
//            if (this.front == null)
//                return;
//            // Bir önceki fron değeri sakla ve   bir düğüm öne git
//            QNode temp = this.front;
//            System.out.println(temp.key + " removed...");
//            this.front = this.front.next;
//
//            // front NULL olursa, rear da NULL olarak değiştirin
//            if (this.front == null)
//                this.rear = null;
//        }
//    }
//}