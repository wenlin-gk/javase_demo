package collection.collection;

import java.util.LinkedList;

public class MyHashMap {
    LinkedList<Entry>[] listArr = new LinkedList[9];
    int size;

    public void put(Object key, Object value) {
        Entry e = new Entry(key, value);

        int a = key.hashCode() % listArr.length;
        if (listArr[a] == null) {
            LinkedList list = new LinkedList();
            listArr[a] = list;
            list.add(e);
        } else {
            LinkedList list = listArr[a];
            for (int i = 0; i < list.size(); i++) {
                Entry e2 = (Entry) list.get(i);
                if (e2.key.equals(key)) {
                    e2.value = value;
                    return;
                }
            }

            listArr[a].add(e);
        }
    }

    public Object get(Object key) {
        int a = key.hashCode() % listArr.length;
        if (listArr[a] != null) {
            LinkedList list = listArr[a];
            for (int i = 0; i < list.size(); i++) {
                Entry e = (Entry) list.get(i);
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }

        return null;
    }
}
