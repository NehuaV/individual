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
  faTrashAlt,
  faMusic,
  faTimes,
  faVolumeUp,
} from "@fortawesome/free-solid-svg-icons";

import PlaylistModal from "./PlaylistModal.js";

import "../css/PlayerReact.css";
import authToken from "../Redux/authToken";
import AddSongModal from "./AddSongModal.js";
import RemovePlaylistModal from "./RemovePlaylistModal.js";
import RemoveSongModal from "./RemoveSongModal.js";

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
      song: {},
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
      modalPlaylistShow: false,
      modalSongShow: false,
      modalRemovePlaylist: false,
      modalRemoveSong: false,
      playlistId: "",
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
    this.songReference(playlists[0].songs[0]);
    this.setState({ url: this.state.songs[0].url });
    console.log(this.state.songs);
    /* 
    Setting response data directly into songs state makes videos not load.
    It is some sort of synchronization error or an error from the load order.
     */
  }

  songReference = (song) => {
    this.setState({ song: song });
    console.log(song.data);
    console.log(this.state.song);
  };

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

  handleNextSong = async () => {
    if (this.state.songs.length > 1) {
      var lenght = 0;
      var index = this.state.songs.findIndex(
        (urlObj) => urlObj.url === this.state.url
      );
      await index++;
      this.state.songs.map((song) => lenght++);
      if (!(index < lenght)) index = 0;
      this.load(this.state.songs[index].url);
      this.songReference(this.state.songs[index]);
    }
  };

  handlePreviousSong = async () => {
    if (this.state.songs.length > 1) {
      var lenght = 0;
      var index = this.state.songs.findIndex(
        (urlObj) => urlObj.url === this.state.url
      );
      await index--;
      this.state.songs.map((song) => lenght++);
      if (index < 0) index = lenght - 1;
      this.load(this.state.songs[index].url);
      this.songReference(this.state.songs[index]);
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
        console.log("Data received");
        temp = response.data;
      })
      .then(() => {
        this.setState({ playlists: temp });
      });
    console.log(this.state.playlists);
  }

  // Reload Current Playlist based on ID
  async reloadPlaylist(){

  }

  selectPlaylist = async (e) => {
    var tempsongs = [];
    console.log(e.target.getAttribute("data-index"));
    this.state.playlists.forEach(function (item) {
      if (item.id.toString() === e.target.getAttribute("data-index"))
        tempsongs = item.songs;
    });
    console.log(tempsongs);
    await this.setState({ songs: tempsongs });
    if (tempsongs[0] != null) {
      await this.setState({ url: tempsongs[0].url });
      this.songReference(this.state.songs[0]);
    } else {
      // If the the playlist is empty provide an awsome video of cute weasels
      this.setState({ url: "https://youtu.be/PBCpv-1qVD4?t=13" });
    }
    this.handleClose();
  };

  handlePlaylistId = (e) => {
    this.setState({ modalSongShow: true });
    console.log(e.target.getAttribute("playlistid"));
    this.setState({ playlistId: e.target.getAttribute("playlistid") });
  };

  handleLatestSong() {
    this.setState({ url: this.state.songs[this.state.songs.length - 1].url });
    console.log(this.state.songs);
    console.log(this.state.url);
  }

  handleDeletePlaylist = (e) => {
    this.setState({ modalRemovePlaylist: true });
    console.log(e.target.getAttribute("playlistid"));
    this.setState({ playlistId: e.target.getAttribute("playlistid") });
  };

  handleDeleteSong = () => {
    this.setState({ modalRemoveSong: true });
  }

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
              <FontAwesomeIcon icon={faBackward} color="gray" />
            </button>
            <button className="player-button 2" onClick={this.handlePlay}>
              {this.state.playing ? (
                <FontAwesomeIcon icon={faPauseCircle} color="gray" />
              ) : (
                <FontAwesomeIcon icon={faPlayCircle} color="red" />
              )}
            </button>
            <button className="player-button 3" onClick={this.handleNextSong}>
              <FontAwesomeIcon icon={faForward} color="gray" />
            </button>
          </div>

          <div className="volume">
          <FontAwesomeIcon className="volumebtn" icon={faVolumeUp} color="blue" />
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
            <label className="form-label">Time Elapsed: {this.state.playedseconds}</label>
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
          <Button
            variant="secondary"
            className="me-2"
            onClick={this.handleDeleteSong}
            style={{
              display:
                this.state.url === "https://youtu.be/PBCpv-1qVD4?t=13"
                  ? "none"
                  : "",
            }}
          >
            Delete Song
          </Button>

          <Offcanvas
            show={this.state.show}
            onHide={this.handleClose}
            {...this.state.config}
          >
            <Offcanvas.Header>
              <button
                className="offbtn"
                onClick={() => this.setState({ modalPlaylistShow: true })}
              >
                <FontAwesomeIcon icon={faPlus} color="grey" />
              </button>
              <Offcanvas.Title>Playlists</Offcanvas.Title>
              <button className="offbtn" onClick={this.handleClose}>
                <FontAwesomeIcon icon={faTimes} color="grey" />
              </button>
            </Offcanvas.Header>
            <Offcanvas.Body>
              <div className="playlist-menu">
                {this.state.playlists.map((obj) => (
                  <div className="buttongroup" key={obj.id}>
                    <button
                      className="offbtn"
                      onClick={this.handlePlaylistId}
                      playlistid={obj.id}
                    >
                      <FontAwesomeIcon color="grey" icon={faMusic} />
                    </button>
                    <div
                      data-index={obj.id}
                      onClick={this.selectPlaylist}
                      className="playlistBtn"
                    >
                      {obj.name}
                    </div>
                    <button
                      className="offbtn"
                      onClick={this.handleDeletePlaylist}
                      playlistid={obj.id}
                    >
                      <FontAwesomeIcon color="grey" icon={faTrashAlt} />
                    </button>
                  </div>
                ))}
              </div>
            </Offcanvas.Body>
          </Offcanvas>
          <PlaylistModal
            show={this.state.modalPlaylistShow}
            onHide={() => {
              this.loadPlaylists();
              this.setState({ modalPlaylistShow: false });
            }}
          />
          <AddSongModal
            playlistid={this.state.playlistId}
            show={this.state.modalSongShow}
            onHide={() => {
              this.loadPlaylists();
              this.setState({ modalSongShow: false });
            }}
          />

          <RemovePlaylistModal
            playlistid={this.state.playlistId}
            show={this.state.modalRemovePlaylist}
            onHide={() => {
              this.loadPlaylists();
              this.setState({ modalRemovePlaylist: false });
            }}
          />

          <RemoveSongModal
            songid={this.state.song.id}
            show={this.state.modalRemoveSong}
            onHide={() => {
              this.loadPlaylists();
              this.setState({ modalRemoveSong: false });
            }}
          />
        </div>
      </>
    );
  }
}
