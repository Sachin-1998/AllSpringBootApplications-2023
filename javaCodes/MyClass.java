public class MyClass 
{
    public static void checkdub(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            for(int k=i+1;k<s.length();k++)
            {
                if(s.charAt(i)==s.charAt(k))
                {
                    count++;
                    break;
                }
            }
            
        }
                if(count!=0)
                System.out.println("true");
                else
                System.out.println("false");
    }
    public static void main(String args[]) 
    {
      checkdub("gslab");
    }
}
