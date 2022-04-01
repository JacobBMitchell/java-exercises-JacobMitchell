import {useState} from "react";

function Form(props) {

    const[input, setInput] = useState("");

    function onChangeHandler(event) {
        setInput(event.target.value);
    }

return (
    <>
        <form onSubmit={(e) => props.addToFavorites(input,e)}>
            <label for="pokedexNumInput">Enter Pokedex Number: </label><br></br>
            <input onChange={onChangeHandler} id="pokedexNumInput"></input>
            <button type="submit">Submit</button>
        </form>
    </>
)
}
export default Form;