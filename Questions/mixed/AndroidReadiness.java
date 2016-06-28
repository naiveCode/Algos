import java.io.*;
import java.util.Arrays;

public class AndroidReadiness {
    public static void main(String[] args) throws IOException {
        // TestA your code here:

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        int test = 0;
        Human []human = new Human[tests];
        while (test++ != tests) {

            String[] data = br.readLine().split("\\s");

            if (data[0].equalsIgnoreCase("superhero")) {
                human[test-1] = new Superhero(data[1], Integer.parseInt(data[2]), data[3]);
            } else if (data[0].equalsIgnoreCase("human")) {
                human[test-1] = new Human(data[1], Integer.parseInt(data[2]));
            } else {
                human[test-1] = new Superhero("naiveCode", 27,"Epiphany");
            }
            System.out.println(human[test-1].introduce());
        }
        Arrays.sort(human);
        for (int i=0;i<human.length;i++){
            System.out.println(human[i].getAge());
        }


//        System.out.println(pepper.introduce());


        // Testing your Comparable Interface:
        // Create multiple Humans/Superheros and add them to an ArrayList
        // Example:
        // Superhero ironman = new Superhero("Tony", 35, "Ironman");
        // Human rachel = new Human("Rachel", 22);

        // List<Human> people = new ArrayList<Human>();
        // people.add(batman);
        // people.add(rachel);
        // people.add(ironman);
        // people.add(pepper);


        // Then sort your list (which uses your interface implementation)
        // Collections.sort(people);
        // Print the age in sorted order (ascending order)
    }
}

class Human implements Comparable<Human> {
    private int age;
    private String name;

    public Human(String givenName, int age) {
        this.name = givenName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String introduce() {
        return "Hey! I'm " + name + " and I'm " + age + " years old.";
    }

    @Override
    public int compareTo(Human o) {
        return this.age - o.age;
    }


    // Hint: Implement the method required by the Comparable Interface
    // using age as the differentiator
}

/*
 * - TASK: Extend the class Superhero as a subclass of Human.
 * - TASK: Add a String field that stores the hero's alter ego!
 * - TASK: Modify the given constructor by adding the alter ego as an additional parameter
 *   and setting it.
 * - TASK: Override the introduce() method to ALSO include the alter ego! (In other words,
 *   you should call the superclass introduce method when you override the method.)
*/

class Superhero extends Human {

    private String alterEgo;

    public Superhero(String givenName, int age, String ae) {
        super(givenName, age);
        alterEgo = ae;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public String introduce() {
        return "Hey! I'm " + super.getName() + " and I'm " + super.getAge() + " years old." + " I'm also known as " + alterEgo + "!";
    }

    @Override
    public int compareTo(Human o) {
        return this.getAge() - o.getAge();
    }
}
