/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlists;


/**
 *
 * @author test
 */
public class ReverseDataIteratively {
    
    public static void main(String args[])
    {
    LinkedList l1= new LinkedList();
    
    l1.addlast(70);
    l1.addlast(60);
    l1.addlast(50);
    l1.addlast(40);
    l1.addlast(20);

  LinkedList l3 = l1.mergeSort();
   l3.display();
   System.out.println();
    l1.display();
    

    
  
    

    }
}
