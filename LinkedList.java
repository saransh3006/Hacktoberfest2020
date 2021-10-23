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
public class LinkedList {

    public class Node {

        public int data;
        public Node next;

    }
    private int size;
    private Node head;
    private Node tail;
    private Node rdrleft;

    public LinkedList() //not required in java
    {
        size = 0;
        head = null;
        tail = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getFirst() {
        if (size == 0) {
            return -1;
        } else {
            return head.data;
        }

    }

    public int getLast() {
        if (size == 0) {
            return -1;
        } else {
            return tail.data;
        }

    }

    private Node getNodeAt(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private void isSizeAdd0(int data) {
        Node nn = new Node();
        head = tail = nn;
        nn.data = data;
        size = 1;

    }

    public void addlast(int data) {
        if (size == 0) {
            isSizeAdd0(data);
        } else {
            Node nn = new Node();
            nn.data = data;
            nn.next = null;

            tail.next = nn;
            tail = nn;
            size++;
        }
    }

    public void addfirst(int data) {
        if (size == 0) {
            isSizeAdd0(data);
        } else {
            Node nn = new Node();
            nn.data = data;
            nn.next = head;
            head = nn;
            size++;
        }
    }

    public void addAt(int data, int index) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addfirst(data);
        } else if (index == size) {
            addlast(data);

        } else {
            Node nn = new Node();
            nn.data = data;
            Node temp = getNodeAt(index - 1);
            nn.next = temp.next;
            temp.next = nn;
            size++;
        }
    }

    public int getAt(int idx) {
        if (idx < 0 || idx > size) {
            return -1;
        } else {
            Node temp = getNodeAt(idx);
            return temp.data;

        }
    }

    private int sizeremove() {
        int temp = head.data;
        size = 0;
        head = tail = null;
        return temp;
    }

    public int removeFirst() {
        if (size == 1) {
            return sizeremove();
        }
        int temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public int removeLast() {
        if (size == 0) {
            return -1;
        }
        if (size == 1) {
            return sizeremove();
        }
        int temp = tail.data;
        Node t = getNodeAt(size - 3);
        tail = t.next;
        size--;
        return temp;

    }

    public int removeAt(int idx) {
        if (idx < 0 || idx >= size) {
            return -1;
        }
        if (idx == 0) {
            removeFirst();
        } else if (idx == size - 1) {
            removeLast();

        } else {
            Node n = getNodeAt(idx - 1);
            int temp = n.next.data;
            n.next = n.next.next;
            size--;
            return temp;

        }

        return 0;

    }

    public void reverseDataIteratively() {
        if (size == 0) {
            System.out.print("Empty");
        }
        int temp;
        for (int i = 0; i < size / 2; i++) {
            Node n1 = getNodeAt(i);
            Node n2 = getNodeAt(size - i - 1);
            temp = n1.data;
            n1.data = n2.data;
            n2.data = temp;

        }

    }

    public void reversePointerIteratively() {
        Node prev = null;
        Node current = head;
        Node temp = current.next;
        while (current != null) {

            current.next = prev;
            prev = current;
            current = temp;
            if (temp != null) {
                temp = temp.next;
            }

        }
        Node temp1 = head;
        head = tail;
        tail = temp1;

    }

    private void reverseDisplay(Node node) {
        if (node == null) {
            return;

        }
        reverseDisplay(node.next);
        System.out.print(node.data + " ");

    }

    public void reverseDisplay() {

        reverseDisplay(head);
    }

    private void reversePointerRecursively(Node node) {
        if (node == tail) {
            return;
        }

        reversePointerRecursively(node.next);
        node.next.next = node;

    }

    public void reversePointerRecursively() {
        reversePointerRecursively(head);
        Node temp = head;
        head = tail;
        tail = temp;
        tail.next = null;

    }

    private void reverseDataRecursively(Node r, int floor) {
        if (r == null) {
            return;
        }

        reverseDataRecursively(r.next, floor + 1);
        if (floor >= size / 2) {
            int temp = r.data;
            r.data = rdrleft.data;
            rdrleft.data = temp;

            rdrleft = rdrleft.next;

        }

    }

    public void reverseDataRecursively() {

        rdrleft = head;
        reverseDataRecursively(head, 0);

    }

    private boolean isPallindrome(Node r, int floor) {
        if (r == null) {
            return true;
        }

        boolean ans = isPallindrome(r.next, floor + 1);
        if (floor >= size / 2) {
            if (r.data != rdrleft.data) {
                return false;
            }

            rdrleft = rdrleft.next;
        }
        return ans;
    }

    public boolean isPallindrome() {
        rdrleft = head;
        return isPallindrome(head, 0);

    }

    private void fold(Node r, int floor) {
        if (r == null) {
            return;
        }

        fold(r.next, floor + 1);
        if (floor > size / 2) {
            Node temp = rdrleft.next;
            rdrleft.next = r;
            r.next = temp;

            rdrleft = r.next;

        } else if (floor == size / 2) {
            tail = r;
            r.next = null;
        }

    }

    public void fold() {
        rdrleft = head;
        fold(head, 0);

    }

    public void unfoldfunny() {
        if (size % 2 != 0) {
            for (int i = 0; i < size - 2; i++) {
                fold();
            }
        } else {
            for (int i = 0; i < size - 1; i++) {
                fold();
            }
        }

    }

    private void unfold(Node t1) {

        if (t1.next == null) {
            tail = head = t1;
            return;
        } else if (t1.next.next == null) {
            head = t1;
            tail = t1.next;
            return;
        }
        Node t2 = t1.next;
        unfold(t1.next.next);
        t1.next = head;
        head = t1;

        tail.next = t2;
        tail = t2;
        tail.next = null;

    }

    public void unfold() {

        unfold(head);

    }

    public void kreverse(int k) {
        LinkedList temp = new LinkedList();

        LinkedList acc = new LinkedList();
        int counter = 1;
        int c2 = 0;
        while (this.size > 0) {

            for (int i = 0; i < k && this.size > 0; i++) {
                temp.addfirst(this.removeFirst());

            }
            if (acc.size == 0) {
                acc.head = temp.head;
                acc.tail = temp.tail;
                acc.size = temp.size;
                temp.head = null;
                temp.tail = null;
                temp.size = 0;
            } else {

                acc.tail.next = temp.head;
                acc.tail = temp.tail;
                acc.size += temp.size;
                temp.head = null;
                temp.tail = null;
                temp.size = 0;

            }

        }

        this.head = acc.head;
        this.tail = acc.tail;
        this.size = acc.size;
    }

    public void removeDuplicate() {
        LinkedList l = new LinkedList();

        while (this.size > 0) {
            int temp = this.removeFirst();
            if (l.size == 0 || l.tail.data != temp) {
                l.addlast(temp);
            }
        }
        this.head = l.head;
        this.tail = l.tail;
        this.size = l.size;
    }

    public void oddEven() {
        LinkedList odd = new LinkedList();
        LinkedList even = new LinkedList();
        while (this.size > 0) {
            int temp = this.removeFirst();

            if (temp % 2 == 0) {
                odd.addlast(temp);
            } else {
                even.addlast(temp);
            }

        }
        if (odd.size == 0) {
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size;

        } else if (even.size == 0) {
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size;

        } else {
            odd.tail.next = even.head;
            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;

        }
    }

    private Node midNode(Node start, Node end) {
        Node slow = start;
        Node fast = start;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;

    }

    public int midElement() {
        Node result = midNode(this.head, this.tail);

        return result.data;
    }

    public int kthFromLast(int k) {
        Node slow = this.head;
        Node fast = this.head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;

        }
        return slow.data;

    }

    public void mergeTwoLinkedList(LinkedList l1, LinkedList l2) {
        Node temp1 = l1.head;
        Node temp2 = l2.head;

        while (true) {
            if (temp1 == null && temp2 == null) {
                break;
            } else if (temp2 == null) {

                this.addlast(temp1.data);
                temp1 = temp1.next;
            } else if (temp1 == null) {
                this.addlast(temp2.data);
                temp2 = temp2.next;

            } else {

                if (temp1.data <= temp2.data) {
                    this.addlast(temp1.data);
                    temp1 = temp1.next;
                } else {
                    this.addlast(temp2.data);
                    temp2 = temp2.next;
                }
            }

        }

    }

    private LinkedList mergeSort(Node sp, Node ep) {
        if (ep == sp) {
            LinkedList l = new LinkedList();
            int data = sp.data;
            l.addlast(data);
            return l;
        }
        LinkedList l3 = new LinkedList();
        LinkedList l1 = mergeSort(sp, midNode(sp, ep));
        LinkedList l2 = mergeSort(midNode(sp, ep).next, ep);
        // LinkedList l3 = new LinkedList();
        l3.mergeTwoLinkedList(l1, l2);
        return l3;
    }

    public LinkedList mergeSort() {
        LinkedList res = mergeSort(this.head, this.tail);
        return res;
    }
//  private int addLinkedList(Node l1,Node l2,int size1,int size2,LinkedList temp,LinkedList result)
//  {
//  
// if(size1>size2){
// addLinkedList(l1.next,l2.next,size1-1,size2-1);
// }
// if(size1==size2)
// {
//    result.addfirst(l1.data+l2.data);
// }
//  
//  
//  
//  }
//  public void addLinkedList(LinkedList l1,LinkedList l2,)
//  {
//      
//      
//      
//  }
//      

    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList List = new LinkedList();

//        List.addlast(10);
//        List.addlast(20);
//        List.addlast(30);
//        List.display();
//        System.out.println();
//        List.addfirst(40);
//        List.addfirst(50);
//        List.display();
//        System.out.println();
//        List.addAt(100,3);
//        List.display();
//        System.out.println();
//        List.removeFirst();
//        List.removeFirst();
//        List.display();
//        System.out.println();
//        List.removeLast();
//        List.display();
//        System.out.println();
//        List.addlast(200);
//         List.display();
//        System.out.println();
//        List.removeAt(2);
        List.addlast(10);
        List.addlast(10);
        List.addlast(10);
        List.addlast(40);
        List.addlast(40);
        List.addlast(40);
        List.addlast(40);
        List.addlast(80);
        List.addlast(100);
        List.removeDuplicate();
        List.display();
        System.out.println();

    }

}
