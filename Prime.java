import java.util.Scanner;

public class Prime{
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i =2; i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Enter the starting number:");
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        System.out.println("Enter the ending number: ");
        int end = sc.nextInt();
        System.out.println("Prime numbers between "+start+" and "+end+" are:");
        for(int i = start;i< end;i++){
            if(isPrime(i)){
                System.out.println(i+ " ");
            }
        }
    }
}
