package collection.collection;

class Node {
    Node previous;
    Node next;
    Object obj;

    public Node() {}

    public Node(Node previous, Object obj, Node next) {
        super();
        this.previous = previous;
        this.obj = obj;
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}


public class MyLinkedList {
    private Node first;
    private Node last;

    private int size;

    public boolean isEmpty() {
        return 0 == size;
    }

    public void add(Object obj) {
        Node n = new Node(last, obj, null);

        if (isEmpty()) {
            first = n;
        } else {
            last.setNext(n);
        }

        last = n;
        ++size;
    }

    public void add(int index, Object obj) {
        Node temp = node(index);

        if (null == temp) {
            add(obj);
        } else {
            Node newNode = new Node(temp.previous, obj, temp);
            temp.previous.next = newNode;
            temp.previous = newNode;
            ++size;
        }
    }

    public void remove(int index) {
        Node temp = node(index);

        if (temp != null) {
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
            size--;
        }
    }

    public Object get(int index) {
        rangeCheck(index);

        Node temp = node(index);
        if (temp != null) {
            return temp.obj;
        }
        return null;
    }

    public Node node(int index) {
        Node temp = null;
        if (first != null) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        return temp;
    }

    public int size() {
        return size;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("aaa");
        list.add("bbb");
        list.add(1, "BBBB");
        list.add("ccc");
        list.remove(1);
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
}
