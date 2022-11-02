import java.util.*;

public class Main {
    private static final String[] NAME = {"Ваня", "Оля", "Коля", "Маша", "Руслан", "Надя"};
    private static final String[] SURNAME = {"Белоселъский-Белозерский", "Бонч-Бруевич", "фон Бисмарк", "Лопе де Вега", "Мукминов", "Бодуэн де Куртене Сен-Санс"};
    private static final Random AGE = new Random();
    private static final int MAXVALUE = 3;

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < NAME.length; i++) {
            persons.add(new Person(NAME[i], SURNAME[i], AGE.nextInt(100) + 1));
        }
        System.out.println("До компаратора: " + persons);

        // сортировка с помощью лямбды:
        Comparator<Person> comparator1 = (Person p1, Person p2) -> {
            String surname1 = p1.getSurname();
            String surname2 = p2.getSurname();
            List<String> list1 = List.of(surname1.split("\\P{IsAlphabetic}+"));
            List<String> list2 = List.of(surname2.split("\\P{IsAlphabetic}+"));
            if ((list1.size() >= MAXVALUE) && (list2.size() >= MAXVALUE)) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
            if (list1.size() > list2.size()) {
                return 1;
            } else if (list1.size() < list2.size()) {
                return -1;
            } else {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        };
        System.out.print("После(параметр " + MAXVALUE + "): ");
        Collections.sort(persons, comparator1);
        System.out.println(persons);
    }
}
