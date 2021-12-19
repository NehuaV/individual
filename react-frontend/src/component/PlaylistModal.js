import React, { useState } from "react";
import { Modal, Button, Form } from "react-bootstrap";
import { useSelector } from "react-redux";
import axios from "axios";

function PlaylistModal(props) {
  var username = useSelector((state) => state.auth.username);
  const [name, setName] = useState();
  const addPlaylistURL = `http://localhost:8080/playlist?playlistName=${name}&userUsername=${username}`;
  async function addPlaylist() {
    await axios.post(addPlaylistURL)
    .then((response) => console.log(response))
    .then(props.onHide)
    .then(() => {
      setName("");
    });
  }

  return (
    <Modal
      {...props}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header>
        <Modal.Title id="contained-modal-title-vcenter">
          Add Playlist
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
          <Form.Group className="mb-3" controlId="playlistName">
            <Form.Label>Playlist Name</Form.Label>
            <Form.Control
              onChange={(e) => {
                setName(e.target.value);
              }}
              type="input"
              placeholder="Enter Playlist Name"
            />
          </Form.Group>
        </Form>
      </Modal.Body>
      <Modal.Footer>
        <Button
          variant="primary"
          onClick={() => {
            addPlaylist();
          }}
        >
          Save
        </Button>
        <Button variant="secondary" onClick={props.onHide}>
          Close
        </Button>
      </Modal.Footer>
    </Modal>
  );
}

export default PlaylistModal;
