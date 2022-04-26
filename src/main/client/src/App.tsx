import { useState } from 'react'
import logo from './logo.svg'
import './App.css'
import {EmployeeForm} from "./Pages/EmployeeForm/EmployeeForm";
import {useEmployeeForm} from "./Pages/EmployeeForm/useEmployeeForm";

function App() {
  return (
    <div>
      <EmployeeForm {...useEmployeeForm()}/>
    </div>
  )
}

export default App
