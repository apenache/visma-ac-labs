export interface Employee {
    firstName: string,
    lastName: string,
}

export type EmployeeError = {
    [key in keyof Employee]?: string;
};

