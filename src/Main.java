import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

// 用户类型枚举
enum UserType {
    ADMIN, // 管理员用户类型
    USER   // 普通用户类型
}

// 用户类
class User {
    private String username; // 用户名
    private String password; // 密码
    private UserType type;   // 用户类型

    // 用户类构造函数
    public User(String username, String password, UserType type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    // 获取用户名
    public String getUsername() {
        return username;
    }

    // 获取密码
    public String getPassword() {
        return password;
    }

    // 获取用户类型
    public UserType getType() {
        return type;
    }
}

// 垃圾分类信息类
class Garbage {
    private String name;     // 垃圾名称
    private String category; // 垃圾分类

    // 垃圾分类信息类构造函数
    public Garbage(String name, String category) {
        this.name = name;
        this.category = category;
    }

    // 获取垃圾名称
    public String getName() {
        return name;
    }

    // 获取垃圾分类
    public String getCategory() {
        return category;
    }

    // 设置垃圾分类
    public void setCategory(String category) {
        this.category = category;
    }

    // 重写toString方法，方便打印垃圾信息
    @Override
    public String toString() {
        return "垃圾名称：" + name + "，垃圾分类：" + category;
    }
}

// 系统管理类
class GarbageManagement {
    private Map<String, Garbage> garbageMap; // 垃圾信息映射表

    // 系统管理类构造函数
    public GarbageManagement() {
        this.garbageMap = new HashMap<>(); // 初始化垃圾信息映射表
        // 在构造函数中可以初始化一些默认的垃圾分类信息
        garbageMap.put("苹果核", new Garbage("苹果核", "有害垃圾"));
        garbageMap.put("纸张", new Garbage("纸张", "可回收垃圾"));
        garbageMap.put("菜叶", new Garbage("菜叶", "厨余垃圾"));
    }

    // 添加垃圾分类信息
    public void addGarbage(String name, String category) {
        garbageMap.put(name, new Garbage(name, category));
    }

    // 删除垃圾分类信息
    public void deleteGarbage(String name) {
        garbageMap.remove(name);
    }

    // 修改垃圾分类信息
    public void updateGarbage(String name, String category) {
        if (garbageMap.containsKey(name)) {
            garbageMap.get(name).setCategory(category);
        } else {
            System.out.println("垃圾分类信息不存在");
        }
    }

    // 查询垃圾分类信息
    public Garbage queryGarbage(String name) {
        return garbageMap.get(name);
    }

    // 获取所有垃圾信息
    public Map<String, Garbage> getAllGarbage() {
        return garbageMap;
    }
}