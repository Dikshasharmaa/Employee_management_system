import { Component } from '@angular/core';
import { Employee } from '../employee';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  standalone:true,
  imports: [FormsModule],
  templateUrl: './create-employee.component.html',
  styleUrl: './create-employee.component.css',
  providers: [EmployeeService]
})

export class CreateEmployeeComponent {
  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService,
    private router: Router){}

    ngOnInit(): void {
     
    }

  saveEmployee() {
    this.employeeService.createEmployee(this.employee).subscribe({
      next: (data) => {
        console.log('Employee created:', data);
        this.goToEmployeeList();
      },
      error: (error) => {
        console.error('Error occurred:', error);
      }
    });
  }
  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }
 
  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();

  }
  

}
