import { useForm, type SubmitHandler } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import styles from './ContractForm.module.scss';
import * as yup from 'yup';
import type { CreateContractDTO, ContractType } from '../../types/types';

type Props = {
    onSubmit: SubmitHandler<CreateContractDTO>;
};

// move enums later?
const contractTypes = ['FULL_TIME', 'PART_TIME', 'CASUAL'];

const schema: yup.ObjectSchema<CreateContractDTO> = yup.object({
    contractType: yup
        .mixed<ContractType>()
        .oneOf(['FULL_TIME', 'PART_TIME', 'CASUAL'])
        .required('Contract type is required')
        .typeError('Select a contract type'),

    startDate: yup
        .date()
        .required('Start date is required')
        .typeError('Select a start date'),

    endDate: yup
        .date()
        .nullable()
        .optional()
        .transform((curr, orig) => orig === '' ? null : curr)
        .typeError('Date must be valid')
        .test(
            'end-after-start',
            'End date must be after start date',
            function (value) {
                const { startDate } = this.parent;
                return !value || !startDate || value > startDate;
            }
        ),

    employeeId: yup
        .number()
        .typeError('Employee is required')
        .required('Employee is required'),

    cost: yup
        .number()
        .typeError('Cost must be a number')
        .required('Cost is required'),

    hours: yup
        .number()
        .nullable()
        .optional()
        .typeError('Hours must be a number'),
});

const ContractForm: React.FC<Props> = ({ onSubmit }) => {
    const {
        register,
        handleSubmit,
        formState: { errors },
    } = useForm<CreateContractDTO>({ resolver: yupResolver(schema) });

    return (
        <form onSubmit={handleSubmit(onSubmit)} className={styles.formContainer}>
            <h2>Create Contract</h2>

            <label>Contract Type</label>
            <select {...register('contractType')}>
                <option value="">Select type</option>
                {contractTypes.map(type => (
                    <option key={type} value={type}>{type}</option>
                ))}
            </select>
            <p>{errors.contractType?.message}</p>

            <label>Start Date</label>
            <input type="date" {...register('startDate')} />
            <p>{errors.startDate?.message}</p>

            <label>End Date</label>
            <input type="date" {...register('endDate')} />
            <p>{errors.endDate?.message}</p>

            <label>Employee ID</label>
            <input type="number" {...register('employeeId')} />
            <p>{errors.employeeId?.message}</p>

            <label>Cost (annual)</label>
            <input type="number" {...register('cost')} />
            <p>{errors.cost?.message}</p>

            <label>Hours (weekly)</label>
            <input type="number" step="0.01" {...register('hours')} />
            <p>{errors.hours?.message}</p>

            <button type="submit">Submit</button>
        </form>
    );
};

export default ContractForm;
