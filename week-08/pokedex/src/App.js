import Heading from "./Heading.js";
import Container from "./Container";
import pokedex from "./data.json"; 
function App() {
  return (
    <div className="App">
      <Heading />
      <Container pokemon={pokedex.pokemon} />
    </div>
  );
}

export default App;
