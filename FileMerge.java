import java.io.*; 

public class FileMerge  
{ 
    public static void main(String[] args) throws IOException  
    { 
        // PrintWriter object for file3.txt 
        PrintWriter pw = new PrintWriter("ccc.txt"); 
          
        // BufferedReader object for file1.txt 
        BufferedReader br = new BufferedReader(new FileReader("aaa.txt")); 
       // BufferedReader bf = new BufferedReader(new FileReader("bbb.txt")); 
        String line = br.readLine(); 
       // String linee = bf.readLine(); 
        // loop to copy each line of  
        // file1.txt to  file3.txt 
        int i=0;
        while (line != null) 
        { 
            pw.println(i+". "+line); 
            //pw.println(linee); 
            line = br.readLine();
            i++;
           // linee = bf.readLine(); 
        } 
        pw.flush(); 
        // closing resources 
        br.close(); 
        pw.close(); 
          
        System.out.println("Merged file1.txt and file2.txt into file3.txt"); 
    } 
} 