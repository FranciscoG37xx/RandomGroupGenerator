import randomgroupgenerator.Student;
import randomgroupgenerator.Group;
import randomgroupgenerator.RandomGroupGenerator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        RandomGroupGenerator generator = new RandomGroupGenerator();

        Student s1 = new Student("1", "Ana");
        Student s2 = new Student("2", "Joao");
        Student s3 = new Student("3", "Maria");
        Student s4 = new Student("4", "Pedro");

        generator.addStudent(s1);
        generator.addStudent(s2);
        generator.addStudent(s3);
        generator.addStudent(s4);

        List<Group> groups = generator.generateGroups();

        System.out.println("Grupos gerados:");
        for (Group g : groups) {
            System.out.println(g);
        }
    }
}