import React, { useState } from "react";
import { Modal, Button, Form } from "react-bootstrap";
import { useSelector } from "react-redux";
import axios from "axios";

function AddSongModal(props) {
  var username = useSelector((state) => state.auth.username);
  const addSongURL = `http://localhost:8080/song?userUsername=${username}&playlistId=${props.playlistid}`;
  async function addSong() {
    await axios
      .post(addSongURL, song)
      .then((response) => console.log(response))
      .then(props.onHide)
      .then(() => {
        setSong(initialState);
      });
  }

  const initialState = {
    artist: "",
    title: "",
    url: "",
  };
  const [song, setSong] = useState(initialState);

  const songChange = (event) => {
    const { name, value } = event.target;
    setSong({ ...song, [name]: value });
  };

  return (
    <Modal
      {...props}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header>
        <Modal.Title id="contained-modal-title-vcenter">Add Song</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
          <Form.Group className="mb-3" controlId="playlistName">
            <Form.Label>Song Artist</Form.Label>
            <Form.Control
              onChange={songChange}
              type="artist"
              name="artist"
              value={song.artist}
              placeholder="Artist Name"
            />
            <Form.Label>Song Title</Form.Label>
            <Form.Control
              onChange={songChange}
              type="title"
              name="title"
              value={song.title}
              placeholder="Title Name"
            />
            <Form.Label>Song URL</Form.Label>
            <Form.Control
              onChange={songChange}
              type="url"
              name="url"
              value={song.url}
              placeholder="Song URL"
            />
          </Form.Group>
        </Form>
      </Modal.Body>
      <Modal.Footer>
        <Button
          variant="primary"
          onClick={addSong}
          disabled={!song.artist || !song.title || !song.url}
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

export default AddSongModal;
