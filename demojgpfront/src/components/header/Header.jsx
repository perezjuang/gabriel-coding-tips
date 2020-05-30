import React from "react";
import './Header.scss';
import { Link } from "react-router-dom";
//import "../assets/styles/components/Header.scss";
import logo from "../../assets/static/parkmobile.png";


const Header = () => (
  <header className="header">
    <Link to="/">
      <img className="header__img" src={logo} alt="Logo" />
    </Link>

    <div className="header__menu">
      <div className="header__menu--profile">
        <img src="{ userIcon }" alt="" />
        <p>Menu 1</p>
      </div>
      <ul>
        <li>
          <a href="/">Home</a>
        </li>
        <li>
          <a href="/Employee">Link Vieja Escuela Empleado</a>
        </li>
        <li>
          <Link to="/Employee">Empleado</Link>
        </li>
      </ul>
    </div>
  </header>
);
export default Header;
