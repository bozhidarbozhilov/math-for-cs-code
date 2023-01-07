import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] result = pulverizer(259, 70);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * Returns the greatest common divisor calculated by Euclidean algorithm
     * Recursive method
     * @param a integer
     * @param b integer
     * @return gcd integer
     */
    public static int gcd(int a, int b){

        int rem;
        if(b == 0){
            return a;
        }else {
            rem = a % b;

            return gcd(b,rem);
        }

    }

    /**
     * from MIT 6.042 Math for CS Textbook
     * Returns the greatest common divisor computed only division by 2
     * and subtraction, which makes it run very efficiently on
     * hardware that uses binary representation of numbers
     * @param a integer
     * @param b integer
     * @return gcd integer
     */
    public static int binaryGCD(int a, int b){
        int x = a;
        int y = b;
        int e = 1;
        int counter = 0;

        while (x!=0 && y!=0){
            if (x%2==0 && y%2==0){
                x = x/2;
                y = y/2;
                e = 2*e;
            } else if (x%2==0) {
                x /= 2;
            } else if (y%2 == 0) {
                y /= 2;
            }else if(x>y){
                x -= y;
            }else if(y>x){
                y -= x;
            }else{
                e = e*x;
                y=0;
            }
            counter++;
        }
        return e;
    }

    /**
     * source: https://introcs.cs.princeton.edu/java/99crypto/ExtendedEuclid.java.html
     * return the greatest common divisor and linear combination of gcd
     * gcd(a,b) = sa + tb
     * @param a
     * @param b
     * @return An array {int gcd(a,b), int s,int t}
     */
    public static int[] pulverizer(int a, int b){

        if (b==0) {
            return new int[] {a, 1 ,0};
        }
        else{
            int[] values = pulverizer(b, a%b);
            int d = values[0];
            int s = values[2];
            int t = values[1] - (a/b)*values[2];
            return new int[] {d, s, t};
        }

    }

}