package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeDetailsController {
    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDetails> getEmployeeById(@PathVariable Integer id) {
        EmployeeDetails employeeDetails = employeeDetailsRepository.findById(id).get();

        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<EmployeeDetails>> getEmployeeById() {
        List<EmployeeDetails> employeeDetails = employeeDetailsRepository.findAll();
        System.out.println(employeeDetails);
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);

    }

    @PostMapping
    public EmployeeDetails addEmployee(@RequestBody EmployeeDetails employee) {
        return employeeDetailsRepository.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDetails updatedEmployee) {
        EmployeeDetails existingEmployee = employeeDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setEmpName(updatedEmployee.getEmpName());
        existingEmployee.setEmpSal(updatedEmployee.getEmpSal());
        existingEmployee.setEmpAge(updatedEmployee.getEmpAge());
        existingEmployee.setEmpState(updatedEmployee.getEmpState());

        employeeDetailsRepository.save(existingEmployee);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeDetailsRepository.deleteById(id);
    }
}
