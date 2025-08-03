public class MVCTest {
    public static void main(String[] args) {
        // Create model
        Student student = new Student(1, "John Doe", 85.5);

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial details
        controller.updateView();

        // Update model data via controller
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade(92.0);

        // Display updated details
        controller.updateView();
    }
}
