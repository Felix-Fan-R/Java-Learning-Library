package q8;

public class Faculty extends Employee {
    private String degree;
    private String level;

    public Faculty(String name, String address, String telephone, String email, String office, double wage, String hireDate, String degree, String level) {
        super(name, address, telephone, email, office, wage, hireDate);
        this.degree = degree;
        this.level = level;
    }
    @Override
    public String toString() {
        return "Faculty{" +
                "学位='" + degree + '\'' + ", 级别='" + level + '\'' +
                "} " + super.toString();
    }
}
