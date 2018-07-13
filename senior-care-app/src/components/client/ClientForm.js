import React from 'react';

function ClientForm(){
  return (
    <div>
      <form>
        <input
          type='text'
          id='name'
          placeholder= 'Name'/>
        <input
          type='text'
          id='address'
          placeholder='Address'/>
        <input
          id='tel'
          placeholder='Phone'/>
          <input
            id='service'
            placeholder='Service Needed'/>
        <button type='submit'>Submit</button>
      </form>
    </div>
  );
}
