import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long minors = persons.stream()
                .filter(x -> (x.getAge() < 18))
                .count();
        System.out.println("Несовершеннолетних: " + minors);

        List<String> conscript = persons.stream()
                .filter(x -> (x.getSex() == Sex.MAN))
                .filter(x -> (x.getAge() >= 18))
                .filter(x -> (x.getAge() <= 27))
                .map(x -> x.getFamily())
                .collect(Collectors.toList());
        System.out.println("Cписок фамилий призывников: " + conscript);

        List<Person> workerEducationHigher = persons.stream()
                .filter(x -> (x.getEducation() == Education.HIGHER))
                .filter(Main::worker)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println("Списка потенциально работоспособных людей с высшим образованием: "
                + workerEducationHigher );
    }

    private static boolean worker(Person person) {
        return ((person.getSex() == Sex.MAN)
                && (person.getAge() >= 18 && person.getAge() <= 65))
                || ((person.getSex() == Sex.WOMAN)
                && (person.getAge() >= 18 && person.getAge() <= 60));

    }

    public enum Sex {
        MAN,
        WOMAN
    }

    public enum Education {
        ELEMENTARY,
        SECONDARY,
        FURTHER,
        HIGHER
    }
}
