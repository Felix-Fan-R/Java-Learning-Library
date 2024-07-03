package q4;
/*
定义函数实现字符串截取，要求从第二个’/’开始截取字符串。
例如：“d:/java/example01.java”字符串，
截取后的结果为：“example01.java”;
”d:/java/demo/exmplae02.java”字符串，
截取后的结果为:“demo/exmplae02.java”。
在main方法中，调用函数实现字符串的截取。
 */
public class q4 {
    public static String tmp(String input) {
        int first = input.indexOf('/');
        int second = input.indexOf('/', first + 1);
        return input.substring(second + 1);
    }

    public static void main(String[] args) {
        String path1 = "d:/java/example01.java";
        String path2 = "d:/java/demo/exmplae02.java";

        System.out.println(tmp(path1));
        System.out.println(tmp(path2));
    }
}
