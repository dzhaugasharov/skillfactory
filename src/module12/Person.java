package module12;

import java.util.*;

public class Person implements Comparable<Person> {

    final private String firstName;
    final private String lastName;
    final private String middleName;
    final private String birthdate;
    final private char sex;

    public Person(String firstName, String lastName, String middleName, String birthdate, char sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthdate = birthdate;
        this.sex = sex;
    }

    @Override
    public int compareTo(Person person) {
        return this.lastName.compareTo(person.lastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return sex == person.sex && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(middleName, person.middleName) && Objects.equals(birthdate, person.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, birthdate, sex);
    }

    public static class BirthdayComparator implements Comparator<Person> {

        @Override
        public int compare(Person person, Person t1) {
            return person.birthdate.compareTo(t1.birthdate);
        }
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Leo", "Dicaprio", "", "01.02.1982", 'm'));
        list.add(new Person("User", "Nelly", "", "01.02.2000", 'm'));
        list.add(new Person("Ashley", "Dark", "", "01.02.1980", 'm'));
        list.add(new Person("Dmitry", "Ovcharov", "", "01.02.1983", 'm'));
        list.add(new Person("Timo", "Boll", "", "01.02.1981", 'm'));

        Set<Person> set1 = new TreeSet<>(list);
        for (Person p : set1) {
            System.out.println(p);
        }

        Set<Person> set2 = new TreeSet<>(new BirthdayComparator().reversed());
        set2.addAll(list);
        for (Person p : set1) {
            System.out.println(p);
        }
    }
}
