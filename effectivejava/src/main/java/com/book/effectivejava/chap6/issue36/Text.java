package com.book.effectivejava.chap6.issue36;

import java.util.EnumSet;
import java.util.Set;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 15:47 2020-09-20
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class Text {
    private int code = 0;


    public enum Style{
        BOLD(1<<0),ITALIC(1<<1),UNDERLINE(1<<2),STRIKETHROUGH(1<<3);

        private final int code;

        Style(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    private void applyStyles(Set<Style> styleSet){
        for (Style style : styleSet){
            this.code = code | style.getCode();
        }
    }

    private int getCode() {
        return code;
    }

    public static void main(String[] args) {
        Text text = new Text();
        System.out.println(text.getCode());
        text.applyStyles(EnumSet.of(Style.UNDERLINE,Style.STRIKETHROUGH));
        System.out.println(text.getCode());
        System.out.println( 0 | 4 | 8);
    }
}
