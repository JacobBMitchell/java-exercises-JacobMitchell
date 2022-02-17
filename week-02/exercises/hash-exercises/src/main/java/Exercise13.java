import java.util.HashMap;

public class Exercise13 {
    public static void main(String[] args) {
        HashMap<Integer,Student> students = new HashMap<>();
        Student jacob = new Student("Jacob", "Mitchell");
        jacob.setStudentID(170984);
        Student julian = new Student("Julian", "Garcia");
        julian.setStudentID(8675309);
        Student aaron = new Student("Aaron","Granados");
        aaron.setStudentID(5882300);
        students.put(jacob.getStudentID(),jacob);
        students.put(julian.getStudentID(), julian);
        students.put(aaron.getStudentID(), aaron);
        System.out.println(students.get(170984));//print me
        students.remove(5882300);
        for(int id: students.keySet()){
            System.out.println(students.get(id));//print me and julian having removed aaron
        }
    }
}
