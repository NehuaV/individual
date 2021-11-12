import React from "react";
import ReactPlayer from "react-player";
import styles from "../css/PlayerReact.css";
import axios from "axios";
import { Button } from "reactstrap";

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
      temp: [],
    };
  }

  async componentDidMount() {
    var songs = [];
    await axios.get("http://localhost:8080/song").then((response) => {
      // this.setState({
      //   songs: response.data,
      // });
      console.log(this.state.songs);
      songs = response.data;
    });
    this.setState({ songs: songs });
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

  handlePlay = () => {
    // Play Stop Functionality
    this.setState({ playing: !this.state.playing });
    console.log(this.state.playing);
  };

  ref = (player) => {
    this.player = player;
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
  };

  render() {
    return (
      <>
        <div className="Player">
          <div className="spinner">
            <div className="spinnerOverlay">
              <ReactPlayer
                ref={this.ref}
                className={styles.reactplayer}
                className="video-pb"
                width="500px"
                height="500px"
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
                /*onReady={() => console.log("onReady")}
            onStart={() => console.log("onStart")}
            onPlay={this.handlePlay}
            onEnablePIP={this.handleEnablePIP}
            onDisablePIP={this.handleDisablePIP}
            onPause={this.handlePause}
            onBuffer={() => console.log("onBuffer")}
            onSeek={(e) => console.log("onSeek", e)}
            onEnded={this.handleEnded}
            onError={(e) => console.log("onError", e)}
            onProgress={this.handleProgress}
            onDuration={this.handleDuration} */
              />
            </div>
          </div>

          <div className="player-buttons">
            <button className="player-button 1" onClick={this.handlePreviousSong}>
              Previous song
            </button>
            <button className="player-button 2" onClick={this.handlePlay}>
              {this.state.playing ? "STOP" : "PLAY"}
            </button>
            <button className="player-button 3" onClick={this.handleNextSong}>
              Next song
            </button>
          </div>

          <div className="volume">
            <label for="customRange3" class="form-label">
              Volume
            </label>
            <input
              type="range"
              class="form-range"
              defaultValue="0.5"
              min="0"
              max="1"
              step="0.01"
              id="customRange3"
              onChange={this.handleVolumeChange}
            />
          </div>
          <div className="pBar">
            <label for="customRange3" class="form-label">
              Pogress
            </label>
            <input
              type="range"
              class="form-range"
              min={0}
              max={1}
              step="any"
              value={this.state.played}
              onMouseDown={this.handleSeekMouseDown}
              onChange={this.handleSeekChange}
              onMouseUp={this.handleSeekMouseUp}
            />
          </div>
        </div>
      </>
    );
  }
}
