import Movie from "./Movie.js";
import {useState} from "react";

const Movies = () => {
    const myMovies = [
        { id: 1, title: 'Toy Story', releaseYear: 1995 },
        { id: 2, title: 'The Iron Giant', releaseYear: 1999 },
        { id: 3, title: 'Spider-Man: Into the Spider-Verse', releaseYear: 2018 },
      ];
    
    const[moviesa, setMovies] = useState(["Movie1"]);
    const[movies, setBMovies] = useState([myMovies]);

    function clickHandler() {
        setMovies([...moviesa,"Mad Max", "Shrek", "To Wong Foo"]);
        setBMovies([...myMovies]);
    }

    function renderMovies() {
        return moviesa.map(movie => <h4>{movie}</h4>);
    }

    function deleteMovie(id){
        console.log("Button Clicked ", id);
        let newMovies = [...movies];
        newMovies = newMovies.filter(m => {if (m.id != id){
            return m;
        }});
        setBMovies(newMovies);
        
    }

    const listMovie = () => {
        let arr = movies.map(movie => (
            <>
            <Movie key={movie.id}
             title={movie.title}
              ry={movie.releaseYear}
              id={movie.id}
              deleteMovie={deleteMovie} />
            </>
        ))
        return arr;
    }

    

    return (
        <>
            <ol>
            {listMovie()} 
            </ol>
            <button onClick={clickHandler}>Click for movies</button>

            {renderMovies()}
        </>
    );
}

export default Movies;