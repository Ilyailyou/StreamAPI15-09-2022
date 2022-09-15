import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Stream.generate(Person::new)
                .limit(10_000_000)
                .collect(Collectors.toList());
        long underaged = people.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + underaged);
        List<String> recruits = people.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27 && person.getSex() == Sex.MALE)
                .map(person -> person.getSurname())
                .collect(Collectors.toList());
        System.out.println("Фамилии призывников: " + recruits);
        List<Person> workers = people.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> person.getAge() >= 18 && (person.getAge() < 65 && person.getSex() == Sex.MALE || person.getAge() < 60 && person.getSex() == Sex.FEMALE))
                .sorted(Comparator.comparing(person -> person.getSurname()))
                .collect(Collectors.toList());
        System.out.println("Работоспособные люди: " + workers);

    }
}