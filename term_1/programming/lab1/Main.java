import static java.lang.Math.*;
import java.util.Arrays;
public class Main{
    public static void output(float[][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                System.out.printf("%10.3f ", array[i][j]);
            }
            System.out.printf("\n");
        }
    }
    
    public static void main(String[] args) {
        /*
         * Task 1
         * Создать одномерный массив c типа long.
         * Заполнить его нечётными числами от 5 до 17 включительно в порядке возрастания.
         */

        long[] c = new long[7];
        c[0] = 5;

        int count = 1;
        while (count < c.length) {
            c[count] = c[count-1] + 2;
            count++;        
        }
        

        System.out.println(Arrays.toString(c));

        /*
         * Task 2
         * Создать одномерный массив x типа float
         * Заполнить его 20-ю случайными числами в диапазоне от -8.0 до 11.0.
         */

        float[] x = new float[20];

        float min = -8.0f;
        float max = 11.0f;

        int count_2 = 0;
        do {
            x[count_2] = ( (float) random()* (max - min) + min);
            count_2++;

        } while (count_2 < x.length);


        System.out.println(Arrays.toString(x));

        /*
         * Task 3
         * Создать двумерный массив c размером 7x20
         * Вычислить его элементы  (где x = x[j]):
         */

        float[][] y = new float[7][20];

        for(int i = 0; i < 7; i++) {
            for (int j = 0; j < 20; j++) {

                if(c[i] == 9){
                    y[i][j] = (float) (pow((1 - asin((x[j] + 1.5)/19)), atan((x[j] + 1.5)/19)));
                    y[i][j] = (float)(y[i][j] * pow((2 * pow(((x[j] + 1)/ x[j]), 3) - 2), 2));
                }

                if(c[i] == 11 || c[i] == 13 || c[i] == 17){
                    y[i][j] = (float) (asin(cos(asin(exp(-(abs(x[j])))))));
                }

                else{
                    y[i][j] = (float) exp(pow(((PI + sin(x[j])) / atan((x[j] + 1.5)/19)), 3));
                    float power = (float) (atan(1/(exp(acos((PI/4) * ((x[j]+1.5)/19))))));
                    y[i][j] = (float) pow(y[i][j], power);
                }
            }
        }
        output(y);
    }
}