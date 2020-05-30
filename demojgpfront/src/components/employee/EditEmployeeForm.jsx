import React, { useState, useEffect } from "react";

const EditEmployeeForm = (props) => {
  const [employee, setEmployee] = useState(props.currentEmployee);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setEmployee({ ...employee, [name]: value });
  };

  useEffect(() => {
    setEmployee(props.currentEmployee);
  }, [props]);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        props.updateEmployee(employee.id, employee);
      }}
    >
      <label>First Name</label>
      <input
        type="text"
        name="firstName"
        value={employee.firstName}
        onChange={handleInputChange}
      />
      <label>Last name</label>
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

      <button>Update employee</button>
      <button
        onClick={() => props.setEditing(false)}
        className="button muted-button"
      >
        Cancel
      </button>
    </form>
  );
};

export default EditEmployeeForm;
