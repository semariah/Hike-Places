import React from 'react'
import { Switch, Route } from 'react-router-dom'
import './App.css'
import Home from './home/Home'
import ClientControl from './client/ClientControl'



function App(){
  return (
    <div>
      <div className="App">Senior Care App</div>
        <Switch>
          <Route exact path='/' component={Home} />
          <Route path='/newclient' component={ClientControl} />
        </Switch>
    </div>
  );
};

export default App;























// import React, { Component } from 'react';
// import logo from './logo.svg';
// import './App.css';
//
// class App extends Component {
//   render() {
//     return (
//       <div className="App">
//         <header className="App-header">
//           <img src={logo} className="App-logo" alt="logo" />
//           <h1 className="App-title">Welcome to React</h1>
//         </header>
//         <p className="App-intro">
//           To get started, edit <code>src/App.js</code> and save to reload.
//         </p>
//       </div>
//     );
//   }
// }
//
// export default App;
