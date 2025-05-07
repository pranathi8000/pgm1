package pgm1;

class Student {
    String name;
    String program;
    int semester;
    Course[] courses;

    Student(String name, String program, int semester, Course[] courses) {
        this.name = name;
        this.program = program;
        this.semester = semester;
        this.courses = courses;
    }

    void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Program: " + program);
        System.out.println("Semester: " + semester);
        System.out.println("Registered Courses:");
        for (Course course : courses) {
            System.out.println("- " + course.courseName);
        }
    }

    void displayLowMarks() {
        System.out.println("Courses with marks < 40:");
        for (Course course : courses) {
            if (course.marks < 40) {
                System.out.println(course.courseName + " - " + course.marks);
            }
        }
    }
}

class Course {
    String courseName;
    int marks;

    Course(String courseName, int marks) {
        this.courseName = courseName;
        this.marks = marks;
    }
}

public class StudentCourseMain {
    public static void main(String[] args) {
        Course[] courses = {
            new Course("Maths", 45),
            new Course("Physics", 38),
            new Course("Chemistry", 30),
            new Course("English", 60)
        };

        Student student = new Student("Ravi", "B.Sc", 2, courses);
        student.displayStudentDetails();
        student.displayLowMarks();
    }
}
