import './App.css';
import UserCom from './component/UserCom';
import CrudCom from './component/CrudCom';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {

  

  return (
    <div className="App">
      <UserCom></UserCom>
      <CrudCom/>
    </div>
  );
}

export default App;