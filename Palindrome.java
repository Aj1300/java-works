import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = s.nextLine();
        
        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
    
    public static boolean isPalindrome(String str) {
        StringBuilder reversed = new StringBuilder(str);
        reversed.reverse(); 
        return str.equals(reversed.toString());
    }
}



