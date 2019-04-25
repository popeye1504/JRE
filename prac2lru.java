import java.util.*;

public class prac2lru
{
   public static void main(String[] args)
   {
      Scanner sc=new Scanner(System.in);
      int temp,pointer=0;
      ArrayList<Integer> stack=new ArrayList<Integer>();
      boolean isFull=false;
      int minpos,pageHit=0,pageFault=0;
      int search=-1;
      System.out.println("Enter number of frames");
      int f=sc.nextInt();
      System.out.println("Enter the number of pages");
      int p=sc.nextInt();
      int frame[]=new int[f];
      int page[]=new int[p];
      int mem_layout[][]=new int[f][p];
      System.out.println("Enter the reference string");
      for(int i=0;i<p;i++)
      {
         page[i]=sc.nextInt();
      }
      for(int i=0;i<f;i++)
      {
         frame[i]=-1;
      }
      
      for(int i=0;i<p;i++)
      {
        
        int pages=page[i];
        if(stack.contains(page[i]))
        {
           stack.remove(stack.indexOf(page[i]));
        } 
        search=-1;
        stack.add(page[i]);
        for(int j=0;j<f;j++)
        {
            if(page[i]==frame[j])
            {
               search=j;
               pageHit++;
               break;
            }
        }
        if(search==-1)
        {
           if(isFull)
           {
              minpos=p;
              for(int j=0;j<f;j++)
              {
                 if(stack.contains(frame[j]))
                 {
                   temp=stack.indexOf(frame[j]);
              
                   if(minpos>temp)
                   {
                     minpos=temp;
                     pointer=j;
                   }
                }
             }
          }
          frame[pointer]=pages;
          pointer++;
          pageFault++;
          if(pointer==f)
          {
             pointer=0;
             isFull=true;
          }
          
       }
       for(int j=0;j<f;j++)
           {
              mem_layout[j][i]=frame[j];
           }
       
       }
       for(int i=0;i<f;i++)
       {
          for(int j=0;j<p;j++)
          {
              System.out.print(mem_layout[i][j]+"\t");
          }
          System.out.println();
       }
    }
 }

