import React, {useState} from 'react'
import {User} from '../../templates'
import axios from 'axios'
const UserModify = () => {
    const [password, setPassword] = useState()
    const modify = e => {
        e.preventDefault()
        axios.get(`http:localhost:8080/user/modify`)
        .then(

        )
        .error(
            
        )

    }
    return (<User>
        <h1>UserModify</h1> <form>
        <table className='tab_layer'>
           
                <tr>
                    <td>ID</td>
                    <td><input type="text"/></td>
                </tr>
                <tr>
                    <td>PASSWORD</td>
                    <td><input type="text" onChange={e => setPassword(e.target.value)}/></td>
                </tr>
                <tr>
                    <td>NAME</td>
                    <td><input type="text" /></td>
                </tr>
                <tr>
                    <td>PCLASS</td>
                    <td><input type="text"/></td>
                </tr>
                <tr>
                    <td>GENDER</td>
                    <td><input type="text" /></td>
                </tr>
                <tr>
                    <td>BIRTH YEAR</td>
                    <td><input type="text" /></td>
                </tr>
                <tr>
                    <td>EMBARKED</td>
                    <td><input type="text" /></td>
                </tr>
                <tr>
                    <td>RANK</td>
                    <td><input type="text" /></td>
                </tr>
                <tr>
                    <td colspan={2}><button onClick={modify}>Modify</button>
                    <button>Cancel</button></td>
                </tr>
           
        </table> </form>
    </User>)
}

export default UserModify