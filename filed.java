import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.net.*;
public class filed {
    public static void main(String[] args)throws Exception {
        URL u = new URL("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
		URLConnection uc = u.openConnection();
        int len = uc.getContentLength();
        if(len>0){
            FileOutputStream fout=new FileOutputStream("test.pdf");
			InputStream input = uc.getInputStream();
			int i= 0;
            int c;
            while(((c=input.read())!=-1)&& i < len){
                fout.write(c);
                i++;
            }
        }
    }
}   
