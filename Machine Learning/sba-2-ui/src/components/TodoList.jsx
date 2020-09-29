import React from 'react'
import {useSelector, useDispatch} from 'react-redux'
import {toggleTodoAction, deleteTodoAction} from '../store/todoReducers'

const TodoList = () => {
    const todos = useSelector(state => state.todos)
    const dispatch = useDispatch()
    const toggleTodo = todoId => dispatch(toggleTodoAction(todoId))
    const deleteTodo = todoId => dispatch(deleteTodoAction(todoId))
    
    return <>
    {todos && todos.length === 0 && (
        <p>No Todo at the moment</p>
    )}
    {todos &&
        todos.map(todo => (
            <div key={todo.id}>
                <div>
                    <input type="checkbox" checked={todo.complete}
                    onChange = {toggleTodo.bind(null, todo.todoId)}
                    />
                    <span style={{margin: '20px'}}>{todo.name}</span>
                    <button onClick= {deleteTodo.bind(null, todo.todoId)}>
                        x
                    </button>
                </div>
            </div>
        ))
    }
    </>
}

export default TodoList