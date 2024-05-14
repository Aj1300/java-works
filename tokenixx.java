import java.util.*;
public class tokenixx{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the numbers:");
        String a=s.nextLine();
        StringTokenizer str=new StringTokenizer(a);
        int sum=0;
        while(str.hasMoreTokens()){
            String t=str.nextToken();
            try {
                int aa=Integer.parseInt(t);
                System.out.println(aa);
                sum+=aa;

            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println(sum);
    }
}