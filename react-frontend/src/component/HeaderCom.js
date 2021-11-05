import React, { useState } from "react";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
} from "reactstrap";

import LoginCom from "./LoginCom.js";
import "../css/HeaderCom.css";

function HeaderCom() {
  const [isOpen, setIsOpen] = useState(false);
  const [showLogin, setShowLogin] = useState(false); // State of Login

  const toggle = () => setIsOpen(!isOpen); // Toggle DropDown menu
  const openModal = () => setShowLogin(!showLogin); // Toggle the Login

  return (
    <>
      <Navbar className="navbar-container" color="light" light expand="md">
        <NavbarBrand href="/">Music Player</NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="ml-auto" navbar>
            <NavItem>
              <NavLink onClick={openModal}>Login</NavLink>
            </NavItem>
          </Nav>
        </Collapse>
      </Navbar>
      <LoginCom showLogin={showLogin} setShowLogin={setShowLogin}></LoginCom>
    </>
  );
}

export default HeaderCom;
