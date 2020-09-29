import React, {useState} from 'react'
const Counter = () => {
    const [count, setCount] = useState(0)
    const addClick = () => {
        setCount(count + 1)
    }
    const subClick = () => {
        setCount(count - 1)
    }
    return <>
        <h1>Counter : {count}</h1>
        <button onClick={addClick}>+1</button>
        <button onClick={subClick}>-1</button>
    </>
}
export default Counter