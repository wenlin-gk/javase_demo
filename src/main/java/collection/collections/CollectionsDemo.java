package collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringComp implements java.util.Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int len1 = o1.length();
        int len2 = o2.length();
        return -(len1 - len2);
    }
}


public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Collections.sort(list, new StringComp());

        Collections.shuffle(list);
        Collections.reverse(list);
    }
}
