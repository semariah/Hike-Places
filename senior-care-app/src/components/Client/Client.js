import React from 'react'
import PropTypes from 'prop-types'

function Client(props){
  return(
    <div>
      <h3>{props.name}</h3>
      <h6>{props.address}</h6>
      <h6>{props.tel}</h6>
      <h6>{props.service}</h6>
      <hr/>
    </div>
  )
}

Client.propTypes = {
  name: PropTypes.string,
  address: PropTypes.string,
  tel: PropTypes.string,
  service: PropTypes.string
}

export default Client
