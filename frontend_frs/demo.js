import React, { useEffect, useState } from 'react'

function demo() {
    const[data,setData]= useState(null);
    useEffect(()=>{
        return "hello"
    },[data])
  return (
    <div>demo</div>
  )
}

export default demo