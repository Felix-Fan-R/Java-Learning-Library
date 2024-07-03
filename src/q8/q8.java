package q8;

public class q8 {
    public static void main(String[] args) {
        // 创建Person对象
        Person person = new Person("AA", "**", "123-456-7890", "AA@example.com");
        System.out.print(person);

        // 创建Employee对象
        Employee employee = new Employee("BB", "**", "987-654-3210", "BB@example.com", "Office 101", 50000, "2023-01-01");
        System.out.print(employee);

        // 创建Faculty对象
        Faculty faculty = new Faculty("CC", "**", "555-555-5555", "CC@example.com", "Office 102", 60000, "2022-09-01", "博士", "专家");
        System.out.print(faculty);

        // 创建Staff对象
        Staff staff = new Staff("DD", "**", "444-444-4444", "DD@example.com", "Office 103", 45000, "2021-06-01", "工程师");
        System.out.print(staff);
    }
}
