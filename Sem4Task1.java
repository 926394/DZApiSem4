package javaDZ;
import java.util.Iterator;

/**
 * 1)Вывести список на экран в перевернутом виде (без массивов и ArrayList)
 * Пример:
 * 1 -> 2->3->4
 * Вывод:
 * 4->3->2->1
 */
public class Sem4Task1 {
    public static void main(String[] args) {
        Sem4Task1.SingleLinkList<Sem4Task1.Reversal> reversList = new Sem4Task1.SingleLinkList<>();

        reversList.addToEnd(new Sem4Task1.Reversal(1));
        reversList.addToEnd(new Sem4Task1.Reversal(2));
        reversList.addToEnd(new Sem4Task1.Reversal(3));
        reversList.addToEnd(new Sem4Task1.Reversal(4));
        reversList.addToEnd(new Sem4Task1.Reversal(5));
        reversList.addToEnd(new Sem4Task1.Reversal(6));

        for(Sem4Task1.Reversal revers: reversList) {
            System.out.println(revers);
        }
        reversList.reverse();
        System.out.println("------------------------");
        for(Sem4Task1.Reversal revers: reversList) {
            System.out.println(revers);
        }
    }
    static class Reversal {
        int head;
        public Reversal(int head) {
            this.head = head;
        }
        @Override
        public String toString() {
            return "{" +
                    "num=" + head +
                    '}';
        }
    }
    public static class SingleLinkList<T> implements Iterable<T> {
        Sem4Task1.SingleLinkList.ListItem<T> head;
        Sem4Task1.SingleLinkList.ListItem<T> tail;
        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                Sem4Task1.SingleLinkList.ListItem<T> current = head;
                @Override
                public boolean hasNext() {
                    return current != null;
                }
                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }
        private static class ListItem<T> {
            T data;
            Sem4Task1.SingleLinkList.ListItem<T> next;
        }
        public boolean isEmpty() {
            return head == null;
        }
        public void addToEnd(T item) {
            Sem4Task1.SingleLinkList.ListItem<T> newItem = new Sem4Task1.SingleLinkList.ListItem<>();
            newItem.data = item;
            if (isEmpty()) {
                head = newItem;
                tail = newItem;
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }
        public void reverse() {
            if (!isEmpty() && head.next != null) {
                tail = head;
                Sem4Task1.SingleLinkList.ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    Sem4Task1.SingleLinkList.ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}

