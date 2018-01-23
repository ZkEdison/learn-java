package fapiDay01;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 保存每个员工信息
 */
public class Emp {
    private String name;
    private int age;
    private String gender;
    private int salary;
    private Date hireDate;

    public Emp() {
    }

    public Emp(String name, int age, String gender, int salary, Date hireDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + gender + "," + salary + "," +  new SimpleDateFormat("yyyy-MM-dd").format(hireDate);
    }
}
