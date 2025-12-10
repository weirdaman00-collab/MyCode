import java.util.Random;
class NumbGen extends Thread {
    Random rand = new Random();
    public void run(){
        while (true) { 
            int num = rand.nextInt(100);
            System.out.println("The Generated Number is: "+num);
            if(num%2==0){
                new SquareThread(num).start();
            }
            else{
                new CubeThread(num).start();
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
class SquareThread extends Thread {
    int num;
    SquareThread(int num){
        this.num = num;
    }
    public void run(){
        System.out.println("Square of" + num+" is :"+(num*num));
    }
}
class CubeThread extends Thread {
    int num;
    CubeThread(int num){
        this.num = num;
    }
    public void run(){
        System.out.println("Cube of "+num+" is :"+(num*num*num));
    }
}
public class jjjjjjj {
    public static void main(String[] args){
        NumbGen ng = new NumbGen();
        ng.start();
    }
}
