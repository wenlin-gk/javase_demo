package collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.Classroom;
import model.Student;

/**
 * @author 飞扬
 * @see Map的遍历方法
 * @see Set<Map.Entry<K, V>> Map.entrySet();
 * @see 根据学生信息，统计班级得分情况
 */
public class MapDemo4Statistics {
  static void countScore(Map<String, Classroom> rooms, List<Student> list) {
    for (Student stu : list) {
      String classNo = stu.getClassNo();
      double score = stu.getScore();

      Classroom room = getRoom(rooms, classNo);
      room.setTotalScore(room.getTotalScore() + score);
      room.getStus().add(stu);
    }
  }

  static Classroom getRoom(Map<String, Classroom> rooms, String classNo) {
    Classroom room = rooms.get(classNo);
    if (null == room) {
      room = new Classroom(classNo);
      rooms.put(classNo, room);
    }

    return room;
  }

  static void printScore(Map<String, Classroom> rooms) {
    Set<Map.Entry<String, Classroom>> entrySet = rooms.entrySet();
    Iterator<Map.Entry<String, Classroom>> iter = entrySet.iterator();
    while (iter.hasNext()) {
      Map.Entry<String, Classroom> entry = iter.next();
      String roomNo = entry.getKey();
      Classroom room = entry.getValue();

      double aver = room.getTotalScore() / room.getStus().size();

      System.out.println("classNumber: " + roomNo + "\t" + "totalScore: " + room.getTotalScore()
          + "\t" + "averageScore: " + aver);
    }
  }

  public static void main(String[] args) {
    List<Student> stus = new ArrayList<Student>();
    fill(stus);
    Map<String, Classroom> rooms = new HashMap<String, Classroom>();

    countScore(rooms, stus);
    printScore(rooms);
  }

  static void fill(List<Student> list) {
    list.add(new Student("a", "001", 80));
    list.add(new Student("b", "001", 80));
    list.add(new Student("a", "002", 80));
    list.add(new Student("c", "003", 80));
    list.add(new Student("d", "003", 80));
  }
}
