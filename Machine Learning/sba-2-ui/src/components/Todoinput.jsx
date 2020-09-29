import React, {useState} from 'react'
import uuid from 'uuid/v4'
import {useDispatch} from 'react-redux'
import {addTodoAction} from '../store/todoReducers'

const TodoInput = () => {
    // todo가 crud 대상(object)입니다. -> 속성이 된다.
    // es6 이전 모드 var
    // es6 이후 let(변수), const(상수) 두 가지로 정의 
    // 함수는 const 타입에 할당합니다.
    // todo는 변수이고 setTodo는 함수인데 [Todo, setTodo]로 묵었으므로 객체이다.
    // JSON = Javascript Object Notation
    // object {}, array [] 두 가지 형태
    
    const [todo, setTodo] = useState("")  // Redux를 사용하는 중
    const dispatch = useDispatch()
    const submitForm = e => {
        e.preventDefault()  // default 기능은 막고, 내가 정의한 기능을 구현
        const newTodo = {
            todoId: uuid(),
            name: todo,
            complete: false
        }
        addTodo(newTodo)
        setTodo("")
    }
    const handleChange = e => {
        e.preventDefault()  // default 기능은 막고, 내가 정의한 기능을 구현
        setTodo(e.target.value)
    }
    const addTodo = todo => {
        dispatch(addTodoAction(todo))  // 영속적으로 저장할 곳 state -> api -> db
    }
    return <>
    <h1>할일 등록</h1>
    <form onSubmit={submitForm} method='POST'>
        <div>
            <input type="text" name="todo" onChange={handleChange}/><br/>
            <input type="submit" value="ADD TODO"/>
        </div>
    </form>
    </>
}

export default TodoInput