export type EmployeeType =
    'FULL_TIME'
    | 'PART_TIME'
    | 'CASUAl'
    | 'INACTIVE';

export type Department =
    'SALES'
    | 'MARKETING'
    | 'FINANCE'
    | 'TECHNICAL'
    | 'ADMIN';

export type ContractType = 'FULL_TIME' | 'PART_TIME' | 'CASUAL';

export type CreateEmployeeDTO = {
    name: string;
    email: string;
    dob: Date;
    employeeType: string;
    department: string;
}

export type Employee = {
    id: number;
    name: string;
    email: string;
    dob: string;
    age: number;
    salary: number;
    hours: number;
    employeeType: string;
    department: string;
}

export type Contract = {
    id: number;
    type: string;
    startDate: Date;
    endDate: Date;
    employee: string;
    cost: number;
    hours: number;
}

export type CreateContractDTO = {
    contractType: ContractType;
    startDate: Date;
    endDate?: Date | null;
    employeeId: number;
    cost: number;
    hours?: number | null;
}