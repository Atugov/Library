package sample;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class ArrayExample {
    @Test
    public void arrayCreationExample() {
        int[] a = {1, 2, 3, 4};
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println(a[3]);
        int[] a1 = new int[20000];
        a1[0] = 15;
        a1[1] = 20;
    }
    @Test
    public void cycleExamle(){
        int a = 0;
        while (a < 20){
            a++;
            System.out.println("hello" + a);
        }
        for (int b = 0; b < 20; b++){
            System.out.println("bye" + " " + b);
        }
    }
    @Test
    public void arrayFillingExample() {
        int[] simpleArray = new int[1000];

       for (int i = 0; i < 1000; i ++) {
           Random r = new Random();
           int num = 500 + r.nextInt(1000 - 500);
//           if (num <500){
//               num = num + 500;
//           }
           simpleArray[i] = num;
       }
       for (int i = 0; i < 1000; i ++){
           System.out.println("array is " + (i + 1) + " " + simpleArray[i]);
       }

    }
}
