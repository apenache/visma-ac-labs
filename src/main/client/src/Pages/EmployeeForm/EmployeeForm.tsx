import {Button, TextField} from "@mui/material";
import {useState} from "react";
import {blankEmployee, Employee} from "./EmployeeForm.types";

export function EmployeeForm() {
    const [employee, setEmployee] = useState<Employee>(blankEmployee)

    return (
        <form autoComplete={'off'}>
            <TextField value={employee.firstName} placeholder={'First Name'} onChange={(e) => {
                const newEmployee: Employee = {...employee, firstName: e.currentTarget.value}
                setEmployee(newEmployee)
            }}/>
            <TextField value={employee.lastName} placeholder={'Last Name'} onChange={(e) => {
                const newEmployee: Employee = {...employee, lastName: e.currentTarget.value}
                setEmployee(newEmployee)
            }}/>
            <Button onClick={(e) => {
                console.log(employee);
            }}>
                Submit
            </Button>
        </form>
    )
}