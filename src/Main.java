import java.util.*;
import java.util.function.Predicate;

public class Main {
    private static final String[] NAME = {"Ваня", "Оля", "Коля", "Маша", "Руслан", "Надя"};
    private static final String[] SURNAME = {"Белоселъский-Белозерский", "Бонч-Бруевич", "фон Бисмарк", "Лопе де Вега", "Мукминов", "Бодуэн де Куртене Сен-Санс"};
    private static final Random AGE = new Random();
    private static final int AGEPARAM = 18;

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < NAME.length; i++) {
            persons.add(new Person(NAME[i], SURNAME[i], AGE.nextInt(20) + 1));
        }
        System.out.println("До компаратора: " + persons);
        Collections.sort(persons, new NobilityComparator(1));
        System.out.println("После компаратора: " + persons);

        System.out.print("удаляем из списка людей, которые младше " + AGEPARAM + " лет:");
        Predicate<Person> agePredicate = person -> person.getAge() < AGEPARAM;
        persons.removeIf(agePredicate);
        System.out.println(persons);
    }
}
