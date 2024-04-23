package GuessGUI;

import javax.swing.*;
import java.util.Random;

public class guessgui extends JFrame {
    private JTextField guessField;
    private JLabel ending;
    private JButton guessButton;
    private int num;
    private int numberOfTries = 0;

    public guessgui() {

        Random rand = new Random();
        JPanel panel = new JPanel();
        this.setTitle("猜数字游戏");

        this.setLocation(500, 300);
        num = rand.nextInt(100) + 1;
        this.getContentPane().add(panel);
        guessField = new JTextField(10);
        guessButton = new JButton("猜一猜");
        guessButton.addActionListener(e -> checkGuess());
        ending = new JLabel("请输入一个1到100之间的数字：");

        panel.add(ending);
        panel.add(guessButton);
        panel.add(guessField);


        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText());
            numberOfTries++;
            if (guess < num) {
                ending.setText("数字太小了，请再试一次。");
            } else if (guess > num) {
                ending.setText("数字太大了，请再试一次。");
            } else {
                ending.setText("恭喜你，你猜对了！你一共猜了 " + numberOfTries + " 次。");
                guessField.setEditable(false);
                guessButton.setEnabled(false);
            }
        } catch (NumberFormatException ex) {
            ending.setText("请输入一个有效的数字！");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(guessgui::new);
    }
}

/* 可以解决组件显示不出来的问题！！！Swing是线程不安全的，是单线程的设计，所以只能从事件派发线程访问将要在屏幕上绘制的Swing组件。ActionListener的actionPerformed方法是在事件派发线程中调用执行的，而点击了开始按钮后，执行了go()方法，在go()里，虽然也去执行了更新组件的方法 */
/* SwingUtilities.invokeLater()在把可运行的对象放入队列后就返回，而SwingUtilities.invokeAndWait()一直等待知道已启动了可运行的run方法才返回。如果一个操作在另外一个操作执行之前必须从一个组件获得信息，则应使用SwingUtilities.invokeAndWait()方法。 */