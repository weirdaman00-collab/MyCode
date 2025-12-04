import java.util.*;

public class PrimeRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        for(int i = num1; i <= num2; i++) {
            if(i > 1) {
                boolean prime = true;
                for(int j = 2; j <= i/2; j++) {
                    if(i % j == 0) {
                        prime = false;
                        break;
                    }
                }
                if(prime) System.out.println(i);
            }
        }
    }
}
