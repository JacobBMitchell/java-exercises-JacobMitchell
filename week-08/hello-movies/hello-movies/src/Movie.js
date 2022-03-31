import {useState} from "react";

const Movie = (props) => {


    return (
    <li>
    Title: {props.title}, released in: {props.ry} &nbsp;
     <button onClick={() => props.deleteMovie(props.id)}>❌</button>
    </li>
    );
}

export default Movie;