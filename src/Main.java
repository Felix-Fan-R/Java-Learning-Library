import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

// 用户类型枚举
enum UserType {
    ADMIN,
    USER
}

// 用户类
class User {
    private String username;
    private String password;
    private UserType type;

    public User(String username, String password, UserType type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

}

class Garbage {
    private String name;
    private String category;

    public Garbage(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "垃圾名称：" + name + "，垃圾分类：" + category;
    }
}

class GarbageManagement {
    private Map<String, Garbage> garbageMap;

    // 系统管理类构造函数
    public GarbageManagement() {
        this.garbageMap = new HashMap<>();
        garbageMap.put("苹果核", new Garbage("苹果核", "有害垃圾"));
        garbageMap.put("纸张", new Garbage("纸张", "可回收垃圾"));
        garbageMap.put("菜叶", new Garbage("菜叶", "厨余垃圾"));
    }

    public void addGarbage(String name, String category) {
        garbageMap.put(name, new Garbage(name, category));
    }

    public void deleteGarbage(String name) {
        garbageMap.remove(name);
    }

    public void updateGarbage(String name, String category) {
        if (garbageMap.containsKey(name)) {
            garbageMap.get(name).setCategory(category);
        } else {
            System.out.println("垃圾分类信息不存在");
        }
    }

    public Garbage queryGarbage(String name) {
        return garbageMap.get(name);
    }
}