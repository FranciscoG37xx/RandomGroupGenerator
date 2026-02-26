/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package randomgroupgenerator;
import java.util.Objects;
/**
 *
 * @author franc
 */

public class Group {

    private Student student1;
    private Student student2;

    public Group(Student s1, Student s2) {

        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Estudantes não podem ser null");
        }

        if (s1.equals(s2)) {
            throw new IllegalArgumentException("Grupo não pode ter o mesmo estudante");
        }

        //ordem consistente
        if (s1.getId().compareTo(s2.getId()) < 0) {
            this.student1 = s1;
            this.student2 = s2;
        } else {
            this.student1 = s2;
            this.student2 = s1;
        }
    }

    public Student getStudent1() {
        return student1;
    }

    public Student getStudent2() {
        return student2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return student1.equals(group.student1) &&
               student2.equals(group.student2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student1, student2);
    }

    @Override
    public String toString() {
        return student1 + " <-> " + student2;
    }
}
