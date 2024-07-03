package q3;

import java.io.*;
/*
文件拷贝是一个非常基础的功能，有多种方式可以完成文件的拷贝，
如字节流、字节缓冲流、字符流、字符缓冲流、字节流与字符流的转换。
编写代码，分别使用上述几种方式完成文件的拷贝功能。
 */
public class q3 {
    //字节
    public static void cpByte(File source, File dest) throws IOException {
        try (InputStream is = new FileInputStream(source); OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    //缓冲字节
    public static void cpBufferedByte(File source, File dest) throws IOException {
        try (InputStream is = new BufferedInputStream(new FileInputStream(source)); OutputStream os = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    //字符
    public static void cpCharacter(File source, File dest) throws IOException {
        try (Reader reader = new FileReader(source); Writer writer = new FileWriter(dest)) {
            char[] buffer = new char[1024];
            int length;
            while ((length = reader.read(buffer)) > 0) {
                writer.write(buffer, 0, length);
            }
        }
    }

    //缓冲字符
    public static void cpBufferedCharacter(File source, File dest) throws IOException {
        try (Reader reader = new BufferedReader(new FileReader(source)); Writer writer = new BufferedWriter(new FileWriter(dest))) {
            char[] buffer = new char[1024];
            int length;
            while ((length = reader.read(buffer)) > 0) {
                writer.write(buffer, 0, length);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File test = new File("./test");
        File train = new File("./train");


        cpByte(test, train);
        cpBufferedByte(test, train);
        cpCharacter(test, train);
        cpBufferedCharacter(test, train);
    }
}
