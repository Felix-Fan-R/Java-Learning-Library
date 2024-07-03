package q8;

public class Person {
    private String name;
    private String address;
    private String telephone;
    private String email;
    public Person(String name, String address, String telephone, String email) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }
    @Override
    public String toString() {
        return   '\n'+ "Person{" +
                "姓名='" + name + '\'' + ", 地址='" + address + '\'' + ", 电话='" + telephone + '\'' + ", 邮件='" + email + '\'' +
                '}';
    }
}
