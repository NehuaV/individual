
import UserCom from './component/UserCom';
import CrudCom from './component/CrudCom';
import HeaderCom from './component/HeaderCom';
import PlayerCom from './component/PlayerCom';

import 'bootstrap/dist/css/bootstrap.min.css';
import PlayerReact from './component/PlayerReact';

function App() {
  return (
    <div className="App">
      <HeaderCom></HeaderCom>
      <PlayerReact/>
    </div>
  );
}

export default App;