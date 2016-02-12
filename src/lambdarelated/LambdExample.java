package lambdarelated;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LambdExample {

	public static void main(String[] args) {
		List<Person> roster = new ArrayList<Person>();
		roster.add(new Person("x"));
		roster.add(new Person("y"));

		printPersons(roster, new CheckPersonEligibleForSelectiveService());

		printPersons(roster, new CheckPerson() {
			public boolean test(Person p) {
				return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
			}
		});

		// This is the lambda expression now
		// This is strange, how does this work?

		printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);

		// persons with predicate
		printPersonsWithPredicate(roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);

	}

	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
		for (Person p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPerson();
			}
		}
	}

	// passing the interface
	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

}

class Person {

	public enum Sex {
		MALE, FEMALE
	}

	Person(String name) {
		this.name = name;
	}

	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;
	int age;

	public int getAge() {
		return age;
	}

	public Sex getGender() {
		return gender;
	}

	public void printPerson() {
	}

}

interface CheckPerson {
	boolean test(Person p);
}

// instead of the CheckPerson Let us do a predicate
/*
 * interface Predicate<T> { boolean test(T t); }
 */

interface Predicate<Person> {
	boolean test(Person t);
}

class CheckPersonEligibleForSelectiveService implements CheckPerson {
	public boolean test(Person p) {
		return p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
	}
}
