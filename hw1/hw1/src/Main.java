import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MyStack<T> {
    private Node<T> top;

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}

public class Main {
    // Verilen bir metin dizisi palindrom mu kontrol eder
    private static boolean isPalindrome(String text) {
        // Büyük/küçük harf farkını önemsememek için metni küçük harfe dönüştürüyoruz ve gereksiz karakterleri kaldırıyoruz
        text = text.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Karakterleri stack'e iteratif olarak ekliyoruz
        MyStack<Character> stack = new MyStack<>();
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        // Stack'ten karakterleri alarak orijinal metinle karşılaştırıyoruz
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            System.out.println("FindPalindromes:");
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Enes Orhan/Desktop/Master Lessons/DataStructures/hw1/odev.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (isPalindrome(line)) {
                    System.out.println("\"" + line + "\" bir palindromdur.");
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}