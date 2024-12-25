> Arrays.sort (nums) 
> 对于基本数据类型的数组
> Collections.sort (ls)
> 对于引用数据类型的数组
---
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Student {
    String name;
    int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class Main {
    public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    students.add(new Student("Alice", 20));
    students.add(new Student("Bob", 18));
    students.add(new Student("Charlie", 22));
    Comparator<Student> ageComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
        return s1.age - s2.age;
        }
    };
        Collections.sort(students, ageComparator);
        for (Student student : students) {
            System.out.println(student.name + " " + student.age);
        }
    }
}
---

