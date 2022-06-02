import {EmployeeListProps} from "./EmployeeList";

export function useEmployeeList(): EmployeeListProps {

    return {
        employees: [
            {
                id: 0,
                firstName: "John",
                lastName: "Doe",
                salary: 4000
            },
            {
                id: 0,
                firstName: "John",
                lastName: "Doe",
                salary: 4000
            },
            {
                id: 0,
                firstName: "John",
                lastName: "Doe",
                salary: 4000
            },
        ]
    };
}