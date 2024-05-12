import java.util.Scanner;

class multiti extends Thread{
    public void run(){
            for(int i=1;i<=10;i=i+2){
                System.out.println(Thread.currentThread().getName() +":"+i);
            }
    }   
}
public class threads2{
    public static void main(String args[]){

        multiti m = new multiti();
        multiti n = new multiti();
        try{
            System.out.println("Before changing priority : "); 
            System.out.println("t1 priority : " + m.getPriority()); 
            System.out.println("t2 priority : " + n.getPriority());  
        m.setPriority(1);
        n.setPriority(2);
        System.out.println("Before changing priority : "); 
        System.out.println("t1 priority : " + m.getPriority()); 
        System.out.println("t2 priority : " + n.getPriority());  
        m.start();
        n.start();
        }
        catch(Exception e){

        }
        }
}