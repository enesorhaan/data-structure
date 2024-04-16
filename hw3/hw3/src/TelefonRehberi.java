import java.util.Arrays;
class Kisi {
    String isim;
    String telefon;

    public Kisi(String isim, String telefon) {
        this.isim = isim;
        this.telefon = telefon;
    }
}

public class TelefonRehberi {
    private static final int MAX_KISI_SAYISI = 20;
    private Kisi[] rehber;

    public TelefonRehberi() {
        rehber = new Kisi[MAX_KISI_SAYISI];
    }

    public void ekle(String isim, String telefon) {
        if (kayitSayisi() >= MAX_KISI_SAYISI) {
            System.out.println("Rehber dolu, yeni kayıt eklenemiyor.");
            return;
        }

        int hashIndex = hash(isim.charAt(0));
        if (rehber[hashIndex] != null && rehber[hashIndex].isim.equals(isim)) {
            System.out.println("Bu isim zaten rehberde var.");
            return;
        }

        rehber[hashIndex] = new Kisi(isim, telefon);
        System.out.println("Yeni kayıt eklendi: " + isim + ", " + telefon);
    }

    public void ara(String isim) {
        int hashIndex = hash(isim.charAt(0));
        if (rehber[hashIndex] == null || !rehber[hashIndex].isim.equals(isim)) {
            System.out.println("Kişi bulunamadı: " + isim);
            return;
        }

        System.out.println(isim + " kişisinin telefon numarası: " + rehber[hashIndex].telefon);
    }

    public void sil(String isim) {
        int hashIndex = hash(isim.charAt(0));
        if (rehber[hashIndex] == null || !rehber[hashIndex].isim.equals(isim)) {
            System.out.println(isim + " kişisi bulunamadığı için silinemedi!");
            return;
        }

        rehber[hashIndex] = null;
        System.out.println(isim + " rehberden silindi.");
    }

    private int hash(char ch) {
        return (int) ch % MAX_KISI_SAYISI;
    }

    private int kayitSayisi() {
        return (int) Arrays.stream(rehber).filter(kayit -> kayit != null).count();
    }

    public static void main(String[] args) {
        TelefonRehberi rehber = new TelefonRehberi();

        rehber.ekle("Ayşe", "5554443322");
        rehber.ekle("Ahmet", "5551234567");
        rehber.ekle("Mehmet", "5559876543");

        rehber.ara("Ahmet");
        rehber.ara("Ali");

        rehber.sil("Mehmet");
        rehber.ara("Mehmet");

        rehber.sil("Enes");
    }
}