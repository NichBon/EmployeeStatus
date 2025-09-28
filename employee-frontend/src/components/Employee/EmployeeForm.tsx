import { useForm, type SubmitHandler } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import styles from './EmployeeForm.module.scss';
import * as yup from 'yup';
import type { CreateEmployeeDTO } from '../../types/types';

type Props = {
    onSubmit: SubmitHandler<CreateEmployeeDTO>;
}

// move enums later?
const employeeTypes = ['FULL_TIME', 'PART_TIME', 'CASUAL', 'INACTIVE'];
const departments = ['SALES', 'MARKETING', 'FINANCE', 'TECHNICAL', 'ADMIN'];

const schema = yup.object().shape({
    name: yup.string().required('Name is required'),
    email: yup.string().email('Invalid email').required('Email is required'),
    dob: yup.date().required('Date of birth is required'),
    employeeType: yup.string().oneOf(employeeTypes).required('Employee type is required'),
    department: yup.string().oneOf(departments).required('Department is required'),
});

const EmployeeForm: React.FC<Props> = ({ onSubmit }) => {
    const {
        register,
        handleSubmit,
        formState: { errors },
    } = useForm({ resolver: yupResolver(schema) });

    return (
        <form onSubmit={handleSubmit(onSubmit)} className={styles.formContainer}>
            <h2>Add New Employee</h2>

            <label>Name</label>
            <input {...register('name')} />
            <p>{errors.name?.message}</p>

            <label>Email</label>
            <input {...register('email')} />
            <p>{errors.email?.message}</p>

            <label>Date of Birth</label>
            <input type="date" {...register('dob')} />
            <p>{errors.dob?.message}</p>

            <label>Employee Type</label>
            <select {...register('employeeType')}>
                <option value="">Select type</option>
                {employeeTypes.map(type => (
                    <option key={type} value={type}>{type}</option>
                ))}
            </select>
            <p>{errors.employeeType?.message}</p>

            <label>Department</label>
            <select {...register('department')}>
                <option value="">Select department</option>
                {departments.map(dep => (
                    <option key={dep} value={dep}>{dep}</option>
                ))}
            </select>
            <p>{errors.department?.message}</p>

            <button type="submit">Submit</button>
        </form>
    );
}

export default EmployeeForm