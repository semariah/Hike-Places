import React from 'react'
import { Link } from 'react-router-dom'

function Home(){
  return(
    <div>
      <h1>Senior Care App</h1>
      <Link to='/'>Home</Link> | <Link to="/newclient">Create Client account</Link>
    </div>
  );
}

export default Home
