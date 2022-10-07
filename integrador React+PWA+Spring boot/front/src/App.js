import './App.css';
import AppRoutes from './routes/MainRoutes';
import { Provider } from 'react-redux';
//import store from './redux/store/store';

function App() {
  return (
    <Provider>    
      <AppRoutes />
    </Provider>
  );
}

export default App;
