import {useEmployeeForm} from "./useEmployeeForm";
import {EmployeeForm} from "./EmployeeForm";

export function EmployeeFormPage () {
    return <EmployeeForm {...useEmployeeForm()} />
}