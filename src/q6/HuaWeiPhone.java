package q6;

class HuaWeiPhone extends Phone implements IUsb {
    public HuaWeiPhone(double price) {
        super(price);
        this.brand = "HuaWei";
    }

    @Override
    public void print() {
        System.out.println("品牌: " + brand);
        System.out.println("价格: " + getPrice());
    }

    @Override
    public void read() {
        System.out.println("Reading data");
    }

    @Override
    public void write() {
        System.out.println("Writing data");
    }
}
