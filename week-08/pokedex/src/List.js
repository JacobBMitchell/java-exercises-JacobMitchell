function List(props) {
    
    function renderPokemon() {
        return props.favorite.map(fave => (
         <li>{fave.name}</li>
        ));
    }

    return (
        <ul>
            {renderPokemon()}
        </ul>
    );
}
export default List;