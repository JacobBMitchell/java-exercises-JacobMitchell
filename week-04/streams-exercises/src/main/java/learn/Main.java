package learn;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        StudentDataStore ds = new StudentDataStore();
        List<Student> students = ds.all();

        // 0. Print all students
        // iteration solution
        for (Student student : students) {
            System.out.println(student);
        }

        // stream solution
        //students.stream().forEach(System.out::println);

        System.out.println();
        // 1. Print students from Argentina
        students.stream().filter(a -> a.getCountry().equalsIgnoreCase("Argentina"))
                .forEach(System.out::println);

        System.out.println();
        // 2. Print students whose last names starts with 'T'.
        students.stream().filter(a -> a.getLastName().startsWith("T"))
                .forEach(System.out::println);

        System.out.println();
        // 3. Print students from Argentina, ordered by GPA
        students.stream().filter(a -> a.getCountry().equalsIgnoreCase("Argentina"))
                .sorted(Comparator.comparing(Student::getGpa))
                .forEach(System.out::println);

        System.out.println();
        // 4. Print the bottom 10% (100 students) ranked by GPA.
        students.stream().sorted(Comparator.comparing(Student::getGpa))
                .limit((long) (.1 * students.size()))
                .forEach(System.out::println);

        System.out.println();

        // 5. Print the 4th - 6th ranked students by GPA from Argentina
        students.stream().filter(a -> a.getCountry().equalsIgnoreCase("Argentina"))
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .skip(3).limit(3).forEach(System.out::println);

        System.out.println();
        // 6. Is anyone from Maldives?
        if (students.stream().anyMatch(a -> a.getCountry().equalsIgnoreCase("Maldives"))){
            System.out.println("Yes someone is from Maldives");
        }

        System.out.println();
        // 7. Does everyone have a non-null, non-empty email address?
        if (students.stream().anyMatch(a -> a.getEmailAddress().isEmpty())){
            System.out.println("Yes there are empty emails");
        }else {
            System.out.println("All emails filled");
        }
        System.out.println();
        // 8. Print students who are currently registered for 5 courses.
        students.stream().filter(a -> a.getRegistrations().size() == 5)
                .forEach(System.out::println);

        System.out.println();
        // 9. Print students who are registered for the course "Literary Genres".
        students.stream()
                .filter(
                        student -> student.getRegistrations().stream().anyMatch(registration -> registration.getCourse().contains("Literary Genres")))
                .forEach(System.out::println);

        System.out.println();
        // 10. Who has the latest birthday? Who is the youngest?
        System.out.println( students.stream().min((a, b) -> b.getBirthDate().compareTo(a.getBirthDate())));

        System.out.println();
        // 11. Who has the highest GPA? There may be a tie.
        students.stream().sorted(Comparator.comparing(Student::getGpa).reversed())
                .filter(a -> Objects.equals(a.getGpa(), students.stream().max(Comparator.comparing(Student::getGpa)).orElseThrow().getGpa()))
                .forEach(System.out::println);

        System.out.println();
        // 12. Print every course students are registered for, including repeats.
        students.forEach(student -> student.getRegistrations().forEach(System.out::println));

        System.out.println();
        // 13. Print a distinct list of courses students are registered for.
        Stream<String> courses = students.stream().flatMap(student -> student.getRegistrations().stream())
                .map(Registration::getCourse)
                .distinct();
        courses.forEach(System.out::println);

        System.out.println();
        // 14. Print a distinct list of courses students are registered for, ordered by name.
        courses = students.stream().flatMap(student -> student.getRegistrations().stream())
                .map(Registration::getCourse)
                .distinct();
        courses.sorted(String::compareTo).forEach(System.out::println);

        System.out.println();
        // 15. Count students per country.
        Map<String, Long> collect = students.stream().collect(Collectors.groupingBy(Student::getCountry, Collectors.counting()));
        for (String country: collect.keySet()){
            System.out.println(country +": " + collect.get(country));
        }

        System.out.println();
        // 16. Count students per country. Order by most to fewest students.
        Map<String, Long> collect1 = students.stream()
                .collect(Collectors.groupingBy(Student::getCountry, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        for (String country: collect1.keySet()){
            System.out.println(country +": " + collect1.get(country));
        }

        // 17. Count registrations per course.


        // 18. How many registrations are not graded (GradeType == AUDIT)?

        // 19. Create a new type, StudentSummary with fields for Country, Major, and IQ.
        //     Map Students to StudentSummary, then sort and limit by IQ (your choice of low or high).

        // 20. What is the average GPA per country (remember, it's random fictional data).

        // 21. What is the maximum GPA per country?

        // 22. Print average IQ per Major ordered by IQ ascending.

        // 23. STRETCH GOAL!
        // Who has the highest pointPercent in "Sacred Writing"?
    }
}
