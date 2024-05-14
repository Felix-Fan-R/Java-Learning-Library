import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TeamMembers {

    public static void showTeamMembersPage() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 20, 20)); // Increased gap between panels
        panel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Increased border

        panel.add(createMemberPanel("范家瑞", "C:/Users/xxlang/Desktop/java/Java-Learning-Library/javateamwork/untitled/img/2.jpg"));
        panel.add(createMemberPanel("龙宇翔", "C:/Users/xxlang/Desktop/java/Java-Learning-Library/javateamwork/untitled/img/3.jpg"));
        panel.add(createMemberPanel("张树珍", "C:/Users/xxlang/Desktop/java/Java-Learning-Library/javateamwork/untitled/img/5.jpg"));
        panel.add(createMemberPanel("刘念念", "C:/Users/xxlang/Desktop/java/Java-Learning-Library/javateamwork/untitled/img/4.jpg"));

        JOptionPane.showMessageDialog(null, panel, "团队成员", JOptionPane.INFORMATION_MESSAGE);
    }

    private static JPanel createMemberPanel(String memberName, String imageName) {
        JPanel memberPanel = new JPanel();
        memberPanel.setLayout(new BorderLayout());
        memberPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel(memberName);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        memberPanel.add(nameLabel, BorderLayout.SOUTH);

        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loadImage(imageLabel, imageName);
        memberPanel.add(imageLabel, BorderLayout.CENTER);

        return memberPanel;
    }

    private static void loadImage(JLabel label, String imagePath) {
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            Image scaledImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            label.setIcon(scaledIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            TeamMembers teamMembers = new TeamMembers();
            teamMembers.showTeamMembersPage();
    }
}
