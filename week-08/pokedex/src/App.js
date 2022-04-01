import Heading from "./Heading.js";
import Container from "./Container";
import pokedex from "./data.json"; 
import { useState } from "react";
import Form from "./Form";
import List from "./List.js";

function App() {

  const[pokemon, setPokemon] = useState([]);
  const[favorite, setFavorite] = useState([]);

  const buttonHandler = () => {
    setPokemon(pokedex.pokemon);
  }

  const removePoke = (id) => {
    let newPokemonArray = [...pokemon];
    newPokemonArray = newPokemonArray.filter(pkm => pkm.id !== id);
    setPokemon(newPokemonArray);
}

function addToFavorites(num, e) {
    e.preventDefault();
    let tempArray = [...pokemon];
    setFavorite([...favorite, ...tempArray.filter(pkm => pkm.num == num)]);
}

  return (
    <div className="App">
      <Heading />
      <button onClick={buttonHandler} >Retrive all pokemon</button>
      <br/>
      <Form addToFavorites={addToFavorites} />
      <List favorite={favorite}/>
      <Container pokemon={pokemon} removePoke={removePoke} />
    </div>
  );
}

export default App;
