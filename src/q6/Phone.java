package q6;

abstract class Phone {
    private double price;
    public String brand;
    public Phone(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public abstract void print();
}

