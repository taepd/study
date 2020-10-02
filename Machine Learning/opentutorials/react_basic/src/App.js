import React, { Component } from 'react';
import TOC from './components/TOC'
import ReadContent from './components/ReadContent'
import CreateContent from './components/CreateContent'
import UpdateContent from './components/UpdateContent'
import Subject from './components/Subject'
import Control from './components/Control'
import './App.css';


class App extends Component {
  constructor(props) {
    super(props);
    this.max_content_id = 3; // state값이 아닌 객체값으로 한 이유는 ui에 영향이 없으므로 불필요한 랜더링을 줄이기 위해서임
    this.state = {
      mode: 'welcome',
      selected_content_id: 2,
      welcome: { title: 'Welcome', desc: 'Hello, React!!' },
      subject: { title: 'WEB', sub: 'World Wide Web' },
      contents: [
        { id: 1, title: 'HTML', desc: 'HTML is for information' },
        { id: 2, title: 'CSS', desc: 'CSS is for design' },
        { id: 3, title: 'JavaScript', desc: 'JavaScript is for interactive' }
      ]
    }
  }
  getReadContent() {
    var i = 0;
    while (i < this.state.contents.length) {
      var data = this.state.contents[i];
      if (data.id === this.state.selected_content_id) {
        return data;
      }
      i = i + 1;
    }
  }
  getContent() {
    var _title, _desc, _article = null;
    if (this.state.mode === 'welcome') {
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
      _article = <ReadContent title={_title} desc={_desc}></ReadContent>
    } else if (this.state.mode === 'read') {
      var _content = this.getReadContent();
      _article = <ReadContent title={_content.title} desc={_content.desc}></ReadContent>

    } else if (this.state.mode === 'create') {
      _article = <CreateContent onSubmit={function (_title, _desc) {
        this.max_content_id += 1;
        // push는 원본 배열을 조작하는 것이므로 비추
        // push를 쓰면서 immutable을 유지하려면 Array.from(a), 
        // 객체의 경우엔 Object.assign({}, a) 사용
        var _contents = this.state.contents.concat(
          { id: this.max_content_id, title: _title, desc: _desc }
        );
        this.setState({
          contents: _contents,
          mode: "read",
          selected_content_id: this.max_content_id
        });
      }.bind(this)}></CreateContent>
    } else if (this.state.mode === 'update') {
      _content = this.getReadContent();
      _article = <UpdateContent data={_content} onSubmit={
        function (_id, _title, _desc) {
        var _contents = Array.from(this.state.contents);
        var i = 0;
        while(i < _contents.length){
          if(_contents[i].id === _id){
            _contents[i] = {id: _id, title: _title, desc: _desc}
          }
          i += 1;
        }
        this.setState({
          contents: _contents,
          mode : "read"
        });
      }.bind(this)}></UpdateContent>
    }
    return _article;
  }
  render() {
    console.log('App render')
    return (
      <div className="App">
        <Subject
          title={this.state.subject.title}
          sub={this.state.subject.sub}
          onChangePage={function () {
            this.setState({ mode: 'welcome' });
          }.bind(this)}
        >
        </Subject>
        <TOC
          data={this.state.contents}
          onChangePage={function (id) {
            this.setState({
              mode: 'read',
              selected_content_id: id
            });
          }.bind(this)}
        >
        </TOC>
        <Control onChangeMode={function (_mode) {
          if(_mode === 'delete'){
            if(window.confirm('정말로 지우시겠습니까?')){
              var _contents = Array.from(this.state.contents);
              var i = 0;
              while(i < this.state.contents.length){
                if(_contents[i].id === this.state.selected_content_id){
                  _contents.splice(i,1);
                }
                i += 1;
              }
            }
            this.setState({
              mode: 'welcome',
              contents: _contents
            });
            alert('삭제되었습니다.');
          }else{
            this.setState({
              mode: _mode
            });
          }
        }.bind(this)}></Control>
        {this.getContent()}
      </div>
    );
  }
}

export default App;
