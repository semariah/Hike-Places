import React from 'react';

function ClientForm(){
  let _name = null;
  let _address = null;
  let _tel = null;
  let _service = null;

  function handleClientFormSubmission(event) {
    event.preventDefault();
    console.log(_name.value);
    console.log(_address.value);
    console.log(_tel.value);
    console.log(_service.value);
    _name.value = '';
    _address.value = '';
    _tel.value = '';
    _service.value = '';


  }
  return (
    <div>
      <form onSubmit={handleClientFromSubmission}>
        <input
          type='text'
          id='name'
          placeholder= 'Name'
          ref={(input) => {_name = input;}}/>
        <input
          type='text'
          id='address'
          placeholder='Address'
          ref={(input) => {_address = input;}}/>
        <input
          id='tel'
          placeholder='Phone'
          ref={(input) => {_tel = input;}}/>
          <input
            id='service'
            placeholder='Service Needed'
            ref={(input) => {_service = input;}}/>
        <button type='submit'>Submit</button>
      </form>
    </div>
  );
}

export default ClientForm;
