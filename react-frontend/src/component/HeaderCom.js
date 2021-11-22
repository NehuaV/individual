import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { Navbar, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";
import "../css/HeaderCom.css";
import { logoutUser } from "../Redux/all";

const HeaderCom = () => {
  const auth = useSelector((state) => state.auth);
  const dispatch = useDispatch();

  const logout = () => {
    dispatch(logoutUser());
  };

  return (
    <div>
      <Navbar className="color-nav" expand="lg" sticky="top">
        <Link to={""} className="navbar-brand">
          MusicPlayer
        </Link>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          {auth.isLoggedIn ? (
            <>
              <Nav className="mr-auto">
                <Link to={"player"} className="nav-link">
                  MusicPlayer
                </Link>
                <Link to={"logout"} className="nav-link" onClick={logout}>
                  Logout
                </Link>
              </Nav>
            </>
          ) : (
            <>
              <Nav className="mr-auto">
                <Link to={"login"} className="nav-link">
                  Login
                </Link>
                <Link to={"register"} className="nav-link">
                  Register
                </Link>
              </Nav>
            </>
          )}
        </Navbar.Collapse>
      </Navbar>
    </div>
  );
};

export default HeaderCom;
