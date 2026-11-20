import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        ArrayList<person> people = new ArrayList<>();

        people.add(new person("Alice Johnson", 25));
        people.add(new person("Bob Smith", 34));
        people.add(new person("Charlie Brown", 19));
        people.add(new person("David Jones", 42));
        people.add(new person("Emma Johnson", 28));
        people.add(new person("Frank Wilson", 55));
        people.add(new person("Grace Miller", 31));
        people.add(new person("Hannah Davis", 22));
        people.add(new person("Isaac Smith", 47));
        people.add(new person("Jack Thomas", 18));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine().toLowerCase();

        ArrayList<person> matches = new ArrayList<>();

        for (person person : people) {
            if (person.getName().toLowerCase().contains(searchName)) {
                matches.add(person);
            }
        }

        System.out.println("\nMatching people:");

        if (matches.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            for (person person : matches) {
                System.out.println(person.getName() + " - Age: " + person.getAge());
            }
        }

        int totalAge = 0;
        int oldestAge = people.get(0).getAge();
        int youngestAge = people.get(0).getAge();

        for (person person : people) {
            totalAge += person.getAge();

            if (person.getAge() > oldestAge) {
                oldestAge = person.getAge();
            }

            if (person.getAge() < youngestAge) {
                youngestAge = person.getAge();
            }
        }

        double averageAge = (double) totalAge / people.size();

        System.out.printf("%nAverage Age: %.2f%n", averageAge);
        System.out.println("Oldest Age: " + oldestAge);
        System.out.println("Youngest Age: " + youngestAge);

        scanner.close();
    }
}