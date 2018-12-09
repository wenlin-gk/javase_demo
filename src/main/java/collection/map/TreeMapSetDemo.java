package collection.map;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;
import model.Person;
import model.Worker;

public class TreeMapSetDemo {
    public static final Comparator<Person> PERSON_COMP =
            (o1, o2) -> -(o1.getHandsome() - o2.getHandsome());

    public static void main(String[] args) {
        TreeMap<Person, String> map = new TreeMap<Person, String>(PERSON_COMP);
        TreeMap<Worker, String> employeeTreeMap = new TreeMap<Worker, String>();

        TreeSet<Person> persons = new TreeSet<Person>(PERSON_COMP);
        TreeSet<Worker> employeeTreeSet = new TreeSet<Worker>();
    }
}
