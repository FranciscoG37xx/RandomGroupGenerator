/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package randomgroupgenerator;

import java.util.*;

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

    public void addStudents(List<Student> list) {
        for (Student s : list) {
            addStudent(s);
        }
    }

    public void addPreviousGroup(Group g) {
        if (g == null) {
            throw new IllegalArgumentException("Group inválido");
        }

        previousGroups.add(g);
    }

    public List<Group> generateGroups() {

        if (!canGenerateMoreGroups()) {
            throw new IllegalStateException("Não é possível gerar mais grupos sem repetir");
        }

        List<Student> shuffled = new ArrayList<>(students);
        Collections.shuffle(shuffled, random);

        List<Group> newGroups = new ArrayList<>();

        for (int i = 0; i < shuffled.size() - 1; i += 2) {

            Student s1 = shuffled.get(i);
            Student s2 = shuffled.get(i + 1);

            Group g = new Group(s1, s2);

            if (!previousGroups.contains(g)) {
                newGroups.add(g);
                previousGroups.add(g);
            }
        }

        return newGroups;
    }

    public boolean canGenerateMoreGroups() {

        int n = students.size();

        int maxPairs = n * (n - 1) / 2;

        return previousGroups.size() < maxPairs;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public Set<Group> getPreviousGroups() {
        return new HashSet<>(previousGroups);
    }
}
