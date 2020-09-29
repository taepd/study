import React from 'react';
import { Provider } from 'react-redux'
// import TodoInput from './components/TodoInput'
// import TodoList from './components/TodoList'
// import Chart from './components/Chart'
import Dashboard from './components/Dashboard';
// import Signup from './components/SignUp'

import store from './store'


const App = () => {
  return <>
  <Provider store = {store}>
  <div style={{width: "1000px",margin: "0 auto"}}>
    {/* <TodoInput/>
    <TodoList/> */}
      {/* <Signup/>  */}
      <Dashboard/>
    </div></Provider>
    </>
}

export default App;