
import type { Employee } from '../../types/types';

type Props = {
  employee: Employee;
}

const EmployeeCard: React.FC<Props> = ({ employee }) => {
  return (
    <div className="employee-card">
      <h3>{employee.name}</h3>
      <p><strong>Email:</strong> {employee.email}</p>
      <p><strong>Department:</strong> {employee.department}</p>
      <p><strong>Type:</strong> {employee.employeeType}</p>
      <p><strong>Age:</strong> {employee.age}</p>
      <p><strong>Salary:</strong> ${employee.salary}</p>
      <p><strong>Hours:</strong> {employee.hours} hrs</p>
    </div>
  );
};

export default EmployeeCard;