import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

public class AllGUI {
    static void showGUI() {
        JFrame frame = new JFrame("垃圾分类宣传系统");
        JPanel panel = new Utility.JPanelWithBackground("C:/Users/xxlang/Desktop/java/Java-Learning-Library/javateamwork/untitled/img/1.jpeg");

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        WelcomeGUI(panel);
        Utility.centerWindow(frame);
        frame.setVisible(true);
    }

    static void WelcomeGUI(JPanel panel) {
        panel.setLayout(null);
        JLabel welcomeLabel = new JLabel("欢迎来到垃圾分类宣传系统");
        JButton userLoginButton = new JButton("用户登录");
        JButton adminLoginButton = new JButton("管理员登录");

        welcomeLabel.setBounds(70, 70, 300, 25);
        userLoginButton.setBounds(70, 150, 120, 25);
        adminLoginButton.setBounds(200, 150, 120, 25);
        welcomeLabel.setFont(new Font("仿宋", Font.BOLD, 21));
        Utility.makeButton(userLoginButton);
        Utility.makeButton(adminLoginButton);

        welcomeLabel.setForeground(Color.WHITE);

        userLoginButton.addActionListener(e -> {
            panel.removeAll();
            LoginGUI(panel, false);
            panel.revalidate();
            panel.repaint();
        });
        adminLoginButton.addActionListener(e -> {
            panel.removeAll();
            LoginGUI(panel, true);
            panel.revalidate();
            panel.repaint();
        });

        panel.add(welcomeLabel);
        panel.add(userLoginButton);
        panel.add(adminLoginButton);
    }

    protected static void LoginGUI(JPanel panel, boolean isAdminLogin) {
        panel.setLayout(null);
        JLabel usernameLabel = new JLabel("用户名:");
        JTextField usernameText = new JTextField(16);
        JLabel passwordLabel = new JLabel("密码:");
        JPasswordField passwordText = new JPasswordField(16);
        JButton loginButton = new JButton("登录");

        usernameLabel.setBounds(80, 60, 80, 25);
        usernameText.setBounds(140, 60, 165, 25);
        passwordLabel.setBounds(80, 90, 80, 25);
        passwordText.setBounds(140, 90, 165, 25);
        loginButton.setBounds(140, 130, 100, 35);
        loginButton.setFont(new Font("仿宋", Font.BOLD, 21));

        if (!isAdminLogin) {
            JButton registerButton = new JButton("注册");
            JButton forgotPasswordButton = new JButton("忘记密码");
            JButton aboutButton = new JButton("制作者");

            registerButton.setBounds(80, 180, 80, 25);
            forgotPasswordButton.setBounds(210, 180, 100, 25);
            aboutButton.setBounds(290, 220, 80, 25);

            Utility.makeButton(registerButton);
            Utility.makeButton(forgotPasswordButton);
            Utility.makeButton(aboutButton);

            registerButton.addActionListener(e -> RegisterGUI());
            forgotPasswordButton.addActionListener(e -> UserManagement.forgotPassword());
            aboutButton.addActionListener(AllGUI::actionPerformed);

            panel.add(registerButton);
            panel.add(forgotPasswordButton);
            panel.add(aboutButton);
        }

        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        Utility.makeButton(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameText.getText();
            String password = new String(passwordText.getPassword());
            if (isAdminLogin) {
                if (Utility.adminLogin(username, password)) {
                    AdminGUI();
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或密码错误", "登录失败", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (Utility.userLogin(username, password)) {
                    UserGUI();
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或密码错误", "登录失败", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(loginButton);
    }


     static void RegisterGUI() {
        JDialog registerDialog = new JDialog((JFrame) null, "注册", true);
        JLabel usernameLabel = new JLabel("用户名:");
        JLabel passwordLabel = new JLabel("密码:");
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton registerButton = new JButton("注册");
        JPanel panel = new Utility.JPanelWithBackground("C:/Users/xxlang/Desktop/java/Java-Learning-Library/javateamwork/untitled/img/1.jpeg");
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);

        panel.setLayout(null);

        registerDialog.setSize(300, 200);
        usernameLabel.setBounds(10, 20, 80, 25);
        usernameField.setBounds(100, 20, 160, 25);
        passwordLabel.setBounds(10, 50, 80, 25);
        passwordField.setBounds(100, 50, 160, 25);
        registerButton.setBounds(110, 90, 80, 30);
        registerButton.setFont(new Font("仿宋", Font.BOLD, 21));
        Utility.makeButton(registerButton);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (UserManagement.registerUser(username, password)) {
                JOptionPane.showMessageDialog(registerDialog, "注册成功！");
                registerDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(registerDialog, "注册失败，请重试！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        Utility.centerWindow(registerDialog);
        registerDialog.add(panel);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);
        registerDialog.setVisible(true);
    }

    protected static void AdminGUI() {
        JFrame adminFrame = new JFrame("管理员界面");
        JPanel panel = new Utility.JPanelWithBackground("C:/Users/xxlang/Desktop/java/Java-Learning-Library/javateamwork/untitled/img/1.jpeg");

        JButton addButton = new JButton("添加");
        JButton deleteButton = new JButton("删除");
        JButton overviewButton = new JButton("总览");
        JButton logoutButton = new JButton("退出");
        JButton usersButton = new JButton("用户信息管理（未实装）");
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"可回收垃圾", "厨房垃圾", "有害垃圾", "医疗废物", "其他垃圾"});

        adminFrame.setSize(400, 300);
        addButton.setFont(new Font("仿宋", Font.BOLD, 28));
        deleteButton.setFont(new Font("仿宋", Font.BOLD, 28));
        addButton.setBounds(70, 70, 100, 50);
        deleteButton.setBounds(200, 70, 100, 50);
        usersButton.setBounds(200, 160, 180, 30);
        logoutButton.setBounds(290, 200, 80, 25);
        overviewButton.setBounds(30, 200, 80, 25);
        typeComboBox.setBounds(30, 110, 165, 25);

        Utility.makeButton(addButton);
        Utility.makeButton(deleteButton);
        Utility.makeButton(logoutButton);
        Utility.makeButton(usersButton);
        Utility.makeButton(overviewButton);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        logoutButton.addActionListener(e -> adminFrame.dispose());
        usersButton.addActionListener(e -> JOptionPane.showMessageDialog(adminFrame, "该功能还未实装哦，请等待下个版本", "用户信息管理", JOptionPane.INFORMATION_MESSAGE));
        overviewButton.addActionListener(e -> showGarbage());
        addButton.addActionListener(e -> AddGarbageGUI());
        deleteButton.addActionListener(e -> DeleteGUI());

        adminFrame.add(panel);
        panel.setLayout(null);
        panel.add(overviewButton);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(usersButton);
        panel.add(logoutButton);

        Utility.centerWindow(adminFrame);
        adminFrame.setVisible(true);
    }

    static void UserGUI() {
        JFrame userFrame = new JFrame("普通用户界面");
        JLabel nameLabel = new JLabel("垃圾名称:");
        JTextField nameText = new JTextField(20);
        JButton queryButton = new JButton("查询");
        JButton promoteButton = new JButton("宣传垃圾分类信息");
        JButton logoutButton = new JButton("退出");
        JButton overviewButton = new JButton("总览");
        JButton searchByTypeButton = new JButton("按类型查找");

        JPanel panel = new Utility.JPanelWithBackground("C:/Users/xxlang/Desktop/java/Java-Learning-Library/javateamwork/untitled/img/1.jpeg");

        overviewButton.setBounds(100, 180, 80, 25);
        nameLabel.setBounds(20, 30, 80, 25);
        nameLabel.setFont(new Font("仿宋", Font.BOLD, 16));
        nameText.setBounds(120, 30, 165, 25);
        queryButton.setBounds(280, 30, 80, 25);
        queryButton.setFont(new Font("仿宋", Font.BOLD, 18));
        searchByTypeButton.setBounds(90, 80, 200, 30);
        searchByTypeButton.setFont(new Font("仿宋", Font.BOLD, 18));
        userFrame.setSize(400, 300);
        promoteButton.setBounds(90, 130, 200, 25);
        promoteButton.setFont(new Font("仿宋", Font.BOLD, 18));
        logoutButton.setBounds(190, 180, 80, 25);

        Utility.makeButton(searchByTypeButton);
        Utility.makeButton(queryButton);
        Utility.makeButton(promoteButton);
        Utility.makeButton(logoutButton);
        Utility.makeButton(overviewButton);
        nameLabel.setForeground(Color.WHITE);

        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        logoutButton.addActionListener(e -> userFrame.dispose());
        overviewButton.addActionListener(e -> showGarbage());
        searchByTypeButton.addActionListener(e -> {
            JDialog searchByTypeDialog = new JDialog(userFrame, "按类型查找", true);
            JPanel searchPanel = new JPanel();
            JLabel typeLabel = new JLabel("选择垃圾类型:");
            JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"可回收垃圾", "厨房垃圾", "有害垃圾", "医疗废物", "其他垃圾"});
            JButton searchButton = new JButton("查找");
            Utility.centerWindow(searchByTypeDialog);
            typeLabel.setBounds(10, 10, 120, 25);
            typeComboBox.setBounds(140, 10, 150, 25);
            searchButton.setBounds(10, 50, 120, 25);
            searchButton.addActionListener(event -> {
                String selectedType = (String) typeComboBox.getSelectedItem();
                List<Garbage> garbageList = GarbageManagement.getGarbageByType(selectedType);
                showGarbageByTypeDialog(garbageList, userFrame);
            });

            searchPanel.setLayout(null);
            searchPanel.add(typeLabel);
            searchPanel.add(typeComboBox);
            searchPanel.add(searchButton);
            searchByTypeDialog.add(searchPanel);
            searchByTypeDialog.setSize(300, 200);
            searchByTypeDialog.setVisible(true);
        });


        queryButton.addActionListener(e -> {
            String searchText = nameText.getText();
            List<Garbage> garbageList = GarbageManagement.queryGarbageFuzzy(searchText);
            if (!garbageList.isEmpty()) {
                StringBuilder message = new StringBuilder();
                for (Garbage garbage : garbageList) {
                    message.append("垃圾名称：").append(garbage.getName()).append(", 类型：").append(garbage.getType().name()).append("\n");
                }
                JOptionPane.showMessageDialog(null, message.toString(), "查询结果", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "未找到与\"" + searchText + "\"相关的垃圾分类信息", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        promoteButton.addActionListener(e -> {
        List<Garbage> garbageList = GarbageManagement.getAllGarbage();
        if (!garbageList.isEmpty()) {
            Random random = new Random();
            Garbage randomGarbage = garbageList.get(random.nextInt(garbageList.size()));
            String qrContent = "每日垃圾小知识：" + randomGarbage.getName() + "是"+randomGarbage.getType()+"哦";
            BufferedImage qrImage = QRcodeimage.QRCodeImage(qrContent);
            if (qrImage != null) {
                JLabel qrLabel = new JLabel(new ImageIcon(qrImage));
                JOptionPane.showMessageDialog(null, qrLabel, "宣传信息", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "数据库中没有垃圾信息", "错误", JOptionPane.ERROR_MESSAGE);
        }
        });
//        promoteButton.addActionListener(e -> {
//            Garbage garbage = GarbageManagement.queryGarbage(nameText.getText());
//            if (garbage != null) {
//                JOptionPane.showMessageDialog(null, "请把垃圾投放到：" + garbage.getType().name(), "宣传信息", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, "未找到该垃圾分类信息", "错误", JOptionPane.ERROR_MESSAGE);
//            }
//        });

        userFrame.add(panel);
        panel.setLayout(null);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(queryButton);
        panel.add(promoteButton);
        panel.add(logoutButton);
        panel.add(overviewButton);
        panel.add(searchByTypeButton);

        Utility.centerWindow(userFrame);
        userFrame.setVisible(true);
    }



     static void AddGarbageGUI() {
        JDialog addDialog = new JDialog((JFrame) null, "添加垃圾信息", true);
        JLabel nameLabel = new JLabel("垃圾名称:");
        JLabel typeLabel = new JLabel("垃圾类型:");
        JTextField nameText = new JTextField(20);
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"可回收垃圾", "厨房垃圾", "有害垃圾", "医疗废物", "其他垃圾"});
        JButton addButton = new JButton("添加");
        JPanel panel = new JPanel();

        addDialog.setSize(300, 200);
        nameLabel.setBounds(10, 20, 80, 25);
        nameText.setBounds(100, 20, 160, 25);
        typeLabel.setBounds(10, 50, 80, 25);
        typeComboBox.setBounds(100, 50, 160, 25);
        addButton.setBounds(120, 80, 80, 30);

        addButton.addActionListener(e -> {
            String name = nameText.getText();
            String type = (String) typeComboBox.getSelectedItem();
            if (GarbageManagement.addGarbage(name, type)) {
                JOptionPane.showMessageDialog(addDialog, "添加成功！");
                addDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(addDialog, "添加失败，请重试！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        Utility.centerWindow(addDialog);
        addDialog.add(panel);
        panel.setLayout(null);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(typeLabel);
        panel.add(typeComboBox);
        panel.add(addButton);
        addDialog.setVisible(true);
    }

     static void showGarbage() {
        JDialog garbageDialog = new JDialog((JFrame) null, "垃圾信息总览", true);
        String[] columnNames = {"垃圾名称", "垃圾类型"};
        List<Garbage> garbageList = GarbageManagement.getAllGarbage();
        Object[][] data = new Object[garbageList.size()][2];

        for (int i = 0; i < garbageList.size(); i++) {
            Garbage garbage = garbageList.get(i);
            data[i][0] = garbage.getName();
            data[i][1] = garbage.getType().name();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        garbageDialog.setSize(400, 300);
        garbageDialog.add(scrollPane);
        Utility.centerWindow(garbageDialog);
        garbageDialog.setVisible(true);
    }
    static void showGarbageByTypeDialog(List<Garbage> garbageList, JFrame userFrame) {
        if (!garbageList.isEmpty()) {
            String[] columnNames = {"垃圾名称", "垃圾类型"};
            Object[][] data = new Object[garbageList.size()][2];
            for (int i = 0; i < garbageList.size(); i++) {
                Garbage garbage = garbageList.get(i);
                data[i][0] = garbage.getName();
                data[i][1] = garbage.getType().name();
            }
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            JDialog searchByTypeDialog = new JDialog(userFrame, "按类型查找结果", true);
            searchByTypeDialog.setPreferredSize(new Dimension(420, 300));
            JPanel tablePanel = new JPanel();
            tablePanel.setLayout(null);
            tablePanel.add(scrollPane);
            scrollPane.setBounds(10, 10, 380, 250);
            searchByTypeDialog.add(tablePanel);
            searchByTypeDialog.pack();
            searchByTypeDialog.setLocationRelativeTo(userFrame);
            searchByTypeDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "未找到该类型的垃圾信息", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
     static void DeleteGUI() {
        JDialog deleteDialog = new JDialog((JFrame) null, "删除垃圾信息", true);
        JPanel panel = new Utility.JPanelWithBackground("C:/Users/xxlang/Desktop/java/Java-Learning-Library/javateamwork/untitled/img/1.jpeg");

        panel.setLayout(new BorderLayout());

        List<Garbage> garbageList = GarbageManagement.getAllGarbage();
        String[] columnNames = {"垃圾名称", "垃圾类型"};
        Object[][] data = new Object[garbageList.size()][2];

        for (int i = 0; i < garbageList.size(); i++) {
            Garbage garbage = garbageList.get(i);
            data[i][0] = garbage.getName();
            data[i][1] = garbage.getType().name();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel inputPanel = new JPanel();
        JLabel nameLabel = new JLabel("垃圾名称:");
        JTextField nameText = new JTextField(20);
        JButton deleteButton = new JButton("删除");

        inputPanel.add(nameLabel);
        inputPanel.add(nameText);
        inputPanel.add(deleteButton);

        deleteButton.addActionListener(e -> {
            String name = nameText.getText();
            if (GarbageManagement.deleteGarbage(new Garbage(name, null))) {
                JOptionPane.showMessageDialog(deleteDialog, "删除成功！");
                deleteDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(deleteDialog, "删除失败，请重试！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.SOUTH);

        deleteDialog.setSize(400, 300);
        deleteDialog.add(panel);
        Utility.centerWindow(deleteDialog);
        deleteDialog.setVisible(true);
    }

    private static void actionPerformed(ActionEvent e) {
        TeamMembers.showTeamMembersPage();
    }
}
