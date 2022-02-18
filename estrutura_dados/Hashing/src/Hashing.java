import java.util.*;

public class Hashing {

    public static void main (String[] args) {
        Random random;
        int SIZE = 10;

        Set<Student> studentsHashSet;
        List<Student> studentsList;
        TreeSet<Student> studentsTreeSet;

        random = new Random();
        studentsHashSet = new HashSet<>();
        studentsList = new ArrayList<>();
        studentsTreeSet = new TreeSet<>();

        Student student1 = new Student(random.nextInt(1000 * SIZE), "Ana");
        Student student2 = new Student(random.nextInt(1000 * SIZE), "Joana");
        Student student3 = new Student(random.nextInt(1000 * SIZE), "Teresa");
        Student student4 = new Student(random.nextInt(1000 * SIZE), "Alice");

        studentsHashSet.add(student1);
        studentsHashSet.add(student2);
        studentsHashSet.add(student3);
        studentsHashSet.add(student4);

        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);

        studentsTreeSet.add(student1);
        studentsTreeSet.add(student2);
        studentsTreeSet.add(student3);
        studentsTreeSet.add(student4);


//        while(studentsSet.size() < SIZE){
//            int DRE = random.nextInt(1000 * SIZE);
//            Student student = new Student(DRE, "Student" + DRE);
//
//            //Set will return false if element already exists in hash table
//            if(studentsSet.add(student))
//                studentsList.add(student);
//        }

        System.out.println("\n\nHashSet: ");
        for(Student student : studentsHashSet) {
            System.out.println(student);
        }

        System.out.println("\n\nList: ");
        for(Student student : studentsList) {
            System.out.println(student);
        }

        System.out.println("\n\nTreeSet: ");
        for(Student student : studentsTreeSet) {
            System.out.println(student);
        }
        
    }
}
