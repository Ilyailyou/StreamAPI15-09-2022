import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Person {
    private String name;
    private String surname;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String surname, int age, Sex sex, Education education) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }
    public Person() {
        Random random = new Random();
        List<String> maleNames = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> femaleNames = Arrays.asList("Olivia", "Emma", "Charlotte", "Amelia", "Ava", "Sophia");
        List<String> surnames = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        this.sex = Sex.values()[random.nextInt(Sex.values().length)];
        if(this.sex == Sex.MALE) {
            this.name = maleNames.get(random.nextInt(maleNames.size()));
        } else {
            this.name = femaleNames.get(random.nextInt(femaleNames.size()));
        }
        this.surname = surnames.get(random.nextInt(surnames.size()));
        this.age = random.nextInt(100);
        this.education = Education.values()[random.nextInt(Education.values().length)];
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }

}
