import React, { useState, useEffect } from "react";
import "./Employee.scss";
import EmployeeTable from "./EmployeeTable";
import AddEmployeeForm from "./AddEmployeeForm";
import EditEmployeeForm from "./EditEmployeeForm";
import axios from "axios";

const Employee = () => {
  const EmployeeData = [
    { id: 1, firsName: "Juan", lastName: "Tania", email: "floppydiskette" },
    { id: 2, firsName: "Perez", lastName: "Craig", email: "siliconeidolon" },
    { id: 3, firsName: "guerra", lastName: "Ben", email: "benisphere" },
  ];
  const [employees, setEmployees] = useState(EmployeeData);
  const [showLoading, setShowLoading] = useState(true);
  const apiUrl = "http://localhost:8282/employeeAPI/";

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(apiUrl + "employeegetall");
      setEmployees(result.data.employeeList);
    };
    fetchData();
  }, []);




  const addEmployee = (employee) => {
    setShowLoading(true);
    const data = {
      id: employee.id,
      firstName: employee.firstName,
      lastName: employee.lastName,
      email: employee.email,
    };
    axios
      .post(apiUrl + "addemployee", data)
      .then((result) => {
        setEmployees([...employees, result.data]);
      })
      .catch((error) => setShowLoading(false));

    /*
    employee.id = employees.length + 1;
    setEmployees([...employees, employee]);

    const data = {
      id: parseInt(employee.id),
      firstName: employee.firstName,
      lastName: employee.lastName,
      email: employee.email,
    };

    axios
      .post(apiUrl, data)
      .then((result) => {
        //props.history.push('/show/' + result.data._id)
        console.log("Consumo del Servicio 2");
        console.log(result);
      })
      .catch((error) => setShowLoading(false));
*/
  };

  const deleteEmployee = (id) => {
    setEmployees(employees.filter((employee) => employee.id !== id));
    const data = {
      id: id,
      firstName: "",
      lastName: "",
      email: "",
    };
    axios
      .post(apiUrl + "employeeremove", data)
      .then((result) => {
        //console.log(result);
      })
      .catch((error) => setShowLoading(false));
  };

  const [editing, setEditing] = useState(false);

  const initialFormState = {
    id: null,
    firstName: "",
    lastName: "",
    email: "",
  };

  const [currentEmployee, setCurrentEmployee] = useState(initialFormState);

  const editRow = (employee) => {
    setEditing(true);
    setCurrentEmployee({
      id: employee.id,
      firstName: employee.firstName,
      lastName: employee.lastName,
      email: employee.email,
    });
  };

  const updateEmployee = (id, updatedEmployee) => {
    setEditing(false);
    setEmployees(
      employees.map((employee) =>
        employee.id === id ? updatedEmployee : employee
      )
    );
    const data = {
      id: updatedEmployee.id,
      firstName: updatedEmployee.firstName,
      lastName: updatedEmployee.lastName,
      email: updatedEmployee.email,
    };
    axios
      .post(apiUrl + "updateemployee", data)
      .then((result) => {
        //console.log("Updated");
      })
      .catch((error) => setShowLoading(false));
  };

  return (
    <div className="container">
      <h1>CRUD App with Hooks</h1>
      <div className="flex-row">
        <div className="flex-large">
          {editing ? (
            <div>
              <h2>Edit Employee</h2>
              <EditEmployeeForm
                setEditing={setEditing}
                currentEmployee={currentEmployee}
                updateEmployee={updateEmployee}
              />
            </div>
          ) : (
            <div>
              <h2>Add employee</h2>
              <AddEmployeeForm addEmployee={addEmployee} />
            </div>
          )}
        </div>

        <div className="flex-large">
          <h2>View Employees</h2>
          <EmployeeTable
            employees={employees}
            deleteEmployee={deleteEmployee}
            editRow={editRow}
          />
        </div>
      </div>
    </div>
  );
};

export default Employee;
