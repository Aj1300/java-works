import java.util.*;
import java.io.File;
public class doubl {
    public static void main(String args[]){
        Scanner a=new Scanner(System.in);
        System.out.println("enter the file name:");
        String fn=a.nextLine();
        File f =new File(fn);
        try{
            Scanner s=new Scanner(f);
            double max=Double.MAX_VALUE;
            double min=Double.MIN_VALUE;  
            int sum=0;
            while(s.hasNextDouble()){
                double number=s.nextDouble();
                sum+=number;
                if(number<min){
                    min=number;
                }
                if(number>max){
                    max=number;
                }
                if(number==0){
                    System.out.println("invalid");
                }
            }
            
            double avg=(max+min)/2;
            double rangee=max-min;
            System.out.println("max:"+max);
            System.out.println("min:"+min);
            System.out.println("average:"+avg);
            System.out.println("range:"+rangee);

                }catch(Exception e){

        }
        }
}
