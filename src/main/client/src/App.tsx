import { useState } from 'react'
import './App.css'
import {EmployeeForm} from "./Pages/EmployeeForm/EmployeeForm";
import {useEmployeeForm} from "./Pages/EmployeeForm/useEmployeeForm";
import {Counter} from "./Pages/Counter/Counter";

function App() {
  return (
    <div>
      <Counter />
    </div>
  )
}

export default App
