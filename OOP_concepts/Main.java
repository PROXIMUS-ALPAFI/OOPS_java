public class Main {
    public static void main(String[] args) {
        // Create an anonymous subclass of Classroom to provide an implementation for the abstract method
        Classroom classroom = new Classroom(1, "Aligarh Muslim University", "Aligarh", "Uttar Pradesh", 
            "Entry No. 63 Union list - The 7th schedule under Article 246 of the Constitution of India", 
            "Ministry of Education") {
            @Override
            public void displayInfo() {
                System.out.println("Classroom Information:");
                System.out.println("Act: " + getAct());
                System.out.println("Authority: " + getAuthority());
            }
        };

        // Call methods on the Classroom object
        classroom.displayInfo();
    }
}
