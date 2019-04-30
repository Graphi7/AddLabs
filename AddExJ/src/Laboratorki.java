import java.time.*;
import java.util.*;


public class Laboratorki {

    public static void main(String[] args) {
        Ex5();
        Ex9();
        Ex14();
        Ex17();
        Ex19();
    }

    public static int[] ArrayLeng() {
        int N = 0;
        System.out.println();
        System.out.println("Введіть довжину масиву: ");
        Scanner inn = new Scanner(System.in);
        N = inn.nextInt();

        int[] arr = new int[N];

        System.out.println("Введіть елементи: ");
        Scanner ine = new Scanner(System.in);
        for (int i = 0; i < N; i++) {

            arr[i] = ine.nextInt();
        }

        return arr;
    }

    public static void Ex5() {
        int k = 0;
        int pos = 0;
        int [] Ar= new  int []{5,10,40,80,6,92,25,84,15,77,3,9,18,36,72,43,23,87,32,93};
        int kr = 0;
        int posk = 0;
        for (int i = 1; i < Ar.length; i++){
            if ((Ar[i] % Ar[i-1]) == 0) {
                k++;
                pos = i;
            }else{
                if (k >= kr) {
                    kr = k;
                    posk = pos - k;
                    k = 0;
                    pos = 0;
                } else {
                    k = 0;
                    pos = 0;
                }
            }
        }

        if ((k > 1)&&(kr<=0)){
            kr = k;
            posk = 0;
        }

        System.out.println("Кількість чисел в послідовності: " + kr + "\n" + "Перший елемент послідовності: " + posk);
        for(int i = posk; i < (posk+kr+1); i++){
            System.out.print(Ar[i] + " ");
        }
            }

    public static void Ex9() {
        int n = 0;
        int k = 0;
        System.out.println();
        System.out.println("Введіть довжину масиву: ");
        Scanner inn = new Scanner(System.in);
        n = inn.nextInt();

        System.out.println("Введіть кількість зміщень: ");
        Scanner ink = new Scanner(System.in);
        k = ink.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        int lastElement = 0;
        while (k > 0) {
            for (int i = 0; i < arr.length; i++) {
                lastElement = arr[arr.length - 1];
                arr[arr.length - 1] = arr[i];
                arr[i] = lastElement;
            }
            k--;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void Ex14() {
        int arr[] = ArrayLeng();
        ArrayList<Integer> minI = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < minI.size(); j++) {
                if (arr[i] > arr[minI.get(j)]) {
                    arr[minI.get(j)] = arr[i];
                    minI.remove(j);
                    j--;
                }
            }
            minI.add(i);
            if (i == arr.length - 1) {
                for (int j = 0; j < minI.size(); j++) {
                    arr[minI.get(j)] = 0;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void Ex17() {
        int arr[] = ArrayLeng();
        Arrays.sort(arr);
        int n = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != n)
                break;
            n++;
        }
        System.out.println("Мінімальне N: " + n);
    }

    public static void Ex19() {
        int lucknum = 0;
        for (int i = 0; i < 1000000; i++) {
            if (i / 100000 + (i / 10000) % 10 + (i / 1000) % 10 == (i / 100) % 10 + (i / 10) % 10 + i % 10) {
                lucknum++;
            }
        }
        System.out.println("Кількість щасливих білетів: " + lucknum);
    }
}