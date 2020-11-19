import React, {useState} from 'react'
import axios from 'axios'
import { Link, useHistory } from "react-router-dom";

const UserLogin = () => {
    const [userid, setUserid] = useState('')
    const [password, setPassword] = useState('')
    
    const history = useHistory();
    const login = e => {
        e.preventDefault()
        axios.post(`http://localhost:8080/api/access`, {userid, password})
            .then(res => {
                alert(`Welcome ! ${res.data["name"]}.  ${res.data["userid"]}'s connection is successful. ! `)

                sessionStorage.setItem("sessionUser", res.data['userid']);
                window.location.reload()
                history.push("/home");
                
            })
            .catch(error => {
                alert("Please check your ID or password.");
                window.location.reload();
            })

    }
    const cancel = e => {
        e.preventDefault()

    }
    return (<>
    <h1>Signin Form</h1> <form>
    <table  className='tab_layer'>
       
        <tr>
            <td>ID : </td>
            <td><input type="text" onChange={e => setUserid(`${e.target.value}`)}/></td>
        </tr>
        <tr>
            <td> PW : </td>
            <td> <input type="text" onChange={e => setPassword(`${e.target.value}`)}/> </td>
        </tr>
        <tr>
            <td colspan={2}>
                <input type="button" value="LOGIN" onClick= {login}/>
                <input type="button" value="CANCEL" onClick= {cancel}/>
            </td>
        </tr>
       
    </table> </form>
    </>)
    }
export default UserLogin