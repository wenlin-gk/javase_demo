package collection.extensions.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;


public class Demo01 {
    public static Predicate<String> selfPre = new Predicate<String>() {
        @Override
        public boolean evaluate(String object) {
            return object.length() >= 5 && object.length() <= 20;
        }
    };

    public static void main(String[] args) {
        Predicate notNull = NotNullPredicate.notNullPredicate();
        Predicate all = PredicateUtils.allPredicate(notNull, selfPre);
        Predicate<String> uniquePre = UniquePredicate.uniquePredicate();
        Predicate<String> pre = EqualPredicate.equalPredicate("bjsxt");

        List<String> list = PredicatedList.predicatedList(new ArrayList<String>(), all);
        list.add("bjsxt");
        // // list.add(null);
        // list.add("bj");
        print(list);
    }

    public static void print(final List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
