import java.util.LinkedList;
import java.util.Scanner;

public class DoublyLinkedList {
    public static void main(String[] args) {

        LinkedList<String> doublyLinkedList = new LinkedList<>();
        Scanner s=new Scanner(System.in);
        try{
            System.out.println("enter the no of elements");
            int n =s.nextInt();
            s.nextLine();
            int i;
            for( i=1;i<=n;i++){
                
                String str="";
                System.out.println("enter the "+i+" element");
                 str=s.nextLine();
                doublyLinkedList.add(str);
            }
        }
        catch(Exception e){
            System.out.println("Error:"+e);
        }

        System.out.println("Original Doubly Linked List:");
        System.out.println(doublyLinkedList);

        try{

            System.out.println("enter the element you want to delete");
            String elementToDelete =s.nextLine();
            boolean isRemoved = doublyLinkedList.remove(elementToDelete);
            if (isRemoved) {
                System.out.println("\nElement '" + elementToDelete + "'  is deleted ");
            } else {
                System.out.println("\nElement '" + elementToDelete + "' not found in the list.");
            }

            // Display the contents of the list after deletion
            System.out.println("\nContents of the list after deletion:");
            for (String element : doublyLinkedList) {
                System.out.println(element);
            }
            }
            catch(Exception e){
                System.out.println("Error: "+e);
            }
    }
}
