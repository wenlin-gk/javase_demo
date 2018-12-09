package model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
  private String no;
  private List<Student> stus;
  private double totalScore;

  public Classroom(String no) {
    super();
    this.no = no;
    this.stus = new ArrayList<Student>();
    this.totalScore = 0;
  }

  public String getNo() {
    return no;
  }

  public void setNo(String no) {
    this.no = no;
  }

  public List<Student> getStus() {
    return stus;
  }

  public void setStus(List<Student> stus) {
    this.stus = stus;
  }

  public double getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(double totalScore) {
    this.totalScore = totalScore;
  }
}
