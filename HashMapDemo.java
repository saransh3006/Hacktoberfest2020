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
public class HashMapDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<String,Integer> mp = new HashMap<>();
        mp.put("India",135);
        mp.put("China",200);
        mp.put("Nigeria",50);
        mp.put("USA",80);
        
        System.out.println(mp);
        System.out.println(mp.containsKey("India"));
          System.out.println(mp.containsKey("Sweden"));
          
             System.out.println(mp.get("India"));
          System.out.println(mp.get("Sweden"));
           mp.put("India",145);
           mp.put("Sweden",10);
            System.out.println(mp);
            // SyskeySet());tem.out.println(mp.keySet());
             ArrayList<String> keys = new ArrayList<>(mp.keySet());
             System.out.print(keys);
         
        
    }
    
}
