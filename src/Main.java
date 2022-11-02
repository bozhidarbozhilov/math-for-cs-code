

public class Main {
    public static void main(String[] args) {
        System.out.println(gcd(21212121,12121212));
        System.out.println(binaryGCD(21212121,12121212));
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
            }else if(x==1 || x==y){
                e = e*x;
                y=0;
            }
        }
        return e;
    }

    // TODO pulverizer algorithm
//    public static void pulverizer(int a, int b){
//        int x = a;
//        int y = b;
//        int oldX, oldY;
//        int qcnt = x/y;
//        int rem = x - qcnt*y;
//        int comb = a - qcnt*b;
//        while (rem != 0){
//            x = y;
//            y = rem;
//            qcnt = x/y;
//            rem = x - qcnt*y;
//            comb = 0;
//        }
//        System.out.println();
//    }
}