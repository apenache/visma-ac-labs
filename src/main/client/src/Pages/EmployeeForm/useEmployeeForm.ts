import {useState} from "react";
import {Employee, EmployeeError} from "./EmployeeForm.types";

export function useEmployeeForm() {
    const [employee, setEmployee] = useState<Employee>({firstName: '', lastName: ''})
    const [employeeError, setEmployeeError] = useState<EmployeeError>({} as EmployeeError)

    function validateEmployee() {
        const newError: EmployeeError = {}
        const {firstName, lastName} = employee;
        if(firstName?.length === 0)
            newError.firstName = 'First name cannot be empty'
        if(lastName?.length === 0)
            newError.lastName = 'Last name cannot be empty'
        setEmployeeError(newError)

    }

    async function onSubmit() {
        console.log('Employee: ', employee);
        validateEmployee();
        console.log('EmployeeError: ', employeeError);
        if(Object.keys(employeeError).length === 0) {
            await window.fetch('/api/employee/', {
                method: 'POST',
                body: JSON.stringify(employee),
                headers: {
                    'content-type': 'application/json',
                },
            })
        }
    }

    return {
        employee, setEmployee, employeeError, setEmployeeError, onSubmit
    }
}