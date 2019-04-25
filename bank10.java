import java.util.*;

public class bank10
{
   public static void main(String args[])
   {
     Scanner sc = new Scanner(System.in);
     
     System.out.println("Enter the number of Process");
     
     int m = sc.nextInt();
     
     System.out.println("Enter the number of Resources");
     
     int n = sc.nextInt();
     
     int MAX [][] = new int[m][n];
     
     int ALLOCATION[][] = new int[m][n];
     
     int NEED[][] = new int[m][n];
     
     int AVAIL[] = new int[n];
     
     boolean flag[] = new boolean[m];
     
     int RES[] = new int[n];
     
     int temp[] = new int[n];
     
     
     System.out.println("Enter the Allocation matrix");
     
     for(int i=0;i<m;i++)
     {
       for(int j=0;j<n;j++)
       {
           ALLOCATION[i][j] = sc.nextInt();
       }
     } 
   
     System.out.println("Enter the MAXIMUM matrix");
     
     for(int i=0;i<m;i++)
     {
       for(int j=0;j<n;j++)
       {
           MAX[i][j] = sc.nextInt();
       }
       
     } 
     
     System.out.println("Enter the AVAILABLE matrix");
     
     for(int j=0;j<n;j++)
     {
        AVAIL[j] = sc.nextInt();
     }
     
     for(int i=0;i<m;i++)
     {
       for(int j=0;j<n;j++)
       {
          AVAIL[j] = AVAIL[j]-ALLOCATION[i][j];
          temp[j]=AVAIL[j];
       }
     }
     
     System.out.println("The Available Matrix is");
     
    
       for(int j=0;j<n;j++)
       {
          System.out.print(AVAIL[j]+"\t");
       }
       
     
     
     
      for(int i=0;i<m;i++)
     {
       for(int j=0;j<n;j++)
       {
           NEED[i][j] = MAX[i][j] - ALLOCATION[i][j];
       }
       
     }
     
     for(int i=0;i<m;i++)
     {
         flag[i] = false;
     } 
     
     
     int count=0;
     int seq[] = new int[m];
     boolean found = false;
     
     while(count < m)
     {
        found = false;
        for(int i=0;i<m;i++)
        {
          if(flag[i] == false)
         { 
          int j;
          for(j=0;j<n;j++)
          {
             if(NEED[i][j] > AVAIL[j])
             {
                break;
             }
          }
         
          if(j == n)
          {
             
               for(int k=0;k<n;k++)
               {
                 AVAIL[k] = AVAIL[k] + ALLOCATION[i][k];
               }
             
             flag[i] = true;
             seq[count] = i+1;
             count++;
             found = true;
          }
         }
       }
        
        if(found==false)
        {
           System.out.println("Not A Safe Sequence");
           break;       
        } 
        
         if(found==true)
     {
             System.out.print("Safe Sequence is ==>");
             for(int i=0;i<m;i++)
             {
                System.out.print(seq[i]+"\t");
             }
     }
        
     }
    
     System.out.println("Enter the Process Number");
     
     int ch = sc.nextInt();
     
     System.out.println("Enter the Resources for the Process");
     
     for(int i=0;i<n;i++)
     {
        RES[i] = sc.nextInt();
     }
     
   
       for(int j=0;j<n;j++)
       {
           ALLOCATION[ch][j] = ALLOCATION[ch][j]+RES[j];     
       }
       
        for(int j=0;j<n;j++)
       {
           System.out.println(ALLOCATION[ch][j]+"\t");        
       }
       
       
       
       for(int j=0;j<n;j++)
       {
         temp[j] = temp[j]-RES[j];
       }
       
       
       for(int j=0;j<n;j++)
       {
         System.out.println(temp[j]+"\t");
       }
       
     for(int i=0;i<m;i++)
     {
       for(int j=0;j<n;j++)
       {
           NEED[i][j] = MAX[i][j] - ALLOCATION[i][j];
       }
       
     }
     
      for(int i=0;i<m;i++)
     {
       for(int j=0;j<n;j++)
       {
           System.out.println(NEED[i][j]+"\t");
       }
       System.out.println();
       
     }
     
     for(int i=0;i<m;i++)
     {
         flag[i] = false;
     } 
     
     count=0;
      
     while(count < m)
     {
        found = false;
        for(int i=0;i<m;i++)
        {
          if(flag[i] == false)
         { 
          int j;
          for(j=0;j<n;j++)
          {
             if(NEED[i][j] > temp[j])
             {
                break;
             }
          }
         
          if(j == n)
          {
             
               for(int k=0;k<n;k++)
               {
                 temp[k] = temp[k] + ALLOCATION[i][k];
               }
             
             flag[i] = true;
             seq[count] = i+1;
             count++;
             found = true;
          }
         }
       }
        
        if(found==false)
        {
           System.out.println("Not A Safe Sequence");
           break;       
        } 
        
        
   if(found)
  {
          System.out.print("Safe Sequence is ==>");
             for(int i=0;i<m;i++)
             {
                System.out.print(seq[i]+"\t");
             }
              
   }
}
}
}  
     
