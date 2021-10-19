import React from "react";
import ReactPlayer from "react-player";

export default class PlayerReact extends React.Component {
  constructor() { 
    super();
    this.state = { // State Reloads Component every time the state has been changed
      url: "https://www.youtube.com/watch?v=Sv8LHpezbLw&t=15s",
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
    };
  }

  load = url => { // Loads the video we wish to see
      this.setState({
          url,
          played:0,
          loaded:0,
          pip:false
      })
      console.log({url});
  }

  handlePlay = () => { // Play Stop Functionality
    this.setState({ playing: !this.state.playing });
    console.log(this.state.playing);
  };

  handleVolumeChange = e => { // Volume
    this.setState({ volume: parseFloat(e.target.value) })
  }

  render() {
      
    return (
      <>
        <div className="Player">
          <ReactPlayer
            ref={this.ref}
            className="react-player"
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

          <button onClick={this.handlePlay}>
            {this.state.playing ? "STOP" : "PLAY"}
          </button>

          <button onClick={() => this.load('https://www.youtube.com/watch?v=qh3dYM6Keuw')}> Next song</button>

          <div className="volume">
            <label for="customRange3" class="form-label">
              Example range
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
