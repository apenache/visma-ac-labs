import {Button, TextField} from "@mui/material";
import {Employee, EmployeeError} from "./EmployeeForm.types";
import React from "react";

export interface EmployeeFormProps {
    employee: Employee,
    setEmployee: (employee: Employee) => void,
    employeeError: EmployeeError,
    onSubmit: () => void
}

export function EmployeeForm(props: EmployeeFormProps) {

    const {employee, employeeError} = props;
    return (
        <form autoComplete={'off'}>
            <TextField
                onChange={(e) => props.setEmployee({...employee, firstName: e.currentTarget.value})}
                placeholder={"First Name"}
                value={employee.firstName}
                error={employeeError.firstName != undefined}
                helperText={employeeError.firstName}
            />
            <TextField
                onChange={(e) => props.setEmployee({...employee, lastName: e.currentTarget.value})}
                placeholder={"Last Name"}
                value={employee.lastName}
                error={employeeError.lastName != undefined}
                helperText={employeeError.lastName}
            />
            <Button onClick={(e) => {
                e.preventDefault();
                props.onSubmit();
            }}>
                Submit
            </Button>
        </form>
    )
}