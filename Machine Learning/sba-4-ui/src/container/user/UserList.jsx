import React , {useEffect, useState} from 'react'
import axios from 'axios'
import {User} from '../../templates'

const UserList = () => {
    const [data, setData] = useState([])
    useEffect(() => {
        axios.get(`http://localhost:8080/api/users`)
        .then(res=>{
            alert(`List Success`)
            setData(res.data)
        })
        .catch(e=>{
            alert(`List Failure`)
            throw(e)
        })

    },[])
    
    return (<User>
  
        <table>
            <h1>User List</h1>
            <tr>
                <th>userid</th>
                <th>name</th>
                <th>pclass</th>
                <th>gender</th>
                <th>age_group</th>
                <th>embarked</th>
                <th>rank</th>
            </tr>
            {data.map((i, index)=>(
                <tr key={index}>
                <td>{i.userid}</td>
                <td>{i.name}</td>
                <td>{i.pclass}</td>
                <td>{i.gender}</td>
                <td>{i.age_group}</td>
                <td>{i.embarked}</td>
                <td>{i.rank}</td>
            </tr>
            ))}
            
        </table>

    </User>)
}

export default UserList