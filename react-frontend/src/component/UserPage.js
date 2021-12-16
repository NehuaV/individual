import React from "react";
import { Card } from "react-bootstrap";
import { useSelector } from "react-redux";

import "../css/UserPage.css";


function UserPage() {
  const auth = useSelector((state) => state.auth);

  return (
    <div className="new-bg d-flex justify-content-center">
      <Card className="card-container" border="danger">
        <Card.Img
          className="bg-image"
          variant="top"
          src="https://images.unsplash.com/photo-1530305408560-82d13781b33a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1352&q=80"
        />
        <Card.Body>
          <Card.Img className="pfp-image"></Card.Img>
          <Card.Title>@{auth.username}</Card.Title>
          <Card.Text className="pfp-text">
            A person's description can get faily long at times
          </Card.Text>
          <div className="gray-filler">
            <h5>Playlists</h5>
            <div className="Playlists"></div>
          </div>
        </Card.Body>
      </Card>
    </div>
  );
}

export default UserPage;
