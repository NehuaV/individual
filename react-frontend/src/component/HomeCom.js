import React from "react";
import "../css/HomeCom.css";
import { useSelector } from "react-redux";

function HomeCom() {
  const auth = useSelector((state) => state.auth);
  return (
    <>
      {auth.isLoggedIn ? (
        <section className="banner 1">
          <div className="text">
            <h1 className="title">Welcome {auth.username}!</h1>
          </div>
        </section>
      ) : (
        <>
          <section className="banner 1">
            <div className="text">
              <h1 className="title">Music Player!</h1>
            </div>
          </section>
        </>
      )}
    </>
  );
}

export default HomeCom;
