import Card from "./Card";
function Container(props) {

    function  pokemonCardFactory() {
        let pokemonCards = props.pokemon.map(singlePokemon => (
            <Card key={singlePokemon.id} singlePk={singlePokemon}/>
        ));
        return pokemonCards;
    }

    return (
        <>
            {pokemonCardFactory()}
        </>
    );
}
export default Container;