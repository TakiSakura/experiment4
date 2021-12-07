# 实验四 学生实验室勤工俭学模拟

## 一、实验目的

* 掌握Java中类的定义；
* 掌握static
* final等修饰符的用法；
* 了解异常的使用方法，并在程序中根据输入情况做异常处理

## 二、实验内容

某学校为了给学生提供勤工俭学机会，选派了部分学生参与实验室的卫生清洁工作。每个学生被分配若干间实验室，视实验室的清洁打分情况给予劳务补贴。\
例如：
学生“张三”负责了“计算机网络实验室”、“组成原理实验室”的清洁情况，每周被检查。在某次检查中，“计算机网络实验室”卫生得“优”，“组成原理实验室”卫生得“及格”，一次“优”按x元记录补助，一次“及格”按y元记录补助。（卫生标准分级、相应的等级补助标准，自行规定）\
按国家的税务制度，劳务费应按国家规定纳税，请统计一学期学生的实际收入。（国家最新工资纳税标准，请自行检索）。
---

### 基本要求

1. 设计系统中的类（如 学生、实验室等等）；
2. 一学期按18周计；
3. 每个学生负责的实验室数量不一定相同；
4. 对学期勤工俭学收入和纳税进行统计，求得实际收入；
5. 国家最新纳税标准（系数），属于某一时期的特定固定值，与实例化对象没有关系，考虑如何用static final修饰定义。
6. 根据处理情况，要在程序中考虑做异常处理。

## 三、解题思路

这次的勤工俭学系统，先确定好所用的类与对象。分别会有实验室和学生，还有用来计算税费的方法。\
因为一个学生会有多个实验室，所以说我想到了使用列表。在学生类创建一个实验室数组，然后将各个实验室列表分配给学生。\
实验室的评级我想到了两种办法来解决。一种是二维数组。一共有十个实验室，周数有18周，创建好二维数组后，自己填写优良等级，然后再用for循环去遍历列表；
另一种办法是随机生成0～1之间的数，然后用if语句对数字进行判断小于0.3为优，0.3到0.6为良，0.6到1为及格，然后写入各个实验室中，最后再遍历列表。\
实验室得到评级后，接下来的工作就是如何将每个学生所负责的实验室的评级转化为学生能得到多少钱。\
这里我用的是用了两个方法，分别是rankSalary和setSalary。两个的作用分别是将实验室的等级转化为能得到的工资。然后再调用setSalary，目的是salary+=salary。\
现在所得到的工资并不是实际工资，应按照国家标准扣税后，才是实际工资。

## 四、关键代码

1.创建的实验室类的列表和如何设置属性的方法

```
public Lab[] labList = new Lab[10];
public void setLibList(Lab[] labList) {
        this.labList = labList;
    }
```

2.实例化列表，并将列表分配给各个学生

```
Lab[] allList = new Lab[]{lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10};
        Lab[] labList1 = new Lab[]{lab1, lab2, lab3};
        Lab[] labList2 = new Lab[]{lab4, lab5, lab6};
        Lab[] labList3 = new Lab[]{lab7, lab8};
        Lab[] labList4 = new Lab[]{lab9, lab10};

        stu1.setLibList(labList1);
        stu2.setLibList(labList2);
        stu3.setLibList(labList3);
        stu4.setLibList(labList4);
```

3、随机生成评分等级的方法

```
public void setRank() {
        this.rank = Math.random();
    }
```

4.调用方法，对实验室进行评级

```
for (Lab j : allList) {
                j.setRank();
            }
```

5.将随机数转化为工资，和将工资添加到学生总工资的两个方法

```
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
```

```
public void setRank() {
        this.rank = Math.random();
    }
```

6.上述三个方法用循环进行调用

```
for (int week = 0; week < 18; week++) {
            for (Lab j : allList) {
                j.setRank();
            }
            for (Lab i : stu1.labList) {
                stu1.setSalary(stu1.RankSalary(i.rank));
            }
            for (Lab i : stu2.labList) {
                stu2.setSalary(stu2.RankSalary(i.rank));
            }
            for (Lab i : stu3.labList) {
                stu3.setSalary(stu3.RankSalary(i.rank));
            }
            for (Lab i : stu4.labList) {
                stu4.setSalary(stu4.RankSalary(i.rank));
            }
```

7.对学生的收入，按照国际标准进行扣税

```
stu1.texesSalary = stu1.TaxDeduction(stu1.salary);
        stu2.texesSalary = stu2.TaxDeduction(stu2.salary);
        stu3.texesSalary = stu3.TaxDeduction(stu3.salary);
        stu4.texesSalary = stu4.TaxDeduction(stu4.salary);
```

## 五、运行结果截图
![截图](https://github.com/TakiSakura/experiment4/blob/47e46e57ca22ea2d57205bea52423f58fade31bf/%E6%88%AA%E5%B1%8F2021-12-07%20%E4%B8%8B%E5%8D%882.00.15.png)
## 六、心得体会
每次的实验上机，都能发现自己的不足，经过实践后，总结经验，能有很大的提升。我对列表使用更加熟练了，尝试在程序中添加static和final进行使用
* 在上次实验中，我对列表有了初步地认识。在这次上机我尝试在列表中添加了更多的元素。发现可以用for循环去遍历列表。我意识到在处理许多相同类型的东西时，使用列表能节省大量时间。
* 我发现java中用return返回值的时候。可以在return后可以使用switch语句。我认为这样的语句在以后有很大的用处
* 在税费的方法里用到了static和final。因为这个标准在程序中只会调用final的值，不能进行更改。而且国家标准也会变化，设为static方便后续修改。让我对这两个修饰词知道如何去使用
