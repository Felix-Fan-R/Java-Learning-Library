package GuessGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class guessgui extends JFrame {
    JTextField shuruchuangkou;
    JLabel shuchubiaoqian, caishubiaoqian, shurubiaoqian;
    JButton caishuanniu, zuobianniu, zuozheanniu;
    JPanel zhumianban, shurumianban, teshumianban, shuchumianban, zuozhemianban;
    int num, caishutmp = 0;
    public guessgui() {
        Random rand = new Random();
        num = rand.nextInt(100) + 1;

        this.setTitle("猜数字游戏");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 200));

        zhumianban = new JPanel(new BorderLayout(5, 5));

        shurumianban = new JPanel(new FlowLayout(FlowLayout.LEFT));
        teshumianban = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        shuchumianban = new JPanel(new FlowLayout(FlowLayout.CENTER));
        zuozhemianban = new JPanel(new FlowLayout(FlowLayout.CENTER));

        shurubiaoqian = new JLabel("请输入一个1到100之间的数字：");
        caishubiaoqian = new JLabel("猜测次数：0");
        shuchubiaoqian = new JLabel("");
        shuruchuangkou = new JTextField(5);
        caishuanniu = new JButton("猜一猜");
        zuobianniu = new JButton("作弊");
        zuozheanniu = new JButton("打印作者信息");

        shurumianban.add(shurubiaoqian);
        shurumianban.add(shuruchuangkou);
        teshumianban.add(caishuanniu);
        teshumianban.add(zuobianniu);
        shuchumianban.add(caishubiaoqian);
        shuchumianban.add(shuchubiaoqian);
        zuozhemianban.add(zuozheanniu);

        zhumianban.add(shurumianban, BorderLayout.WEST);
        zhumianban.add(teshumianban, BorderLayout.EAST);
        zhumianban.add(shuchumianban, BorderLayout.SOUTH);
        zhumianban.add(zuozhemianban, BorderLayout.NORTH);

        this.getContentPane().add(zhumianban);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        setFont(new Font("微软雅黑", Font.PLAIN, 14));
        shurubiaoqian.setFont(new Font("微软雅黑", Font.BOLD, 14));
        shuruchuangkou.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        caishuanniu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        zuobianniu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        caishubiaoqian.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        shuchubiaoqian.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        zuozheanniu.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        caishuanniu.addActionListener(x -> {
            checkGuess();
            caishubiaoqian.setText("猜测次数：" + caishutmp + "     ");
        });
        zuobianniu.addActionListener(x -> {
            JOptionPane.showMessageDialog(this, "目标数是：" + num+ "   ");
        });
        zuozheanniu.addActionListener(x -> {
            JOptionPane.showMessageDialog(this, "范家瑞\nJava作业\n猜数游戏GUI实现");
        });
    }
    private void checkGuess() {
        try {
            int guess = Integer.parseInt(shuruchuangkou.getText());
            if (guess < 1 || guess > 100) {
                shuchubiaoqian.setText("输入超界了，请输入1到100之间的数字");
                return;
            }
            caishutmp++;
            if (guess < num) {
                shuchubiaoqian.setText(guess + "太小了，请再试一次。当前猜测区间：" + (guess + 1) + "到100");
            } else if (guess > num) {
                shuchubiaoqian.setText(guess + "太大了，请再试一次。当前猜测区间：1到" + (guess - 1));
            } else {
                shuchubiaoqian.setText("恭喜你，你猜对了！你一共猜了 " + caishutmp + " 次。");
                shuruchuangkou.setEditable(false);
                caishuanniu.setEnabled(false);
                zuobianniu.setEnabled(false);
            }
        } catch (NumberFormatException x) {
            shuchubiaoqian.setText("请输入一个有效的数字（1-100）");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(guessgui::new);
    }
}