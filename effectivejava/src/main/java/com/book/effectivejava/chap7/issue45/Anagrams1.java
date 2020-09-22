package com.book.effectivejava.chap7.issue45;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 14:56 2020-09-22
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class Anagrams1 {

    public static void main(String[] args) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try(Stream<String> words = Files.lines(dictionary)) {
            words.collect(Collectors.groupingBy(Anagrams1::alphabetize))
                    .values().stream().filter(group -> group.size()>= minGroupSize)
                    .forEach(group -> System.out.println(group.size() + ":" + group));
        }
    }

    private static String alphabetize(String s){
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

}
