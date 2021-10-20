import React from "react";
import ReactPlayer from "react-player";
import styles from "../css/PlayerReact.css";

export default class PlayerReact extends React.Component {
  constructor() {
    super();
    this.state = {
      // State Reloads Component every time the state has been changed

      // Player functionality
      url: null,
      pip: false,
      playing: false,
      controls: false,
      light: false,
      volume: 1,
      muted: false,
      played: 0,
      loaded: 0,
      duration: 0,
      playbackRate: 1.0,
      loop: false,

      // List of Songs
      songs: null,
    };
  }

  componentDidMount() {
    // Temporary hardcoded songs
    const songs = [
      { url: "https://www.youtube.com/watch?v=O48hUxxJxS8" },
      { url: "https://www.youtube.com/watch?v=8B93tgRxMuE" },
      { url: "https://www.youtube.com/watch?v=YE0WmmEn7Yk" },
      { url: "https://www.youtube.com/watch?v=ETecZsoA0jo" },
      { url: "https://youtu.be/8wRW57nBLMI?t=21" },
      { url: "https://www.youtube.com/watch?v=EcCVX42H2fg" },
      { url: "https://www.youtube.com/watch?v=bvC_0foemLY" },
    ];
    this.setState({ songs: songs });
    console.log(this.state.songs);

    // Load first song in list

    this.setState({ url: songs[0].url });
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

  handleVolumeChange = (e) => {
    // Volume
    this.setState({ volume: parseFloat(e.target.value) });
  };

  /*NextSong = () =>{
      var index = this.state.songs.findIndex(urlz => urlz === this.state.url);
      index++;
      //var tempsong = this.state.songs[index + 1]  ;
      //console.log("temp song is"+ tempsong.url);
      this.load(this.state.songs[index].url);
  }*/

  render() {
    return (
      <>
        <div className="Player">
          <div className="spinner">
            <div className="spinerOverlay"></div>
            <ReactPlayer
              className={styles.reactplayer}
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

          <button onClick={this.handlePlay}>
            {this.state.playing ? "STOP" : "PLAY"}
          </button>

          <button
            onClick={() => {
              var index = this.state.songs.findIndex(
                (urlz) => urlz === this.state.url
              );
              index++;
              index++;
              this.load(this.state.songs[index].url);
            }}
            /*onClick={() =>
              this.load("https://www.youtube.com/watch?v=qh3dYM6Keuw")
            }*/
          >
            {" "}
            Next song
          </button>

          <div className="volume">
            <label for="customRange3" class="form-label">
              Volume
            </label>
            <input
              type="range"
              class="form-range"
              min="0"
              max="1"
              step="0.01"
              id="customRange3"
              onChange={this.handleVolumeChange}
            ></input>
          </div>
        </div>
      </>
    );
  }
}
