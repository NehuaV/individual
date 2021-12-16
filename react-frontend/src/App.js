import HeaderCom from "./component/HeaderCom";
import LoginCom from "./component/LoginCom";
import PlayerCom from "./component/PlayerCom";
import Register from "./component/RegisterCom";
import HomeCom from "./component/HomeCom";
import UserPage from "./component/UserPage";

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    <Router>
      <HeaderCom />
      <Switch>
        <Route path="/" exact component={HomeCom} />
        <Route path="/logout" exact component={HomeCom} />
        <Route path="/login" exact component={LoginCom} />
        <Route path="/register" exact component={Register} />
        <Route path="/player" exact component={PlayerCom}/>
        <Route path="/userPage" exact component={UserPage}/>
      </Switch>
    </Router>
  );
}

export default App;
