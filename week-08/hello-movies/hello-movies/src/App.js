import React from "react";
import Heading from "./Heading.js";
import Numbers from "./Numbers.js";
import Movies from "./Movies";

function App() {
  return (
    <>
    <Heading text={"Hello World"} />
    <Heading text={"Text 2 electric boogaloo!"} />
    <Numbers min={1} max={20} />
    <Movies />
    </>
  );
}

export default App;
