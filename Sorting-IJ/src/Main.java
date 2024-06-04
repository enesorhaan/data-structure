public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("-------------------------------");
        System.out.println("Arama Algoritmaları");
        System.out.println("-------------------------------");

        int[] dizi = {16, 78, 45, 34, 66, 95};

        int aranan = 66;

        int sonuc = ara(dizi, aranan);

        if (sonuc != -1) {
            System.out.println(aranan + " bulundu, dizinin indeksi: " + sonuc);
        } else {
            System.out.println(aranan + " bulunamadı");
        }

        int[] dizi2 = {12, 34, 45, 56, 78, 90};

        int aranan2 = 90;

        int sonuc2 = ikiliAra(dizi2, aranan2);

        if (sonuc2 != -1) {
            System.out.println(aranan2 + " bulundu, dizinin indeksi: " + sonuc2);
        } else {
            System.out.println(aranan2 + " bulunamadı");
        }

        System.out.println("-------------------------------");
        System.out.println("Sıralama Algoritmaları");
        System.out.println("-------------------------------");

        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Dizinin sıralanmadan önceki hali:");
        printArray(arr);
        bubbleSort(arr);
        System.out.println("Dizinin sıralanmış hali:");
        printArray(arr);

        int[] arr2 = {64, 25, 12, 22, 11};

        System.out.println("Dizinin sıralanmadan önceki hali:");
        printArray(arr2);
        selectionSort(arr2);
        System.out.println("Dizinin sıralanmış hali:");
        printArray(arr2);

        int[] arr3 = {64, 25, 12, 22, 11};

        System.out.println("Dizinin sıralanmadan önceki hali:");
        printArray(arr3);
        insertionSort(arr3);
        System.out.println("Dizinin sıralanmış hali:");
        printArray(arr2);

    }

    public static int ara(int[] dizi, int aranan) {
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] == aranan) {
                return i;
            }
        }
        return -1;
    }

    public static int ikiliAra(int[] dizi, int aranan) {
        int bas = 0;
        int son = dizi.length - 1;

        while (bas <= son) {
            int orta = (bas + son) / 2;
            if (dizi[orta] == aranan) {
                return orta;
            } else if (dizi[orta] < aranan) {
                bas = orta + 1;
            } else {
                son = orta - 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int flag;
        for (int i = 0; i < n - 1; i++) {
            flag = 0;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0)
                break;
        }
    }

//    void bubbleSort(int arr[]) {
//        int n = arr.length;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    // swap arr[j] and arr[j+1]
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

//    void selectionSort(int arr[]) {
//        int n = arr.length;
//
//        for (int i = 0; i < n - 1; i++) {
//            // Find the minimum element in unsorted array
//            int minIdx = i;
//            for (int j = i + 1; j < n; j++)
//                if (arr[j] < arr[minIdx])
//                    minIdx = j;
//
//            int temp = arr[minIdx];
//            arr[minIdx] = arr[i];
//            arr[i] = temp;
//        }
//    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

//    void insertionSort(int arr[]) {
//        int n = arr.length;
//        for (int i = 1; i < n; ++i) {
//            int key = arr[i];
//            int j = i - 1;
//
//            /* Move elements of arr[0..i-1], that are
//               greater than key, to one position ahead
//               of their current position */
//            while (j >= 0 && arr[j] > key) {
//                arr[j + 1] = arr[j];
//                j = j - 1;
//            }
//            arr[j + 1] = key;
//        }
//    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
