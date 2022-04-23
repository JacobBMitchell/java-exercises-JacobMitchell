import { useState, useEffect } from "react";
import Pagination from "./Pagination";

const url = "https://pokeapi.co/api/v2/pokemon/?limit=10";

function Pokedex({ setPokeUrl }) {

  const [pokeResult, setPokeResult] = useState();

  useEffect(() => {
    fetchPokemon(url);
  }, []);

  const fetchPokemon = (pageUrl) => {
    fetch(pageUrl)
      .then(r => {
        if (r.status === 200) {
          return r.json();
        }
        throw new Error("Fetch failed.")
      })
      .then(json => setPokeResult(json))
      .catch(err => console.error(err));
  }

  const pageBack = () => {
    fetchPokemon(pokeResult.previous);
  };

  const pageNext = () => {
    fetchPokemon(pokeResult.next);
  };

  return <>
    <h3>Pokédex</h3>
    {pokeResult 
      ? <div>
          <table>
            <thead>
              <tr>
                <th>
                  Name
                </th>
              </tr>
            </thead>
            <tbody>
              {pokeResult.results.map(p => <tr key={p.id}>
                <td>{p.name}</td>
                <td>
                  <button className="btn btn-info" onClick={() => setPokeUrl(p.url)}>View</button>
                </td>
              </tr>)}
            </tbody>
          </table>
          <Pagination 
            previous={!!pokeResult.previous} 
            next={!!pokeResult.next}
            pageBack={pageBack}
            pageNext={pageNext}
          />
        </div>
      : <div className="alert alert-warning">No Pokemon found</div>}
  </>;
}

export default Pokedex;