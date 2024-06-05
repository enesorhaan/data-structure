public class Main {
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
        System.out.println("En kucuk deger: " + agac.enKucukDegeriBul(agac.kok));
        System.out.println("En buyuk deger: " + agac.enBuyukDegeriBul(agac.kok));

        System.out.println("Max Min Farki: " + agac.farkiBul());

        System.out.println("Agac Yuksekligi: " + agac.maxDepth(agac.kok));

        System.out.println("Agac Dengeli Mi?: " + (agac.dengeliMi(agac.kok) ? "Evet" : "Hayir"));
    }
}
