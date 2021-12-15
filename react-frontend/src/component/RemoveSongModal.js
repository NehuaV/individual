import React from "react";
import { Modal, Button } from "react-bootstrap";
import { useSelector } from "react-redux";
import axios from "axios";

function RemoveSongModal(props) {
  var username = useSelector((state) => state.auth.username);
  const deletePlaylistURL = `http://localhost:8080/song?userUsername=${username}&songId=${props.songid}`
  async function removePlaylist(){
      await axios.delete(deletePlaylistURL)
      .then((response)=> console.log(response))
      .then(props.onHide);
    }
  

  return (
    <Modal
      {...props}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header>
        <Modal.Title id="contained-modal-title-vcenter">Delete</Modal.Title>
      </Modal.Header>
      <Modal.Body>Do you really wish to delete this song?</Modal.Body>
      <Modal.Footer>
        <Button onClick={removePlaylist} variant="primary">
          Delete
        </Button>
        <Button variant="secondary" onClick={props.onHide}>
          Close
        </Button>
      </Modal.Footer>
    </Modal>
  );
}

export default RemoveSongModal;
