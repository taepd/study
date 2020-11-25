import {createStore} from 'redux';

export default createStore(function(state, action){
    if(state === undefined){
        return {number:0}
    }
    if(action.type === 'INCREMENT'){
        // ...state : state를 복제하고, 이어 나오는 내용으로 state 조작
        return {...state, number: state.number + action.size}
    }
    return state;
}, window.__REDUX_DEVTOOLS_EXTENSION__ && 
window.__REDUX_DEVTOOLS_EXTENSION__()) // redux dev_tool load