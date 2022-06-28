import java.util.Arrays;
public class Anagram
{
    static void isAnagramString(String s1,String s2)
    {
        boolean result=true;
        if(s1.length()!=s2.length())
        {
            result=false;
        }
        else
        {
            char[] ArrS1 = s1.toLowerCase().toCharArray();  
            char[] ArrS2 = s2.toLowerCase().toCharArray();  
            Arrays.sort(ArrS1);  
            Arrays.sort(ArrS2);  
            result = Arrays.equals(ArrS1, ArrS2);  
        }
        
        if (result) 
        System.out.println(s1 + " and " + s2 + " are anagrams");  
        else 
        System.out.println(s1 + " and " + s2 + " are not anagrams");  
    }

    public static void main(String args[]) 
    {
        isAnagramString("keep","peek");
    }
}