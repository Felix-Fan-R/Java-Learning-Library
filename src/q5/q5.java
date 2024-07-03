package q5;
/*
定义一个抽象类立方体（Cube），其中包含两个抽象方法 getVolume 和getSurfaceArea，用于计算不同形状的体积和表面积。
接着，定义两个子类球体（Sphere）和圆锥(Cone)，
两个子类都继承自抽象类 Cube，并重写父类的方法getVolume 和 getSurfaceArea，
用来计算不同形状图形的体积和表面积。
 */
class Cube {
    double getVolume() {
        return 0;
    }

    double getSurfaceArea() {
        return 0;
    }
}

class Sphere extends Cube {
    double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}

class Cone extends Cube {
    double radius;
    double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double getSurfaceArea() {
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        return Math.PI * radius * (radius + slantHeight);
    }
}

public class q5 {
    public static void main(String[] args) {
        Cube sphere = new Sphere(5);
        Cube cone = new Cone(3, 7);

        System.out.println("球体体积: " + sphere.getVolume());
        System.out.println("球体表面积: " + sphere.getSurfaceArea());

        System.out.println("圆锥体积: " + cone.getVolume());
        System.out.println("圆锥表面积: " + cone.getSurfaceArea());
    }
}
