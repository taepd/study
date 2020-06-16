<template>
    <div class="inputBox shadow">
        <input type="text" v-model="newTodoItem" placeholder="Type what you have to do" 
            v-on:keyup.enter="addTodo">
        <span class="addContainer" v-on:click="addTodo">
            <i class="addBtn fas fa-plus" aria-hidden="true"></i>
        </span>
    </div>
</template>

<script>
export default {
    data(){
        return {
            newTodoItem: ''
        }
    },
    methods: {
        addTodo(){
            if(this.newTodoItem !==""){
                var value = this.newTodoItem && this.newTodoItem.trim(); //&& 연산 중 false가 발생하면 해당값(false나 0)반환. 다 참이면 마지막 값 반환
                localStorage.setItem(value, value);
                this.clearInput();
            }
        },
        clearInput(){ //굳이 분리한 이유: 디자인패턴: 단일 책임 원칙
            this.newTodoItem = '';
        }
    }
    
}
</script>

<style scoped>
    input:focus {
        outline: none;
    }
    .inputBox {
        background: white;
        height: 50px;
        line-height: 50px;
        border-radius: 5px;
    }
    .inputBox input{
        border-style: none;
        font-size: 0.9rem;
    }
    .addContainer {
        float: right;
        background: linear-gradient(to right, #6478FB, #8763FB);
        display: block;
        width: 3rem;
        border-radius: 0 5px 5px 0;
    }
    .addBtn {
        color: white;
        vertical-align: middle;
    }   

</style>