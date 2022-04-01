function Card(props) {
    return(
        <div class="card">
        <h2>{props.singlePk.num}: {props.singlePk.name} </h2>
        <img src={props.singlePk.img} alt={props.singlePk.name}></img>
        <button onClick={() => props.removePoke(props.singlePk.id)}>❌</button>
        </div>
    )
}
export default Card;