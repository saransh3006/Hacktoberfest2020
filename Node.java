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
public class Node {
    
        private int data;
        private Node next;
    
    
    
   public Node(int data)
   {
   
       this.data=data;
       this.next=null;
   
   
   }
   static void display(Node node)
   {
       Node temp;
       for(temp=node;temp!=null;temp=temp.next)
           System.out.print(temp.data+"->");
           
   
   }
   
   static void removeloop(Node slow, Node fast)
   {
       Node prev = fast;
   while(slow!=fast)
   {
       slow=slow.next;
       prev=fast;
       fast=fast.next;
               
   
   
   }
   prev.next=null;
   
   
   }
   
   static boolean isLoop(Node node)
   {
       Node slow=node;
       Node fast=node;
       while(fast.next!=null && fast.next.next!=null)
       {
       fast=fast.next.next;
       slow=slow.next;
       if(fast==slow)
       {
           removeloop(node,fast);
           return true;
       }
       }
       return false;
   
   }

   
   public static void main(String args[])
   {
      
   
   Node n1= new Node(10);
   Node n2= new Node(20);
   Node n3= new Node(130);
   Node n4= new Node(140);
   Node n5= new Node(150);
   Node n6= new Node(160);
   Node n7= new Node(170);
   Node n8= new Node(180);
   Node n9= new Node(190);
   Node n10= new Node(110);
   
   n1.next=n2;
   n2.next=n3;
   n3.next=n4;
   n4.next=n5;
   n5.next=n6;
   n6.next=n7;
   n7.next=n8;
   n8.next=n9;
   n9.next=n10;
   n10.next=n5;
   
   System.out.println(isLoop(n1));
   display(n1);
   
   
   }
    
}
