package workStudy;

public class Lab extends Week {
    final String name;
    String rank;

    public Lab(String name) {
        this.name = name;
    }

    public void setRank(int p, int q) {
        this.rank = ScoreSheet[p][q];
    }
}
