import React, { Component } from 'react'

class TOC extends Component {
  shouldComponentUpdate(newProps, newState){
    console.log(
      newProps.data,
      this.props.data
      );
      // 새로운 데이터가 입력되었을 때에만 렌더하도록 제어
      // 만일 push로 데이터를 갱신했을 때는 이러한 비교를 할 수 없음
      if(this.props.data === newProps.data){ 
        return false;
      }
      return true;
  }
  render() {
    console.log('TOC render')
    var lists = [];
    var data = this.props.data;
    var i = 0;
    // <e.target을 이용하는 방법>
    // while(i < data.length){
    //   lists.push(
    //   <li key={data[i].id}>
    //     <a href={"/content/"+data[i].id}
    //     data-id = {data[i].id}  // data- 로 시작하면 e.target의 dataset 안에 위치
    //     onClick={function(e){
    //       e.preventDefault();
    //       this.props.onChangePage(e.target.dataset.id);
    //     }.bind(this)}
    //     >{data[i].title}</a>
    //   </li>);
    //   i = i + 1;
    // }
    // <bind()를 이용하는 방법>
    while (i < data.length) {
      lists.push(
        <li key={data[i].id}>
          <a href={"/content/" + data[i].id}
            onClick={function (id, e) {
              e.preventDefault();
              this.props.onChangePage(id);
            }.bind(this, data[i].id)}  // 두 번째 매개변수부터 onClick정의 function의 첫 매개변수부터 인식됨
          >{data[i].title}</a>
        </li>);
      i = i + 1;
    }
    return (
      <nav>
        <ul>
          {lists}
        </ul>
      </nav>
    );
  }
}

export default TOC;