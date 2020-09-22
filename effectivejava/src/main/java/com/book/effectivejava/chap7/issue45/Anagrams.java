package com.book.effectivejava.chap7.issue45;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 14:25 2020-09-22
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class Anagrams {
    public static void main(String[] args) throws FileNotFoundException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try(Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()){
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word),(unused)-> new TreeSet<>()).add(word);
            }
        }
        for (Set<String> group : groups.values())
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ":" + group);
    }

    private static String alphabetize(String s){
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
