import EmployeeForm from './components/Employee/EmployeeForm.js'

import './App.css'
import { addEmployee } from './services/dbservice.js'
import type { CreateEmployeeDTO } from './types/types.js';
import type { SubmitHandler } from 'react-hook-form';
import EmployeesPage from './components/Employee/EmployeePage.js';
import ContractForm from './components/contract/ContractForm.js';

function App() {

  const handleAddEmployee: SubmitHandler<CreateEmployeeDTO> = async (data) => {
    try {
      const result = await addEmployee(data);
      console.log('Employee created: ', result);
    } catch (e) {
      console.log('Failed to add employee:', e)
    }
  }

  return (
    <>
      {/* <EmployeesPage /> */}
      <ContractForm onSubmit={() => undefined}></ContractForm>
      <EmployeeForm onSubmit={handleAddEmployee} />
      <EmployeesPage></EmployeesPage>
    </>
  )
}

export default App
