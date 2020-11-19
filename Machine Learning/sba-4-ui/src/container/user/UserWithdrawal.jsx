import React, {useState} from 'react'
import {User} from '../../templates'
import axios from 'axios'
const UserWithdrawal = () => {
    const [password, setPassword] = useState()
    const withdrawal = e => {
        e.preventDefault()
        axios.post(`http:localhost:8080/user/withdrawal`, {password})
        .then(
            console.log(`signup SUCCESS`)
        )
        .error(
            console.log(`signup FAIL`)
        )

    }

    
    return (<User>
        <h1>UserWithdrawal</h1>
        <table  className='tab_layer'>
            <tr>
                <td> Enter PW : </td>
                <td> <input type="text" onChange={e => setPassword(`${e.target.value}`)}/> </td>
            </tr>
            <tr>
                <td colSpan={2}><button onClick={withdrawal}>Withdrawal</button></td>
            </tr>
        </table>
    </User>)
}

export default UserWithdrawal