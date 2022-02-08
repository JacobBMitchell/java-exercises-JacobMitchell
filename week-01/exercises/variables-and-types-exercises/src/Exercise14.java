public class Exercise14 {
    public static void main(String[] args) {
        int gradeLevel = 6;
        boolean isSenior = (gradeLevel == 12);
        boolean isInterestedInVolunteering = false;
        boolean shouldSendVolunteerInfo = (isSenior && isInterestedInVolunteering);
        System.out.println(shouldSendVolunteerInfo);
    }
}
