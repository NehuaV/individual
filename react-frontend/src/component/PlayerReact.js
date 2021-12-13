import React from "react";
import ReactPlayer from "react-player";
import axios from "axios";
import { Button, Offcanvas } from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faPlus,
  faPlayCircle,
  faPauseCircle,
  faForward,
  faBackward,
} from "@fortawesome/free-solid-svg-icons";

import PlaylistModal from "./PlaylistModal.js";

import "../css/PlayerReact.css";
import authToken from "../Redux/authToken";

export default class PlayerReact extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      // State Reloads Component every time the state has been changed

      // Player functionality
      url: null, // Cuurently playing song
      pip: false,
      playing: false,
      controls: false,
      light: false,
      volume: 0.5, // Volume
      muted: false, // Mute
      played: 0, // Change FF on video/track
      loaded: 0, // Loaded Portion
      duration: 0, // Display Duration
      playbackRate: 1.0, // Speed
      loop: false,

      // List of Songs
      songs: [],
      // List of Playlist Info
      playlists: [],

      // Offcanvas
      show: false,
      config: {
        name: "Disable backdrop",
        scroll: false,
        backdrop: true,
        placement: "end",
        backdropClassName: "bckdrp",
      },
      // Add Playlist Popup
      modalShow: false,
    };
  }

  async componentDidMount() {
    var playlists = [];
    authToken(localStorage.jwtToken);
    await axios
      .get("http://localhost:8080/playlist?userUsername=" + this.props.username)
      .then((response) => {
        playlists = response.data;
      });
    this.setState({ songs: playlists[0].songs });
    this.setState({ url: this.state.songs[0].url });
    console.log(this.state.songs);
    /* 
    Setting response data directly into songs state makes videos not load.
    It is some sort of synchronization error or an error from the load order.
     */
  }

  load = (url) => {
    // Loads the video we wish to see
    this.setState({
      url,
      played: 0,
      loaded: 0,
      pip: false,
    });
    console.log({ url });
  };

  ref = (player) => {
    this.player = player;
  };

  // Player Controls (Next,Play/Pause,Previous)
  handlePlay = () => {
    // Play Stop Functionality
    this.setState({ playing: !this.state.playing });
    console.log(this.state.playing);
  };

  handleNextSong = () => {
    if (this.state.songs.length > 1) {
      var lenght = 0;
      var index = this.state.songs.findIndex(
        (urlObj) => urlObj.url === this.state.url
      );
      index++;
      this.state.songs.map((song) => lenght++);
      if (!(index < lenght)) index = 0;
      this.load(this.state.songs[index].url);
    }
  };

  handlePreviousSong = () => {
    if (this.state.songs.length > 1) {
      var lenght = 0;
      var index = this.state.songs.findIndex(
        (urlObj) => urlObj.url === this.state.url
      );
      index--;
      this.state.songs.map((song) => lenght++);
      if (index < 0) index = lenght - 1;
      this.load(this.state.songs[index].url);
    }
  };

  // Volume
  handleVolumeChange = (e) => {
    this.setState({ volume: parseFloat(e.target.value) });
  };

  // Progress Bar
  handleSeekMouseDown = (e) => {
    this.setState({ seeking: true });
  };

  handleSeekChange = (e) => {
    this.setState({ played: parseFloat(e.target.value) });
  };

  handleSeekMouseUp = (e) => {
    this.setState({ seeking: false });
    this.player.seekTo(parseFloat(e.target.value, true));
  };

  handleProgress = (state) => {
    // Update the duration slider
    // console.log("onProgress", state);
    // Only update if we are not changing the position of the song
    if (!this.state.seeking) {
      this.setState(state);
    }
    this.handleAutoPlay(this.state);
  };

  handleAutoPlay = (state) => {
    if (this.state.played > 0.99) {
      this.handleNextSong();
    }
  };

  // OffCanvas (Playlists)
  handleClose = () => this.setState({ show: false });
  toggleShow = () => {
    this.loadPlaylists();
    this.setState({ show: !this.state.show });
  };

  async loadPlaylists() {
    var temp = [];
    await axios
      .get("http://localhost:8080/playlist?userUsername=" + this.props.username)
      .then((response) => {
        console.log(response.data);
        temp = response.data;
      })
      .then(() => {
        this.setState({ playlists: temp });
      });
    console.log(this.state.playlists);
  }

  selectPlaylist = (e) => {
    var tempsongs = [];
    console.log(e.target.getAttribute("data-index"));
    this.state.playlists.forEach(function (item) {
      if (item.id.toString() === e.target.getAttribute("data-index"))
        tempsongs = item.songs;
    });
    console.log(tempsongs);
    this.setState({ songs: tempsongs });
    if (tempsongs[0] != null) {
      this.setState({ url: tempsongs[0].url });
    } else {
      // If the the playlist is empty provide an awsome video of cute weasels
      this.setState({ url: "https://youtu.be/PBCpv-1qVD4?t=13" });
    }
    this.handleClose();
  };

  render() {
    return (
      <>
        <div className="Player">
          <div className="spinner">
            <div className="spinnerOverlay">
              <ReactPlayer
                ref={this.ref}
                className="video-pb"
                width="250px"
                height="250px"
                url={this.state.url}
                pip={this.state.pip}
                playing={this.state.playing}
                controls={this.state.controls}
                light={this.state.light}
                loop={this.state.loop}
                playbackRate={this.state.playbackRate}
                volume={this.state.volume}
                muted={this.state.muted}
                onProgress={this.handleProgress}
              />
            </div>
          </div>

          <div className="player-buttons">
            <button
              className="player-button 1"
              onClick={this.handlePreviousSong}
            >
              <FontAwesomeIcon icon={faBackward} color="red" />
            </button>
            <button className="player-button 2" onClick={this.handlePlay}>
              {this.state.playing ? (
                <FontAwesomeIcon icon={faPauseCircle} color="red" />
              ) : (
                <FontAwesomeIcon icon={faPlayCircle} color="green" />
              )}
            </button>
            <button className="player-button 3" onClick={this.handleNextSong}>
            <FontAwesomeIcon icon={faForward} color="red" />
            </button>
          </div>

          <div className="volume">
            <label className="form-label">Volume</label>
            <input
              type="range"
              className="form-range"
              defaultValue="0.5"
              min="0"
              max="1"
              step="0.01"
              id="customRange3"
              onChange={this.handleVolumeChange}
            />
          </div>
          <div className="pBar">
            <label className="form-label">Pogress</label>
            <input
              type="range"
              className="form-range"
              min={0}
              max={1}
              step="any"
              value={this.state.played}
              onMouseDown={this.handleSeekMouseDown}
              onChange={this.handleSeekChange}
              onMouseUp={this.handleSeekMouseUp}
            />
          </div>

          <Button variant="primary" onClick={this.toggleShow} className="me-2">
            Open Playlist
          </Button>
          <Offcanvas
            show={this.state.show}
            onHide={this.handleClose}
            {...this.state.config}
          >
            <Offcanvas.Header closeButton>
              <FontAwesomeIcon
                className="add-btn"
                onClick={() => this.setState({ modalShow: true })}
                icon={faPlus}
                color="grey"
              />
              <Offcanvas.Title>Playlists</Offcanvas.Title>
            </Offcanvas.Header>
            <Offcanvas.Body>
              {this.state.playlists.map((obj) => (
                <Button
                  key={obj.id}
                  data-index={obj.id}
                  onClick={this.selectPlaylist}
                  className="playlistBtn"
                >
                  {obj.name}
                </Button>
              ))}
            </Offcanvas.Body>
          </Offcanvas>
          <PlaylistModal
            show={this.state.modalShow}
            onHide={() => {
              this.setState({ modalShow: false });
              this.loadPlaylists();
            }}
          />
        </div>
      </>
    );
  }
}
