import React, { useState } from "react";
import SockJsClient from "react-stomp";

import { Card, Form, Button } from "react-bootstrap";

import "bootstrap/dist/css/bootstrap.min.css";

const SOCKET_URL = "http://localhost:8080/websocket";
const GENERAL_TOPIC = "/topic/general";

const App = () => {
  let generalClientRef;
  const [text, setText] = useState("");
  const [messages, setMessages] = useState([]);

  const onConnected = () => {
    console.log("Connected.");
  };
  const onDisconnected = () => {
    console.log("Disconnected.");
  };

  const onMessageReceived = async (msg) => {
    setMessages((prev) => [...prev, msg]);
  };

  const sendMessage = (msg) => {
    generalClientRef.sendMessage(
      GENERAL_TOPIC,
      JSON.stringify({ message: msg })
    );
  };
  const textChangeHandler = (event) => {
    setText(event.target.value);
  };

  const submitHandler = (event) => {
    event.preventDefault();
    sendMessage(text);
  };

  return (
    <Card>
      <SockJsClient
        url={SOCKET_URL}
        topics={[GENERAL_TOPIC]}
        heartbeatIncoming={100}
        onConnect={onConnected}
        onDisconnect={onDisconnected}
        onMessage={(msg) => onMessageReceived(msg)}
        debug={true}
        ref={(client) => {
          generalClientRef = client;
        }}
      />
      <Card.Header>
        <Form>
          <Form.Group>
            <Form.Label>Write Messages!</Form.Label>
            <br/>
            <div className="d-flex">
              <Form.Control
                type="text"
                placeholder="Write a message"
                onChange={textChangeHandler}
              />
              <Button type="submit" onClick={submitHandler}>
                Send
              </Button>
            </div>
          </Form.Group>
        </Form>
      </Card.Header>

      <Card.Body>
        <Card.Title>Messages Channel</Card.Title>
        <Card.Text>
          {messages.map((msg, index) => (
            <li key={index}>{msg.message}</li>
          ))}
        </Card.Text>
      </Card.Body>
    </Card>
  );
};

export default App;
