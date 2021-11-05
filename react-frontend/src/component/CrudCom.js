import React from "react";
import { Form, FormGroup, Label, Input, Button } from "reactstrap";
import "../css/CrudCom.css";
import axios from 'axios';

function CrudCom() {
    const [userId, setUserId] = React.useState();
    const [username, setUsername] = React.useState();
    const [email, setEmail] = React.useState();
    const [password, setPassword] = React.useState();


    function createUser() {
        axios
            .post("http://localhost:8080/users/", {
                userId: userId,
                username: username,
                email: email,
                password: password,
            })
            .then((response) => {
                console.log(response);
                axios.get("http://localhost:8080/" + response.data)
            });
    }

    return (
        <div className="wrapper">
            <div className="input-container">
                <Form>
                    <FormGroup>
                        <Label>Inputs</Label>
                        <Input type="input" name="ID" id="input1" placeholder="ID" onChange={event => setUserId(event.target.value)} />
                        <Input type="input" name="username" id="input1" placeholder="Username" onChange={event => setUsername(event.target.value)} />
                        <Input type="input" name="email" id="input1" placeholder="Email" onChange={event => setEmail(event.target.value)} />
                        <Input type="input" name="password" id="input1" placeholder="Password" onChange={event => setPassword(event.target.value)} />
                        <Button type="submit" value="Sign In" onClick={createUser}> Create User </Button>
                    </FormGroup>
                </Form>
            </div>
        </div>
    );
}

export default CrudCom;
