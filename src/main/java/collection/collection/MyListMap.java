package collection.collection;

public class MyListMap {
    Entry[] arr = new Entry[990];
    int size;

    public void put(Object key, Object value) {
        try {
            Entry entry = getEntry(key);
            entry.value = value;
        } catch (Exception e) {
            arr[size] = new Entry(key, value);
            ++size;
        }
    }

    public Entry getEntry(Object key) throws Exception {
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                return arr[i];
            }
        }
        throw new Exception("Unexist key: " + key);
    }

    public Entry getEntryByValue(Object value) throws Exception {
        for (int i = 0; i < size; i++) {
            if (arr[i].value.equals(value)) {
                return arr[i];
            }
        }
        throw new Exception("Unexist value: " + value);
    }

    public Object get(Object key) {
        try {
            return getEntry(key).value;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean containsKey(Object key) {
        try {
            getEntry(key);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean containsValue(Object value) {
        try {
            getEntryByValue(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        MyListMap m = new MyListMap();
        m.put("wenlin", new Wife("wa"));
        m.put("wenlin", new Wife("wb"));
        Wife w = (Wife) m.get("wenlin");
        System.out.println(w.name);
    }
}


class Entry {
    Object key;
    Object value;

    public Entry(Object key, Object value) {
        super();
        this.key = key;
        this.value = value;
    }
}


class Wife {
    String name;

    public Wife(String name) {
        this.name = name;
    }
}
