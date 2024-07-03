package q2;
import java.util.Arrays;
import java.util.Scanner;

/*
有 10 位用户对一部电影进行评分，请定义一个数组，键盘输入存放这 10 位用户对该电影的评分。
通过计算，输出这 10 位用户的评分平均值（保留两位小数），并按照降序方式显示用户的评分。

1 2 3 4 5 6 7 8 9 10

 */

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] ratings = new double[10];
        System.out.println("Please enter 10 ratings: ");
        for (int i = 0; i < 10; i++) {
            ratings[i] = scanner.nextDouble();
        }
        scanner.close();

        double sum = 0;
        for (double rating : ratings) {
            sum += rating;
        }
        double average = sum / ratings.length;
        System.out.printf("Average rating: %.2f\n", average);

        Arrays.sort(ratings);
        System.out.println("Ratings in descending order: ");
        for (int i = ratings.length - 1; i >= 0; i--) {
            System.out.println(ratings[i]);
        }
    }
}
