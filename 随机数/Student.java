package workStudy;

public class Student extends Taxes {
    final String name;
    public Lab[] labList = new Lab[10];
    double salary;
    double texes;
    double texesSalary;

    public Student(String name) {
        this.name = name;
    }

    public double getTexes() {
        texes = salary - texesSalary;
        return texes;
    }

    public void setSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public void setLibList(Lab[] labList) {
        this.labList = labList;
    }

    public double RankSalary(double rank) {
        if (rank < 0.3) {
            rank = 1;
        }
        if (rank < 0.6) {
            rank = 2;
        }
        if (rank < 1) {
            rank = 3;
        }
        return switch ((int) rank) {
            case 1 -> 1000;
            case 2 -> 500;
            case 3 -> 250;
            default -> 0;
        };
    }
}


