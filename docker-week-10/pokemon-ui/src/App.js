import { useEffect, useState } from "react";

function App() {

  const [pokemon, setPokemon] = useState([]);
  useEffect(() => {
    const getPokemon = async () => {
      const response = await fetch(`${process.env.REACT_APP_API_URL}/pokemon`);
      if (response.status === 200) {
        setPokemon(await response.json());
      }
    };
    getPokemon();
  }, []);

  return (<>
    <h1>Pokedex</h1>
    <table>
      <thead>
        <tr>
          <th>Dex#</th>
          <th>Name</th>
          <th>Primary</th>
          <th>Secondary</th>
        </tr>
      </thead>
      <tbody>
        {pokemon.map(p => (
          <tr key={p.dexNumber}>
            <td>{p.dexNumber}</td>
            <td>{p.name}</td>
            <td>{p.primary.name}</td>
            <td>{p.secondary.name}</td>
          </tr>
        ))}
      </tbody>
    </table>
  </>);
}

export default App;
