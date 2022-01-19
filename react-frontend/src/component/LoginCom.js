import React, { useState } from "react";
import { Form, Button, Card } from "react-bootstrap";
import { useDispatch } from "react-redux";
import { authenticateUser } from "../Redux/all";

import "../css/LoginCom.css";

const LoginCom = (props) => {
  const initialState = {
    username: "",
    password: "",
  };

  const [user, setUser] = useState(initialState);

  const credentialChange = (event) => {
    const { name, value } = event.target;
    setUser({ ...user, [name]: value });
  };

  const dispatch = useDispatch();

  const validateUser = () => {
    dispatch(authenticateUser(user.username, user.password))
      .then((response) => {
        console.log(response.data);
        return props.history.push("/");
      })
      .catch((error) => {
        console.log(error.message);
        resetLoginForm();
      });
  };

  const resetLoginForm = () => {
    setUser(initialState);
  };

  return (
    /*  IMPLEMENT AN ERROR MESSAGE YOU LAZY SHIT*/
    <>
      <div className="background"></div>
      <div className="loginContainer">
        <Card className="border border-white bg-light text-black">
          <Card.Header>Login</Card.Header>
          <Card.Body>
            <Form>
              <Form.Group className="mb-3">
                <Form.Label>Username</Form.Label>
                <Form.Control
                  type="username"
                  placeholder="Username"
                  id="username"
                  name="username"
                  required
                  value={user.username}
                  onChange={credentialChange}
                />
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>Password</Form.Label>
                <Form.Control
                  type="password"
                  placeholder="Password"
                  id="password"
                  name="password"
                  required
                  value={user.password}
                  onChange={credentialChange}
                />
              </Form.Group>

              <Button
                variant="primary"
                type="button"
                name="btn"
                onClick={validateUser}
                disabled={!user.username || !user.password}
              >
                Submit
              </Button>
            </Form>
          </Card.Body>
        </Card>
      </div>
    </>
  );
};

export default LoginCom;
