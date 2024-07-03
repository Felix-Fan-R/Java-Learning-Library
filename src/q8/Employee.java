package q8;

public class Employee extends Person {
    private String office;
    private double wage;
    private String hireDate;

    public Employee(String name, String address, String telephone, String email, String office, double wage, String hireDate) {
        super(name, address, telephone, email);
        this.office = office;
        this.wage = wage;
        this.hireDate = hireDate;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "办公室='" + office + '\'' + ", 工资=" + wage + ", 受雇日期='" + hireDate + '\'' +
                "} " + super.toString();
    }
}
