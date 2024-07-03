package q8;

public class Staff extends Employee {
    private String duty;

    public Staff(String name, String address, String telephone, String email, String office, double wage, String hireDate, String duty) {
        super(name, address, telephone, email, office, wage, hireDate);
        this.duty = duty;
    }
    @Override
    public String toString() {
        return "Staff{" +
                "职务称号='" + duty + '\'' +
                "} " + super.toString();
    }
}
