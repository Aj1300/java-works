import java.util.*;
class squt extends Thread{
    int n;
    public squt(int na){
        n=na;
    }
    public void run(){
        int sq=n*n;
        System.out.println("squt:"+sq);
        try{
            Thread.sleep(1000);
        }catch(Exception e){

        }
    }
}
class cubt extends Thread{
    int n;
    public cubt(int na){
        n=na;
    }
    public void run(){
        int cu=n*n*n;
        System.out.println("cube:" +cu);
        try{
            Thread.sleep(1000);
        }catch(Exception e){

        }
    }
}

class randot extends Thread{
    public void run(){
        Random r=new Random();
        for(int i=0;i<=5;i++){
            int rand=r.nextInt(10);
            System.out.println(rand);
            if(rand%2==0){
                squt s=new squt(rand);
                s.start();
            }
            else{
                cubt c = new cubt(rand);
                c.start();
            }
        }

    }
}

public class threads3 {
    public static void main(String args[]){
        randot r=new randot();
        r.start();
    }
}
