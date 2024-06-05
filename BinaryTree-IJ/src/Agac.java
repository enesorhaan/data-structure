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

    int enBuyukDegeriBul(Node dugum) {
        int enBuyuk = dugum.veri;
        while (dugum.sag != null) {
            enBuyuk = dugum.sag.veri;
            dugum = dugum.sag;
        }
        return enBuyuk;
    }

    int farkiBul() {
        int min = enKucukDegeriBul(kok);
        int max = enBuyukDegeriBul(kok);

        return max - min;
    }

    boolean degeriAra(Node dugum, int veri) {
        if (dugum == null) {
            return false;
        }
        if (dugum.veri == veri) {
            return true;
        }
        if (veri < dugum.veri) {
            return degeriAra(dugum.sol, veri);
        }
        return degeriAra(dugum.sag, veri);
    }

    int maxDepth(Node dugum) {
        if (dugum == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(dugum.sol);
            int rightDepth = maxDepth(dugum.sag);

            if (leftDepth > rightDepth) {
                return (leftDepth + 1);
            } else {
                return (rightDepth + 1);
            }
        }
    }

    boolean dengeliMi(Node dugum) {
        return yukseklikKontrolu(dugum) != -1;
    }

    int yukseklikKontrolu(Node dugum) {
        if (dugum == null)
            return 0;

        int leftHeight = yukseklikKontrolu(dugum.sol);

        if (leftHeight == -1)
            return -1;

        int rightHeight = yukseklikKontrolu(dugum.sag);

        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

class Node {
    int veri;
    Node sol;
    Node sag;

    public Node(int veri) {
        this.veri = veri;
        sol = null;
        sag = null;
    }
}
