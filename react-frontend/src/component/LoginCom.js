import React from "react";
import { Button, Form, FormGroup, Label, Input } from "reactstrap";
import ReactDOM from "react-dom";

import "../css/LoginCom.css";

export default function LoginCom({ showLogin, setShowLogin }) {
  const openModal = () => setShowLogin(!showLogin); // Toggle the Login
  return ReactDOM.createPortal(
    <>
      {showLogin ? (
        <div>
          <div className="overlay">
            <div className="wrapper-login">
              <Form className="login-form">
                <Button className="close-btn" onClick={openModal}>X</Button>
                <FormGroup>
                  <Label className="login-info" for="exampleEmail">Email</Label>
                  <Input
                    type="email"
                    name="email"
                    id="email"
                    placeholder="Email"
                  />
                </FormGroup>
                <FormGroup>
                  <Label className="login-info" for="examplePassword">Password</Label>
                  <Input
                    type="password"
                    name="password"
                    id="password"
                    placeholder="Password"
                  />
                </FormGroup>
                <Button className="login-btn">Login</Button>
              </Form>
            </div>
          </div>
        </div>
      ) : null}
    </>,
    document.getElementById("portal")
  );
}
