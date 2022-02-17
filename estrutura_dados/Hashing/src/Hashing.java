import java.util.*;

public class Hashing {

    public static void main (String[] args) {
        Random random;
        int SIZE = 10;

        Set<Student> studentsSet;
        List<Student> studentsList;

        random = new Random();
        studentsSet = new HashSet<>();
        studentsList = new ArrayList<>();

        while(studentsSet.size() < SIZE){
            int DRE = random.nextInt(1000 * SIZE);
            Student student = new Student(DRE, "Sudent" + DRE);

            //Set will return false if element already exists in hash table
            if(studentsSet.add(student))
                studentsList.add(student);
        }

        for(int i = 0; i <= studentsSet.size(); i++) {
            System.out.println(studentsList.get(i).getName());
        }

        
    }
}
