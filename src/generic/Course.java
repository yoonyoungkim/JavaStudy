package generic;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Course<T> {
    private String name;
    private T[] students;

    public Course(String name, int capacity) {
        this.name = name;
        this.students = (T[]) (new Object[capacity]);
    }

    public String getName() {
        return name;
    }

    public T[] getStudents() {
        return students;
    }

    public void add(T t) {
        //        for (int i = 0; i < this.students.length; i++) {
        //            if (this.students[i] == null) {
        //                this.students[i] = t;
        //                break;
        //            }
        //        }
        IntStream
                .range(0, this.students.length)
                .filter(i -> this.students[i] == null)
                .findFirst()
                .ifPresent(i -> this.students[i] = t);
    }

    public static void registerCourse(Course<?> course) {
        System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
    }
    public static void registerCourseStudent(Course<? extends Student> course) {
        System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
    }
    public static void registerCourseWorker(Course<? extends  Worker> course) {
        System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
    }
}
