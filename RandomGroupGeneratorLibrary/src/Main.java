import randomgroupgenerator.Student;
import randomgroupgenerator.Group;
import randomgroupgenerator.RandomGroupGenerator;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import lp.trabalho1.IODataClass;
import lp.trabalho1.StudentInfo;

public class Main {

    public static void main(String[] args) {

        RandomGroupGenerator generator = new RandomGroupGenerator();
        IODataClass io = new IODataClass();

        StudentInfo[] students = io.loadStudentUC("students.txt");

        if (students.length % 2 != 0) {
            System.out.println("O numero de estudantes tem de ser par.");
            return;
        }

        for (StudentInfo s : students) {
            Student student = new Student(String.valueOf(s.getStudentID()), s.getStudentName());
            generator.addStudent(student);
        }

        List<Group> groups = generator.generateGroups();
        List<String> output = new ArrayList<>();
        int groupNumber = 1;

        for (Group g : groups) {
            String line = groupNumber + " - " +
                    g.getStudent1().getName() + "(" + g.getStudent1().getId() + ")" + " e " +
                    g.getStudent2().getName() + "(" + g.getStudent2().getId() + ")";

            System.out.println(line);
            output.add(line);
            groupNumber++;
        }

        String outputFile = "groups.txt";
        io.outputGroups(outputFile, output.toArray(new String[0]));

        File file = new File(outputFile);
        System.out.println("Ficheiro criado em: " + file.getAbsolutePath());
    }
}