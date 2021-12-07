package workStudy;

public class Student extends Taxes {
    public Lab[] labList = new Lab[10];
    final String name;
    double salary;

    public Student(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public void setLibList(Lab[] labList) {
        this.labList = labList;
    }

    public double RankSalary(String rank) {
        return switch (rank) {
            case "优" -> 1000;
            case "良" -> 500;
            case "及格" -> 250;
            default -> 0;
        };

    }
}