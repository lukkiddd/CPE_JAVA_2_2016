import java.util.Comparator;

/**
 * Created by lukkiddd on 3/20/2017 AD.
 */
public class Student {
    private int ID;
    private String name;
    private String lastname;
    private double GPA;

    public Student(int ID, String name, String lastname, double GPA) {
        this.ID = ID;
        this.name = name;
        this.lastname = lastname;
        this.GPA = GPA;
    }

    public int getStudentID() {
        return ID;
    }

    public String getStudentName() {
        return name;
    }

    public String getStudentLastname() {
        return lastname;
    }

    public double getStudentGPA() {
        return GPA;
    }

    public void setStudentID(int ID) {
        this.ID = ID;
    }

    public void setStudentName(String name) {
        this.name = name;
    }

    public void setStudentLastname(String lastname) {
        this.lastname= lastname;
    }

    public void setStudentGPA(double GPA) {
        this.GPA = GPA;
    }

    public static Comparator<Student> IDComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            Integer o1_ID = o1.getStudentID();
            Integer o2_ID = o2.getStudentID();

            return o1_ID.compareTo(o2_ID);
        }
    };

    public static Comparator<Student> nameComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            String o1_name = o1.getStudentName().toLowerCase();
            String o2_name = o2.getStudentName().toLowerCase();

            return o1_name.compareTo(o2_name);
        }
    };

    public static Comparator<Student> lastnameComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            String o1_lastname = o1.getStudentLastname().toLowerCase();
            String o2_lastname = o2.getStudentLastname().toLowerCase();

            return o1_lastname.compareTo(o2_lastname);
        }
    };

    public static Comparator<Student> GPAComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            Double o1_GPA = o1.getStudentGPA();
            Double o2_GPA = o2.getStudentGPA();

            return o1_GPA.compareTo(o2_GPA);
        }
    };

    @Override
    public String toString() {
        return getStudentID() + "\t\t" + getStudentName() + " " + getStudentLastname() + "\t\t" + getStudentGPA();
    }




}
