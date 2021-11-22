import React,{useState} from "react";
import { useDispatch } from "react-redux";
import { Form, Button, Card } from "react-bootstrap";
import { registerUser } from "../Redux/all";

const Register = (props) => {

  const initialState = {
    username: "",
    email: "",
    password: "",
  };

  const [user, setUser] = useState(initialState);

  const userChange = (event) => {
    const { name, value } = event.target;
    setUser({ ...user, [name]: value });
  };

  const dispatch = useDispatch();

  const saveUser = () => {
    dispatch(registerUser(user))
      .then(() => {
        resetRegisterForm();
        setTimeout(() => {
          props.history.push("/login");
        }, 2000);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const resetRegisterForm = () => {
    setUser(initialState);
  };

  return (
    <>
      <Card >
        <Card.Header>Register</Card.Header>
        <Card.Body>
          <Form onSubmit={saveUser}>
            <Form.Group className="mb-3">
              <Form.Label>Username</Form.Label>
              <Form.Control
                type="username"
                placeholder="Username"
                id="username"
                name="username"
                required
                value={user.username}
                onChange={userChange}
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Email address</Form.Label>
              <Form.Control
                type="email"
                placeholder="Email"
                id="email"
                name="email"
                required
                value={user.email}
                onChange={userChange}
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
                onChange={userChange}
              />
            </Form.Group>
            <Button variant="success" type="submit">
              Submit
            </Button>
          </Form>
        </Card.Body>
      </Card>
    </>
  );
};

export default Register;
