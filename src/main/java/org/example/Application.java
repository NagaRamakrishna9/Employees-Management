package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
@SpringBootApplication
public class Application {

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Override 
    public void run(String... args) {
        // Perform database operations using employeeDetailsRepository
        // Example: Save, update, delete, select
        // Create new employee
        EmployeeDetails newEmployee = new EmployeeDetails();
        newEmployee.setEmpName("John Doe");
        newEmployee.setEmpSal(50000.00F);
        newEmployee.setEmpAge(30);
        newEmployee.setEmpState("California");
        // Save new employee
        EmployeeDetails savedEmployee = employeeDetailsRepository.save(newEmployee);
        System.out.println("New employee saved with ID: " + savedEmployee.getEmpId());

        // Retrieve employee by ID
        Integer empId = savedEmployee.getEmpId();
        EmployeeDetails retrievedEmployee = employeeDetailsRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        System.out.println("Retrieved employee: " + retrievedEmployee);

        // Update employee
        retrievedEmployee.setEmpSal(55000.00F);
        EmployeeDetails updatedEmployee = employeeDetailsRepository.save(retrievedEmployee);
        System.out.println("Updated employee: " + updatedEmployee);

        // Delete employee by ID
        employeeDetailsRepository.deleteById(empId);
        System.out.println("Employee with ID " + empId + " deleted");

        // Verify employee deletion
        if (employeeDetailsRepository.existsById(empId)) {
            System.out.println("Employee with ID " + empId + " still exists");
        } else {
            System.out.println("Employee with ID " + empId + " does not exist anymore");
        }

    }
}