/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package randomgroupgenerator;
import java.util.*;
/**
 *
 * @author franc
 */


public class RandomGroupGenerator {

    private List<Student> students;
    private Set<Group> previousGroups;
    private Random random;

    public RandomGroupGenerator() {
        students = new ArrayList<>();
        previousGroups = new HashSet<>();
        random = new Random();
    }

    public void addStudent(Student s) {
        if (s == null) {
            throw new IllegalArgumentException("Student inválido");
        }

        if (!students.contains(s)) {
            students.add(s);
        }
    }

    public void addPreviousGroup(Group g) {
        if (g == null) {
            throw new IllegalArgumentException("Group inválido");
        }

        previousGroups.add(g);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public Set<Group> getPreviousGroups() {
        return new HashSet<>(previousGroups);
    }
}
