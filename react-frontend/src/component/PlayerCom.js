import React from "react";
import "../css/PlayerCom.css";
import PlayerReact from "./PlayerReact";

function PlayerCom() {
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
