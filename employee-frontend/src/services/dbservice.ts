import type { CreateEmployeeDTO, Employee } from "../types/types";

const BASE_URL: string = 'http://localhost:8080'

export async function fetchEmployees(): Promise<Employee[]> {
    const response = await fetch(`${BASE_URL}/employees`);

    if (!response.ok) {
        throw new Error(`Failed to fetch employees: ${response.statusText}`);
    }

    const data: [] = await response.json();
    console.log(data);
    return data;
}

export async function addEmployee(employee: CreateEmployeeDTO): Promise<[]> {
    const response = await fetch(`${BASE_URL}/employees`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(employee)
    });

    if (!response.ok) {
        throw new Error(`Failed to create employeee: ${response.statusText}`);
    }

    const data: [] = await response.json();
    return data;
}