import java.util.Comparator;
import java.util.List;

public class NobilityComparator implements Comparator<Person> {

    private int maxValue;

    public NobilityComparator(int maxValue) {
        this.maxValue = maxValue;
    }

    public NobilityComparator() {
        super();
        this.maxValue = 100;
    }

    @Override
    public int compare(Person o1, Person o2) {
        String surname1 = o1.getSurname();
        String surname2 = o2.getSurname();
        List<String> list1 = List.of(surname1.split("\\P{IsAlphabetic}+"));
        List<String> list2 = List.of(surname2.split("\\P{IsAlphabetic}+"));
        if ((list1.size() >= maxValue) && (list2.size() >= maxValue)) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
        if (list1.size() > list2.size()) {
            return 1;
        } else if (list1.size() < list2.size()) {
            return -1;
        } else {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
}
