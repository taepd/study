import React,{useState, useEffect} from 'react'
import {Link, useHistory} from 'react-router-dom'

const Nav = props => { 
    
    const history  = useHistory()
    const logout = e => {
        alert('logout')
        e.preventDefault();
        sessionStorage.removeItem("sessionUser")
        history.push('/')
        window.location.reload()
    }
    
    return (<>
        <nav style={{width: '500px', margin: '0 auto'}}>
            { props.isAuth !== null
            ? <ul>
                <li><Link to='/home'>Home</Link></li>
                <li><Link to='/user'>User</Link></li>
                <li><Link to='/item'>Item</Link></li>
                <li><Link to='/article'>Board</Link></li>
                <li onClick={logout} style={{textDecoration:'underline'}}>Logout</li>
            </ul>:
            <ul>
                <li><Link to='/signup-form'>Register</Link></li>
                <li><Link to='/signin-form'>Login</Link></li>
                <li><Link to='/'>Cancel</Link></li>
            </ul>
            }
            
        </nav>
    </>)
   
    
}
export default Nav
