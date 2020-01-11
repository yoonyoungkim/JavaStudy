package test;

import generic.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericTest {
    @Test
    public void nonGeneric() {
        Box box1 = new Box();
        box1.set("test");
        String boxString = (String) box1.get();
        assertEquals(boxString, "test");

        Box box2 = new Box();
        box2.set(3);
        int boxInteger = (int) box2.get();
        assertEquals(boxInteger, 3);
    }

    @Test
    void generic() {
        BoxGeneric<String> box1 = new BoxGeneric<>();
        box1.set("test");
        String boxString = box1.get();
        assertEquals(boxString, "test");

        BoxGeneric<Integer> box2 = new BoxGeneric<>();
        box2.set(3);
        int boxInteger = box2.get();
        assertEquals(boxInteger, 3);
    }

    @Test
    void multiTypeParameter() {
        Product<Product.Car, String> car = new Product<>();
        car.setKind(new Product.Car());
        car.setModel("디젤");
        assertEquals(car.getModel(), "디젤");

        Product<Product.Tv, String> tv = new Product<>();
        tv.setKind(new Product.Tv());
        tv.setModel("Smart Tv");
        assertEquals(tv.getModel(), "Smart Tv");
    }

    @Test
    void genericMethod() {
        BoxGeneric<String> nameBox = Util.boxing("Tiffany");
        BoxGeneric<Integer> ageBox = Util.boxing(32);

        String name = nameBox.get();
        int age = ageBox.get();

        assertEquals(name, "Tiffany");
        assertEquals(age, 32);
    }

    @Test
    void multiParameterGenericMethod() {
        Pair<String, Integer> p1 = new Pair<>("tiffany", 30);
        Pair<String, Integer> p2 = new Pair<>("tiffany", 30);

        boolean result1 = Util.compare(p1, p2);
        assertEquals(result1, true);

        Pair<String, String> p3 = new Pair<>("tiffany", "소녀시대");
        Pair<String, String> p4 = new Pair<>("tiffany", "소시");

        boolean result2 = Util.compare(p3, p4);
        assertEquals(result2, false);
    }

    @Test
    void restrictedTypeParameter() {
        assertEquals(Util.compareNumber(3.14f, 3), 1);
        assertEquals(Util.compareNumber(3, 3.14f), -1);
        assertEquals(Util.compareNumber(3, 3f), 0);
    }

    @Test
    void wildCardTypeParameter() {
        Course<Person> personCourse = new Course<>("일반인과정", 5);
        personCourse.add(new Person("일반인"));
        personCourse.add(new Worker("직장인"));
        personCourse.add(new Student("학생"));
        personCourse.add(new HighSchoolStudent("고등학생"));

        Course<Worker> workerCourse = new Course<>("직장인과정", 5);
        workerCourse.add(new Worker("직장인"));

        Course<Student> studentCourse = new Course<>("학생과정", 5);
        studentCourse.add(new Student("학생"));
        studentCourse.add(new HighSchoolStudent("고등학생"));

        Course<HighSchoolStudent> highSchoolStudentCourse = new Course<>("고등학생과정", 5);
        highSchoolStudentCourse.add(new HighSchoolStudent("고등학생"));

        Course.registerCourse(personCourse);
        Course.registerCourse(workerCourse);
        Course.registerCourse(studentCourse);
        Course.registerCourse(highSchoolStudentCourse);
        System.out.println();

        Course.registerCourseStudent(studentCourse);
        Course.registerCourseStudent(highSchoolStudentCourse);
        System.out.println();

        Course.registerCourseWorker(workerCourse);
        System.out.println();
    }

    @Test
    void ExtendsImplementsGeneric() {
        ChildProduct<Product.Tv, String, String> product = new ChildProduct<>();
        product.setKind(new Product.Tv());
        product.setModel("Smart Tv");
        product.setCompany("Samsung");

        Storage<Product.Tv> storage = new StorageImpl<Product.Tv>(100);
        storage.add(new Product.Tv(), 0);
        Product.Tv tv = storage.get(0);

        assertEquals(product.getModel(), "Smart Tv");
        assertEquals(product.getCompany(), "Samsung");
    }
}
