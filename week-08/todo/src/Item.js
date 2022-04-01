function Item(props){


    return (<li>
    {props.each}  
    <button onClick={() => props.deleteTodo(props.each)}>💔</button>
    </li>)
}
export default Item;