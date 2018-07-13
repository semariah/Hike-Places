import React from 'react';

class ClientControl extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      formVisibleOnPage: false
    };
  }

  render(){
    return (
      <div>
        <p>This is the ClientControl component!</p>
      </div>
    );
  }
}

export default ClientControl;
