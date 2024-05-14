
class Garbage {
    public enum GarbageType {
        可回收垃圾,
        厨房垃圾,
        有害垃圾,
        医疗废物,
        其他垃圾
    }
    private final String name;
    private final GarbageType type;
    public Garbage(String name, GarbageType type) {
        this.name = name;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public GarbageType getType() {
        return type;
    }
}
