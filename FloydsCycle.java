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
public class FloydsCycle {
    private Node node;
    private Node Node;

    
   public class Node{
    
        private int data;
        private Node next;
    
    
    
   public Node(int data)
   {
   
       this.data=data;
       this.next=null;
   
   
   }
   void display(Node node)
   {
       Node temp;
       for(temp=node;temp!=null;temp=temp.next)
           System.out.print(temp+"->");
           
   
   }
   
   boolean isLoop(Node node)
   {
   return false;
   }
}
   
   public static void main(String args[])
   {
       FloydsCycle k1=new FloydsCycle();
    // k1.Node = new Node(10);
   
   
   
   
   
   
   
   }

}
