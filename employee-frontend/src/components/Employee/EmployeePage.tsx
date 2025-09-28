import React, { useEffect, useState } from 'react';
import EmployeeCard from './EmployeeCard';
import type { Employee } from '../../types/types';
import { fetchEmployees } from '../../services/dbservice';

const EmployeesPage: React.FC = () => {
    const [employees, setEmployees] = useState<Employee[]>([]);
    const [loading, setLoading] = useState<boolean>(true);

    useEffect(() => {
        fetchEmployees()
            .then(data => {
                setEmployees(data);
                setLoading(false);
            })
            .catch(err => {
                console.error('Failed to fetch employees:', err);
                setLoading(false);
            });
    }, []);

    if (loading) return <p>Loading employees...</p>;

    return (
        <div>
            <h2>Employee Directory</h2>
            <div className="employee-grid">
                {employees.map(emp => (
                    <EmployeeCard key={emp.id} employee={emp} />
                ))}
            </div>
        </div>
    );
};

export default EmployeesPage;