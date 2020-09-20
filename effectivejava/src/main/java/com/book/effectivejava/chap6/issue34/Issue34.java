package com.book.effectivejava.chap6.issue34;


/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:56 2020-09-19
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class Issue34 {

    public enum Chinese {
        WANGPENG(1);

        private Integer sex;

        Chinese(Integer sex) {
            this.sex = sex;
        }

        public Integer getSex() {
            return sex;
        }
    }


    public enum Japanese {
        WANGPENG(1);
        private Integer sex;

        Japanese(Integer sex) {
            this.sex = sex;
        }

        public Integer getSex() {
            return sex;
        }
    }

    public static void main(String[] args) {
        boolean flag = Chinese.WANGPENG.equals(Japanese.WANGPENG);
        assert flag : "flag is true";
        System.out.println("断言通过");
    }
}
