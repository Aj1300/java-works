import java.util.Scanner;

class multit extends Thread{
    String n;
    public multit(String na){
        n=na;
    }
    public synchronized void run(){
        if(n.equals("odd")){
            for(int i=1;i<=100;i=i+2){
                System.out.println(i);
            try {
                                Thread.sleep(100);

            } catch(Exception e) {
            }       
            }
        }
        else if(n.equals("even")){
            for(int i=2;i<=100;i=i+2){
                System.out.println(i);
                 try {
                                Thread.sleep(100);

            } catch(Exception e) {
            } 
            }
    }
}

}
public class threads1 {

	public static void main(String args[])
	{
	 multit m = new multit("odd");
	 multit n = new multit("even");
	 m.start();
      n.start();  
    try {
        m.join();
        n.join();
    } catch(Exception e) {
        
    }
    	}
}