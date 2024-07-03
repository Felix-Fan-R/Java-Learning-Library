package q10;

public class q10 {
    public static void main(String[] args) {
        FruitManager manager = new FruitManager();


        System.out.println("Initial fruits:");
        manager.getAllFruits();


        manager.addFruit("葡萄", 6.0);
        System.out.println("\nAfter adding 葡萄:");
        manager.getAllFruits();


        manager.updateFruit(1, "红苹果", 5.5);
        System.out.println("\nAfter updating 苹果 to 红苹果:");
        manager.getAllFruits();


        manager.deleteFruit(2);
        System.out.println("\nAfter deleting 梨:");
        manager.getAllFruits();
    }
}
