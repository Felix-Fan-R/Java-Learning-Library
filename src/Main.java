import java.io.*;
import java.nio.file.*;
import java.util.*;
enum GarbageType {
    可回收垃圾,
    厨房垃圾,
    有害垃圾,
    医疗废物,
    其他垃圾
}
class Garbage {//垃圾
    private final String name;
    private final GarbageType type;
    public Garbage(String name,GarbageType type) {
        this.name = name;
        this.type = type;
    }
    public GarbageType getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "垃圾名称：" + name + "，垃圾分类：" + type.name();
    }
    public String serialize() {
        return name + ":" + type.name();
    }
    public static Garbage deserialize(String data) {
        String[] parts = data.split(":");
        if (parts.length == 2) {
            return new Garbage(parts[0], GarbageType.valueOf(parts[1]));
        }
        return null;
    }
}
class GarbageManagement {//垃圾管理
    private static final String GARBAGE_FILE = "garbage.txt";
    private final Map<String, Garbage> garbageMap = new HashMap<>(); //

    public GarbageManagement() {
        loadGarbageFromFile();
    }
    private void loadGarbageFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(GARBAGE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Garbage garbage = Garbage.deserialize(line);
                if (garbage != null) {
                    garbageMap.put(garbage.getName(), garbage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveGarbageToFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(GARBAGE_FILE))) {
            for (Garbage garbage : garbageMap.values()) {
                writer.write(garbage.serialize());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Garbage> getGarbageList() {
        return new ArrayList<>(garbageMap.values());
    }
    public void addGarbage(String name, GarbageType type) {
        Garbage garbage = new Garbage(name, type);
        garbageMap.put(name, garbage);
        saveGarbageToFile();
    }
    public void deleteGarbage(String name) {
        garbageMap.remove(name);
        saveGarbageToFile();
    }

    public Garbage queryGarbage(String name) {
        return garbageMap.get(name);
    }
}