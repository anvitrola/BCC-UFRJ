import java.util.Objects;

public class Student implements Comparable<Student>{
    private final long DRE;
    private float CRA;
    private final String name;

    public Student(long DRE, String name) {
        this.DRE = DRE;
        this.name = name;
    }

    public float getCRA() {
        return CRA;
    }

    public long getDRE() {
        return DRE;
    }

    public String getName() {
        return name;
    }

    public void setCRA(float CRA) {
        this.CRA = CRA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return DRE == student.DRE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(DRE);
    }

    @Override
    public int compareTo(Student o) {
       return this.name.compareTo(o.getName());
    }
}
