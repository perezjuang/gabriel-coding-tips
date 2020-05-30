import React from "react";

const EmployeeTable = (props) => (
  <table>
    <thead>
      <tr>
        <th>ID BD</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>email</th>
      </tr>
    </thead>
    <tbody>
      {undefined !== props.employees && props.employees.length > 0 ? (
        props.employees.map((employee) => (
          <tr key={employee.id.toString()}>
            <td>{employee.id}</td>
            <td>{employee.firstName}</td>
            <td>{employee.lastName}</td>
            <td>{employee.email}</td>
            <td>
              <button
                onClick={() => {
                  props.editRow(employee);
                }}
                className="button muted-button"
              >
                Edit
              </button>
              <button
                onClick={() => props.deleteEmployee(employee.id)}
                className="button muted-button"
              >
                Delete
              </button>
            </td>
          </tr>
        ))
      ) : (
        <tr>
          <td colSpan={3}>No employee</td>
        </tr>
      )}
    </tbody>
  </table>
);

export default EmployeeTable;
