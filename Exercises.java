package se.lexicon;




import java.time.LocalDate;
import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.util.function.Function;
import java.util.function.Predicate;


public class Exercises {

        private final static DataStorage storage = DataStorage.INSTANCE;

        /*
           TODO:  1.	Find everyone that has firstName: “Erik” using findMany().
        */
        public static void exercise1(String message) {
            System.out.println(message);
            Predicate<Person> findErik = person -> person.getFirstName().equals("Erik");
            storage.findMany(findErik).forEach(System.out::println);
            System.out.println("----------------------");
        }

        /*
            TODO:  2.	Find all females in the collection using findMany().
         */
        public static void exercise2(String message) {
            System.out.println(message);
            Predicate<Person> femaleFilter = person -> person.getGender().equals(Gender.FEMALE);
            storage.findMany(femaleFilter).forEach(System.out::println);
            System.out.println("----------------------");
        }

        /*
            TODO:  3.	Find all who are born after (and including) 2000-01-01 using findMany().
         */
        public static void exercise3(String message) {
            System.out.println(message);
            Predicate<Person> bornAfter2000Filter = person -> person.getBirthDate().isAfter(LocalDate.parse("2000-01-01"));
            storage.findMany(bornAfter2000Filter).forEach(System.out::println);
            System.out.println("----------------------");
        }

        /*
            TODO: 4.	Find the Person that has an id of 123 using findOne().
         */
        public static void exercise4(String message) {
            System.out.println(message);
            Predicate<Person> id123Filter = person -> person.getId() == 123;
            System.out.println(storage.findOne(id123Filter));
            System.out.println("----------------------");

        }

        /*
            TODO:  5.	Find the Person that has an id of 456 and convert to String with following content:
                “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
         */
        public static void exercise5(String message) {
            System.out.println(message);
            Predicate<Person> id456Filter = person -> person.getId() == 456;
            Function<Person, String> personToString = person ->
                    "Name: " + person.getFirstName() + " " + person.getLastName() +
                            " Born: " +person.getBirthDate();
            System.out.println(storage.findOneAndMapToString(id456Filter,personToString));
            System.out.println("----------------------");
        }

        /*
            TODO:  6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
         */
        public static void exercise6(String message) {
            System.out.println(message);
            Predicate<Person> MaleNamesWithE = person -> person.getFirstName().startsWith("E") && person.getGender().equals(Gender.MALE);
            Function<Person, String> personToString = person ->
                    "Name: " + person.getFirstName();
            storage.findManyAndMapEachToString(MaleNamesWithE, personToString).forEach(System.out::println);
            System.out.println("----------------------");
        }

        /*
            TODO:  7.	Find all people who are below age of 10 and convert them to a String like this:
                “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
         */
        public static void exercise7(String message) {
            System.out.println(message);
            Predicate<Person> belowAge10 = person ->
                    LocalDate.now().getYear() - person.getBirthDate().getYear() < 10;
            Function<Person, String> personToString = person ->
                    person.getFirstName() + " " + person.getLastName() +
                            " " + (LocalDate.now().getYear() - person.getBirthDate().getYear()) + " years";
            storage.findManyAndMapEachToString(belowAge10, personToString)
                    .forEach(System.out::println);
            System.out.println("----------------------");
        }

        /*
            TODO:  8.	Using findAndDo() print out all people with firstName “Ulf”.
         */
        public static void exercise8(String message) {
            System.out.println(message);
            Predicate<Person> Ulf = person -> person.getFirstName().equals("Ulf");
            storage.findAndDo(Ulf,System.out::println);
            System.out.println("----------------------");
        }

        /*
            TODO:  9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
         */
        public static void exercise9(String message) {
            System.out.println(message);
            Predicate<Person> LastAndFirst = person ->
                    person.getLastName().contains(person.getFirstName());
            storage.findAndDo(LastAndFirst, System.out::println);
            System.out.println("----------------------");
        }

        /*
            TODO:  10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
         */
        public static void exercise10(String message) {
            System.out.println(message);
            Predicate<Person> firstNameIsPalindromeFilter = person -> {
                String firstName = person.getFirstName().toLowerCase();
                return new StringBuilder(firstName).reverse().toString().equals(firstName);
            };
            storage.findAndDo(firstNameIsPalindromeFilter,
                    person -> System.out.println(person.getFirstName() + " " + person.getLastName()));
            System.out.println("----------------------");
        }

        /*
            TODO:  11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
         */
        public static void exercise11(String message) {
            System.out.println(message);
            Predicate<Person> StartsWithA = person -> person.getFirstName().startsWith("A");
            System.out.println("----------------------");
        }

        /*
            TODO:  12.	Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
         */
        public static void exercise12(String message) {
            System.out.println(message);
            //Write your code here

            System.out.println("----------------------");
        }

        /*
            TODO:  13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
         */
        public static void exercise13(String message) {
            System.out.println(message);
            //Write your code here

            System.out.println("----------------------");
        }
    }

