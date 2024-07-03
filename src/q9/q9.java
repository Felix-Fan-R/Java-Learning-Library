package q9;

public class q9 {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();

        double carSpeed = 80;
        double carTime = 2;

        double bicycleSpeed = 15;
        double bicycleTime = 1.5;

        double carDistance = car.longlong(carSpeed, carTime);
        double bicycleDistance = bicycle.longlong(bicycleSpeed, bicycleTime);

        System.out.println("车距离: " + carDistance + " km");
        System.out.println("自行车距离: " + bicycleDistance + " km");
    }
}
