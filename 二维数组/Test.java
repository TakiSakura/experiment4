package workStudy;

public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student("张三");
        Student stu2 = new Student("李四");
        Student stu3 = new Student("王五");
        Student stu4 = new Student("老六");

        Lab lab1 = new Lab("计算机网络实验室");
        Lab lab2 = new Lab("组成原理实验室");
        Lab lab3 = new Lab("化工仿真实训实验室");
        Lab lab4 = new Lab("仪器分析实验室");
        Lab lab5 = new Lab("傅立叶—红外光谱室");
        Lab lab6 = new Lab("X射线粉末衍射仪室");
        Lab lab7 = new Lab("精细化学品的合成实验室");
        Lab lab8 = new Lab("化工热力学实验室");
        Lab lab9 = new Lab("化工仪表及自动化实验室");
        Lab lab10 = new Lab("催化动力学实验室");

        Lab[] allList = new Lab[]{lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10};
        Lab[] labList1 = new Lab[]{lab1, lab2, lab3};
        Lab[] labList2 = new Lab[]{lab4, lab5, lab6};
        Lab[] labList3 = new Lab[]{lab7, lab8};
        Lab[] labList4 = new Lab[]{lab9, lab10};

        stu1.setLibList(labList1);
        stu2.setLibList(labList2);
        stu3.setLibList(labList3);
        stu4.setLibList(labList4);

        for (int week = 0; week < 18; week++) {
            int labNum = 0;
            for (Lab j : allList) {
                j.setRank(week, labNum);
                labNum++;
            }
            for (Lab i : stu1.labList) {
                stu1.setSalary(stu1.RankSalary(i.rank));
            }
            for (Lab i : stu2.labList) {
                stu2.setSalary(stu2.RankSalary(i.rank));
            }
            for (Lab i : stu3.labList) {
                stu3.setSalary(stu2.RankSalary(i.rank));
            }
            for (Lab i : stu4.labList) {
                stu4.setSalary(stu2.RankSalary(i.rank));
            }

        }
        stu1.salary = stu1.TaxDeduction(stu1.salary);
        stu2.salary = stu2.TaxDeduction(stu2.salary);
        stu3.salary = stu3.TaxDeduction(stu3.salary);
        stu4.salary = stu4.TaxDeduction(stu4.salary);

        System.out.println("学生" + stu1.name + "的年终收入为:" + stu1.salary);
        System.out.println("学生" + stu2.name + "的年终收入为:" + stu2.salary);
        System.out.println("学生" + stu3.name + "的年终收入为:" + stu3.salary);
        System.out.println("学生" + stu4.name + "的年终收入为:" + stu4.salary);
        double ran2 = (Math.random());
        System.out.println(ran2);
    }

}
