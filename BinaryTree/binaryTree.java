public static void main(String[] args) {
        // TODO code application logic here
         Agac agac = new Agac();

        agac.ekle(50);
        agac.ekle(30);
        agac.ekle(70);
        agac.ekle(20);
        agac.ekle(40);
        agac.ekle(60);
        agac.ekle(90);
        System.out.println("Inorder traversal:");
        agac.inorder();

        System.out.println("\nPreorder traversal:");
        agac.preorder();

        System.out.println("\nPostorder traversal:");
        agac.postorder();
        System.out.println("");
        System.out.println(agac.degeriAra(agac.kok, 90));
        System.out.println(agac.degeriAra(agac.kok, 80));
        System.out.println(agac.enKucukDegeriBul(agac.kok));

    }
    public class Node {
    int veri;
    Node sol;
    Node sag;

    public Node(int veri) {
        this.veri = veri;
        sol = null;
        sag = null;
    }
}
public class Agac {
     Node kok;

    public Agac() {
        kok = null;
    }

    void ekle(int veri) {
        kok = ekleDugum(kok, veri);
    }

    Node ekleDugum(Node dugum, int veri) {
        if (dugum == null) {
            dugum = new Node(veri);
            return dugum;
        }

        if (veri < dugum.veri) {
            dugum.sol = ekleDugum(dugum.sol, veri);
        } else if (veri > dugum.veri) {
            dugum.sag = ekleDugum(dugum.sag, veri);
        }

        return dugum;
    }

    void inorder(Node dugum) {
        if (dugum != null) {
            inorder(dugum.sol);
            System.out.print(dugum.veri + " ");
            inorder(dugum.sag);
        }
    }

    void preorder(Node dugum) {
        if (dugum != null) {
            System.out.print(dugum.veri + " ");
            preorder(dugum.sol);
            preorder(dugum.sag);
        }
    }

    void postorder(Node dugum) {
        if (dugum != null) {
            postorder(dugum.sol);
            postorder(dugum.sag);
            System.out.print(dugum.veri + " ");
        }
     
}
    void inorder() {
        inorder(kok);
    }

    void preorder() {
        preorder(kok);
    }

    void postorder() {
        postorder(kok);
    }
        int enKucukDegeriBul(Node dugum) {
    int enKucuk = dugum.veri;
    while (dugum.sol != null) {
        enKucuk = dugum.sol.veri;
        dugum = dugum.sol;
    }
    return enKucuk;
}


