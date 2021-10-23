/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Saransh
 */
public class HashMapQuestions {
    
   static void highestFrequencyChar(String word)
    {
        
        HashMap<Character,Integer> mp = new HashMap<>();
        char ch[] = new char[word.length()];
        int counter[] = new int[word.length()];
        
        for(int i=0;i<word.length();i++)
        {
            int count=1;
            mp.put(word.charAt(i),count);
        
        
        }
        int max=0;
        char ans='a';
        for(int i=0;i<word.length();i++)
        { 
            if(mp.containsKey(word.charAt(i)))
            {
                int val=mp.get(word.charAt(i));
                mp.put(word.charAt(i),++val);
                if(val>max)
                { 
                    max=val;
                    ans=word.charAt(i);
                }
            }
        }
        System.out.println(ans+" Frequency->" +(max-1));
    
    }
   static void highestFrequencyCharSir(String word)
   {
   
     HashMap<Character,Integer> fmp = new HashMap<>();
     for(int i=0;i<word.length();i++)
     {
        if(fmp.containsKey(word.charAt(i))==false)    //Making Frequency Map
        {
            fmp.put(word.charAt(i),1);

        }
        else
        {
            fmp.put(word.charAt(i),fmp.get(word.charAt(i))+1); //Increment Frequencies

        }
     }
     char mfc = word.charAt(0);         //max frequency character
     ArrayList<Character> keys = new ArrayList<>(fmp.keySet());
     //System.out.println(keys);
     for(int i=0;i<keys.size();i++)
     {
     Character key=keys.get(i);
     //System.out.print(key);
     if(fmp.get(mfc)<fmp.get(key))
     {
     mfc=key;
     }
     }
     System.out.println(mfc);
     
   
   }
   static void getCommonElements(int[] one,int[] two)
   {
   
   HashMap<Integer,Integer> fmap=new HashMap<>();
   int freq=0;
   for(int i=0;i<one.length;i++)
   {
   if(fmap.containsKey(one[i])==false)
   {
       fmap.put(one[i],1);
   }
   else
   {
    fmap.put(one[i],fmap.get(one[i])+1);
   
   }
   
   }
   for(int i=0;i<two.length;i++)
   {
   if(fmap.containsKey(two[i]))
   {
   System.out.print(two[i]);
   fmap.remove(two[i]);
   
   }
   
   }
   System.out.println();
   }
   static void getCommonElements2(int[] one,int[] two)
   {
   
       HashMap<Integer,Integer> fmap=new HashMap<>();
   for(int i=0;i<one.length;i++)
   {
   
   if(fmap.containsKey(one[i])==false)
   {
       fmap.put(one[i],1);
   }
   else
   {
    fmap.put(one[i],fmap.get(one[i])+1);
   
   }
   
   }
   for(int i=0;i<two.length;i++)
   {
   if(fmap.containsKey(two[i]) && fmap.get(two[i])>0)
   {
   System.out.print(two[i]);
   fmap.put(two[i],fmap.get(two[i])-1);
   }
   
   }
System.out.println();
   }
   static void longestConsecutiveSequence(int[] arr)
   {
   HashMap<Integer,Boolean> map = new HashMap<>();
   
   for(int i=0;i<arr.length;i++)
   {
   
       map.put(arr[i],true);
   
   }
   for(int i=0;i<arr.length;i++)
   {
       if(map.containsKey(arr[i]-1)==true)
       map.put(arr[i],false);
   
   }
   int msp=0,mlen=Integer.MIN_VALUE;
   for(int i=0;i<arr.length;i++)
   {
   int tsp=arr[i];
   int tlen=0;
   while(map.containsKey(tsp+tlen)==true)
   {
   tlen++;
   }
   if(tlen>mlen)
   {
   mlen=tlen;
   msp=tsp;
   
   }
   
   }
       
   System.out.println(msp+"@"+mlen);
       
   }
   
   private static class helperPair{
   public int start=-1;
   public int end=-1;
   
   
   }
   static void longestSubArrayMultipleofK(int[] arr,int k)
   {
       int modarr[] = new int[arr.length];
       int sum=0;
       HashMap<Integer,helperPair> map = new HashMap<>();
   for(int i=0;i<arr.length;i++)
   {
   sum+=arr[i];
   modarr[i]=sum%k;
   }
   for(int i=0;i<k;i++)
   {
       
       map.put(i, new helperPair());
   
   }
   map.get(0).start=0;
   int osp=-1;
   int oep=-2;
   for(int i=0;i<modarr.length;i++)
   {
       if(map.get(modarr[i]).start==-1)
       {
           
            map.get(modarr[i]).start=i+1;
       }
       else
       {
            
            map.get(modarr[i]).end=i;
       }
   if( map.get(modarr[i]).end -  map.get(modarr[i]).start>oep-osp)
   {
   osp=map.get(modarr[i]).start;
   oep=map.get(modarr[i]).end;
   }
   
   }
   System.out.println(osp+" "+oep);
   }
    
    public static void main(String args[])
    {
    
//                highestFrequencyChar("hello");
//
//        highestFrequencyCharSir("hello");
        int[] one ={5,1,3,2,2,1,2};
        int[] two={1,4,1,2,2,1,5};
//        getCommonElements(one,two);
        
//        getCommonElements2(one, two);
        int[] arr={2,12,9,16,10,5,3,20,25,11,1,8,6};
        int[] sarr={12,5,7,15,3,6,11,2,9,8,-1,7};
//        longestConsecutiveSequence(arr);
        longestSubArrayMultipleofK(sarr, 5);
        
    }
    
}
