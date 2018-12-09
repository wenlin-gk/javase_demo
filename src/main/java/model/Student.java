package model;

public class Student {
  private String name;
  private String classNo;
  private double score;

  public Student(String name, String classNo, double score) {
    super();
    this.name = name;
    this.classNo = classNo;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getClassNo() {
    return classNo;
  }

  public void setClassNo(String classNo) {
    this.classNo = classNo;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }
}
