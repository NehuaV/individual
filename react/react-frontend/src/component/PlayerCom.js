import React from "react";
import reactstrap from "reactstrap";
import "../css/PlayerCom.css";
import image from '../images/placeholder.jpg'
import PlayerReact from "./PlayerReact";

function PlayerCom() {

  const coverImg = document.getElementById('coverimg');


  return (
    <>
      <div className="player-wrapper">
        <div className="player-container">
          <div className="player-test">
             <PlayerReact/>
          </div>
        </div>
      </div>
    </>
  );
}

export default PlayerCom;
