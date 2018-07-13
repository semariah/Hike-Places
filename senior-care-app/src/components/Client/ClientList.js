import React from 'react'
import Client from './Client'

var masterClientList = [
  {
    name: 'thomaas',
    address: 'NE Beech portland',
    tel: '971-234-5678',
    service: 'home-cleaning'
  },
  {
    name: 'saari',
    address: 'california',
    tel: '971-234-9807',
    service: 'bathing'
  },

]

function ClientList(){
  return(
    <div>
        <hr/>
        {masterClientList.map((client, index) =>
          <Client name={client.names}
            address={client.address}
            tel={client.tel}
            service={client.service}
            ket={index}/>
        )}
      </div>

  )
}

export default ClientList
