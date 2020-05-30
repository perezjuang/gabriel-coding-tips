import React, { useState } from "react";

const AddEmployeeForm = (props) => {

const initialFormState = { id: null, firstName: "", lastName: "" , email: ""};
const [employee, setEmployee] = useState(initialFormState);


const handleInputChange = (event) => {
  const { name, value } = event.target;
        //console.log(event);
  setEmployee({ ...employee, [name]: value });
};


  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (!employee.firstName || !employee.lastName || !employee.email)
          return;

        props.addEmployee(employee);
        setEmployee(initialFormState);
      }}
    >
      <label>First Name</label>
      <input
        type="text"
        name="firstName"
        value={employee.firstName}
        onChange={handleInputChange}
      />
      <label>Username</label>
      <input
        type="text"
        name="lastName"
        value={employee.lastName}
        onChange={handleInputChange}
      />

      <label>email</label>
      <input
        type="text"
        name="email"
        value={employee.email}
        onChange={handleInputChange}
      />
      <button>Add new employee</button>
    </form>
  );
};
export default AddEmployeeForm;