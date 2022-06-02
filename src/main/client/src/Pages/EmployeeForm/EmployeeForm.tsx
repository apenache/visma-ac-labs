import {Button, TextField} from "@mui/material";
import {useState} from "react";
import {blankEmployee, Employee, EmployeeError} from "./EmployeeForm.types";
import './EmployeeForm.css';

export type EmployeeFormProps = {
    employee: Employee,
    setEmployee: (employee: Employee) => void,
    error: EmployeeError,
    submit: () => void;
}

export function EmployeeForm(props: EmployeeFormProps) {
    const { employee, setEmployee, error, submit} = props;
    return (
        <form autoComplete={'off'} className={"employee-form__form"}>
            <h1>Employee</h1>
            <TextField
                value={props.employee.firstName}
                label={'First Name'}
                onChange={(e) => {
                    const newEmployee: Employee = {...employee, firstName: e.currentTarget.value}
                    setEmployee(newEmployee)
                }}
                error={props.error.firstName !== undefined}
                helperText={props.error.firstName}
            />
            <TextField
                value={props.employee.lastName}
                label={'Last Name'}
                onChange={(e) => {
                    const newEmployee: Employee = {...employee, lastName: e.currentTarget.value}
                    setEmployee(newEmployee)
                }}
                error={error.lastName !== undefined}
                helperText={error.lastName}
            />
            <TextField
                value={props.employee.salary}
                label={'Salary'}
                type="number"
                onChange={(e) => {
                    const newEmployee: Employee = {...employee, salary: +e.currentTarget.value}
                    setEmployee(newEmployee)
                }}
                error={error.salary !== undefined}
                helperText={error.salary}
            />
            <Button variant={"contained"} onClick={(e) => {
                submit()
            }}>
                Submit
            </Button>
        </form>
    )
}