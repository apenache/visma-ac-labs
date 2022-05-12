import {Button, TextField} from "@mui/material";
import {useState} from "react";
import {blankEmployee, Employee, EmployeeError} from "./EmployeeForm.types";

export type EmployeeFormProps = {
    employee: Employee,
    setEmployee: (employee: Employee) => void,
    error: EmployeeError,
    submit: () => void;
}

export function EmployeeForm(props: EmployeeFormProps) {
    const { employee, setEmployee, error, submit} = props;
    return (
        <form autoComplete={'off'}>
            <TextField
                value={props.employee.firstName}
                placeholder={'First Name'}
                onChange={(e) => {
                    const newEmployee: Employee = {...employee, firstName: e.currentTarget.value}
                    setEmployee(newEmployee)
                }}
                error={props.error.firstName !== undefined}
                helperText={props.error.firstName}
            />
            <TextField
                value={props.employee.lastName}
                placeholder={'Last Name'}
                onChange={(e) => {
                    const newEmployee: Employee = {...employee, lastName: e.currentTarget.value}
                    setEmployee(newEmployee)
                }}
                error={error.lastName !== undefined}
                helperText={error.lastName}
            />
            <Button onClick={(e) => {
                submit()
            }}>
                Submit
            </Button>
        </form>
    )
}