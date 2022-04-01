import {useState} from "react";
import List from "./List.js";
import Form from "./Form.js";

function App() {
  const [todo, setTodo] = useState(["DO Laundry"]);
  function addTodo(item, e) {
    e.preventDefault();
    setTodo([...todo,item]);
  }

  function deleteTodo(item){
    let temp = [...todo];
    temp = temp.filter(each => each != item);
    setTodo(temp);
  }

  return (
    <div className="App">
      <h1>ToDo: List</h1>
      <List todo={todo} deleteTodo={deleteTodo}/>
      <Form addTodo={addTodo}/>
    </div>
  );
}

export default App;
