import React, { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [funcShow, setFuncShow] = useState(true);
  const [classShow, setClassShow] = useState(true);
  
  return (
    <div className="container">
      <h1>Hello World</h1>
      <input type="button" value="remove func" onClick={function(){
        setFuncShow(false);
      }}></input>
      <input type="button" value="remove class" onClick={function(){
        setClassShow(false);
      }}></input>
      {funcShow ? <FuncComp initNumber={2}></FuncComp> : null}
      {classShow ? <ClassComp initNumber={2}></ClassComp> : null}
    </div>
  );
}
var funcStyle = 'color:blue';
var funcId = 0;
function FuncComp(props) {
  var numberState = useState(props.initNumber);  // 배열을 리턴. [0]: 상태값 [1]: setState()
  var number = numberState[0];
  var setNumber = numberState[1];
  console.log('numberState', numberState);

  const [date, setDate] = useState((new Date().toString()));
  
  // side effect. 여러 개도 가능
  useEffect(function () {
    console.log('%cfunc => useEffect (componentDidMount & componentDidUpdate)' + (++funcId), funcStyle);
    document.title = number;
    return function(){ // useEffect > render > return function(clean up) > useEffect
      console.log('%cfunc => useEffectReturn (componentDidMount & componentDidUpdate)' + (++funcId), funcStyle);
    }
  }, [number]); // useEffect 두 번째 매개변수로 state값을 주면 해당 되는 것이 갱신될 때만 실행됨
  // 두 번째 매개변수로 빈 배열[]을 주면 componentDidMount 역할을 함
  // 즉, 1회만 실행되고 이후에 실행 안됨
  // 이 때 return function은 componentWillUnmount 역할을 함

  console.log('%cfunc => render ' + (++funcId), funcStyle);
  return (
    <div className="container">
      <h2>function style component</h2>
      <p>Number : {number}</p>
      <p>Date: {date}</p>
      <input type="button" value="random" onClick={
        function () {
          setNumber(Math.random());
        }
      }></input>
      <input type="button" value="date" onClick={
        function () {
          setDate((new Date()).toString());
        }
      }></input>
    </div>
  );
}
var classStyle = 'color:red';
class ClassComp extends React.Component {
  state = {
    number: this.props.initNumber,
    date: (new Date()).toString()
  }
  componentWillMount() {
    console.log('%cclass => componentWillMount', classStyle);
  }
  componentDidMount() {
    console.log('%cclass => componentDidMount', classStyle);
  }
  shouldComponentUpdate(nextProps, nextState) {
    console.log('%cclass => shouldComponentUpdate', classStyle);
    return true;
  }
  componentWillUpdate(nextProps, nextState) {
    console.log('%cclass => componentWillUpdate', classStyle);
  }
  componentDidUpdate(nextProps, nextState) {
    console.log('%cclass => componentDidUpdate', classStyle);
  }
  render() {
    console.log('%cclass => render', classStyle);
    return (
      <div className="container">
        <h2>class style compoenet</h2>
        <p>Number : {this.state.number}</p>
        <p>Date : {this.state.date}</p>
        <input type="button" value="random" onClick={
          function () {
            this.setState({ number: Math.random() })
          }.bind(this)
        }></input>
        <input type="button" value="date" onClick={
          function () {
            this.setState({ date: (new Date()).toString() })
          }.bind(this)
        }></input>
      </div>
    );
  }
}

export default App;
