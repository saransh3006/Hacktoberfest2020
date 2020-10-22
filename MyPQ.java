/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

/**
 *
 * @author Saransh
 */
import java.util.*;

public class MyPQ {

    private ArrayList<Integer> list = new ArrayList<>();

    public MyPQ()
    {
    
    }
    public MyPQ(ArrayList<Integer> content) {

        
        for(int i=0;i<content.size();i++)
        {
        list.add(content.get(i));
        }
        
        for(int i=0;i<list.size()-1;i++)
        {
        
            downheapify(i);
        }
        
        
        
        
    }

    private void upHeapify(int ci) {

        if (ci == 0) {
            return;
        }
        int pi;
        pi = (ci - 1) / 2;
        if (list.get(pi) > list.get(ci)) {
            int temp = list.get(pi);
            list.set(pi, list.get(ci));
            list.set(ci, temp);
            upHeapify(pi);          //called here to reduce number of calls
        }

    }

    private void downheapify(int pi) {

        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        int min = pi;

        if (lci < list.size() && list.get(lci) < list.get(min)) {
            min = lci;
        }
        if (rci < list.size() && list.get(rci) < list.get(min)) {
            min = rci;
        }
        if (min != pi) {
            int temp = list.get(min);
            list.set(min, list.get(pi));
            list.set(pi, temp);
            downheapify(min);

        }

    }

    public int peek() {

        return list.get(0);

    }

    public void remove() {

        int temp = list.get(size() - 1);
        list.set(size() - 1, list.get(0));
        list.set(0, temp);
        list.remove(size() - 1);
        downheapify(0);

    }

    public void add(int data) {
        list.add(data);
        upHeapify(size() - 1);
    }

    public int size() {
        return list.size();
    }

    public static void main(String args[]) {

        ArrayList<Integer> pq = new ArrayList<>();
         
        pq.add(10);
        pq.add(30);
        pq.add(20);
        pq.add(40);
        pq.add(80);
        pq.add(60);
        pq.add(70);
        pq.add(50);
        pq.add(100);
        MyPQ pq1 = new MyPQ(pq);
        
       while(pq1.size()>0)
       {
       System.out.print(pq1.peek()+" ");
       pq1.remove();
       }
    }
}
