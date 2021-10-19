
import UserCom from './component/UserCom';
import CrudCom from './component/CrudCom';
import HeaderCom from './component/HeaderCom';
import PlayerCom from './component/PlayerCom';

import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className="App">
      <HeaderCom></HeaderCom>
      <PlayerCom/>
    </div>
  );
}

export default App;