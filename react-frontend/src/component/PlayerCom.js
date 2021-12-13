import React from "react";
import "../css/PlayerCom.css";
import PlayerReact from "./PlayerReact";
import { useSelector } from "react-redux";

function PlayerCom() {
  // Pass username to PlayerReact Component
  var username = useSelector((state) => state.auth.username);

  return (
    <>
      <div className="player-wrapper">
        <div className="player-container">
          <div className="player-test">
            <PlayerReact username={username} />
          </div>
        </div>
      </div>
    </>
  );
}

export default PlayerCom;
