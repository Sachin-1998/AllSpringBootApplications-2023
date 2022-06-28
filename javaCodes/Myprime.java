public class Myprime
{
    public static void checkPrime(int n)
    {
        int i,count=0;
        
        if(n==0 || n==1)
        System.out.println("num is not prime");
        else
        {
            for(i=2;i<=n;i++);
            {
                if(n%i == 0)
                count++;
                
            }
            if(count==0)
            System.out.println("prime");
            else
            System.out.println("not prime");
        }
    }
    
    public static void main(String args[]) 
    {
      checkPrime(1);
    }
}
