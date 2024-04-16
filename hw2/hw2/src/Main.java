import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Visitor Class
class Visitor {
    private String name;

    public Visitor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Visitor Queue Class
class VisitorQueue {
    private Queue<Visitor> queue;

    public VisitorQueue() {
        queue = new LinkedList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void addVisitor(Visitor visitor) {
        queue.add(visitor);
    }

    public Visitor removeVisitor() {
        return queue.poll();
    }

    public void showStatus() {
        System.out.println("Queue Status:");
        for (Visitor visitor : queue) {
            System.out.println(visitor.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final int MAX_VISITOR = 3; // Max Visitor in Jet Coaster
        int round = 0;

        Scanner scanner = new Scanner(System.in);
        VisitorQueue queue = new VisitorQueue();

        while (true) {
            System.out.print("Enter the name of the visitor joining the Jet Coaster queue (Press 'q' to exit): ");
            String name = scanner.nextLine();

            if (name.equals("q")) {
                break;
            }

            Visitor visitor = new Visitor(name);
            queue.addVisitor(visitor);
        }

        while (!queue.isEmpty()) {
            System.out.println("\n********** " + (++round) + ". Round **********");
            System.out.println("Visitors riding the Jet Coaster:");
            for (int i = 0; i < MAX_VISITOR; i++) {
                Visitor visitor = queue.removeVisitor();
                if (visitor != null) {
                    System.out.println(visitor.getName());
                }
            }
            System.out.println();
            queue.showStatus();
        }

        System.out.println("Jet Coaster queue is empty. The program is terminating.");
        scanner.close();
    }
}
