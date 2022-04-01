import {useState} from "react";
function Form(props) {
    const[input, setInput] = useState("");
    function onChangeHandler(event) {
        setInput(event.target.value);
    }

    return (
        <form onSubmit={(e) => props.addTodo(input,e)}>
            <label for="todo">What to do: </label>
            <input onChange={onChangeHandler} id="todo" ></input>
            <button type="submit">Submito</button>
        </form>
    )
}
export default Form;