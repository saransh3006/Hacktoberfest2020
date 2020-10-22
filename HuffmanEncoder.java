/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Saransh Gupta
 */
public class HuffmanEncoder {

    private class Node implements Comparable<Node> {

        char data;
        int freq;
        Node left;
        Node right;

        Node(char data, int freq) {
            this.data = data;
            this.freq = freq;
        }

        public int compareTo(Node o) {

            return this.freq - o.freq;
        }

    }
    HashMap<Character, String> encoder = new HashMap<>();
    HashMap<String, Character> decoder = new HashMap<>();

    void traverse(Node root, String asf) {
        if (root.left == null && root.right == null) {
            encoder.put(root.data, asf);
            decoder.put(asf, root.data);
            return;

        }
        traverse(root.left, asf + "0");
        traverse(root.right, asf + "1");
    }

    HuffmanEncoder(String feeder) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {

            if (fmap.containsKey(feeder.charAt(i)) == false) {
                fmap.put(feeder.charAt(i), 1);

            } else {
                fmap.put(feeder.charAt(i), fmap.get(feeder.charAt(i)) + 1);
            }

        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        ArrayList<Character> keys = new ArrayList<>(fmap.keySet());

        for (int i = 0; i < keys.size(); i++) {
            Character key = keys.get(i);
            Node n = new Node(key, fmap.get(key));
            pq.add(n);
        }

        while (pq.size() > 1) {
            Node n1 = pq.peek();
            pq.remove();
            Node n2 = pq.peek();
            pq.remove();

            Node n3 = new Node('$', n1.freq + n2.freq);
            n3.left = n1;
            n3.right = n2;
            pq.add(n3);

        }

        Node root = pq.peek();
        pq.remove();

        traverse(root, "");

    }

    public void encode(String str) {
        String encodedStr = "";
        for (int i = 0; i < str.length(); i++) {

            encodedStr += encoder.get(str.charAt(i));

        }

        System.out.println(encodedStr);
    }

    public void decode(String str) {
        String res = "";
        String pref = "";
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            pref += ch;
            if (decoder.containsKey(pref) == true) {
                res += decoder.get(pref);
                pref = "";
            }
        }
        System.out.println(res);
    }

    public static void main(String args[]) {

        HuffmanEncoder obj = new HuffmanEncoder("for this assignment, you will build a file compression algorithm that uses binary trees and priority queues. your program will allow the user to compress and decompress files usingthe standard huffman algorithm for encoding and decoding.huffman encoding is an example of a lossless compression algorithm that works particularly well on text but can, in fact, be applied to any type of file. using huffman encoding to compress a file can reduce the storage it requires by a third, half, or even more, in some situations. you’ll be impressed with the compression algorithm, and you’ll be equally impressed that you’re outfitted to implement the core of a tool that imitates one you’re already very familiar withhe starter code for this project is available as a zip archive. a demo is available as a jar");
        obj.encode("aabbcc jjj");
        obj.decode("110011000011000011000001100011111101111110101111110101111110");
        
    }

}
