import Item from "./Item.js";
function List(props) {
    function makeList() {
        return (props.todo.map(each => (
        <li><Item each={each} deleteTodo={props.deleteTodo}/></li>
        )));
    }
    return (
        <ul>
            {makeList()}
        </ul>
    )
}
export default List;