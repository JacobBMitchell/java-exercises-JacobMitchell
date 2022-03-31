function Card(props) {
    return(
        <div class="card">
        <h2>{props.singlePk.num}: {props.singlePk.name} </h2>
        <img src={props.singlePk.img} alt={props.singlePk.name}></img>
        </div>
    )
}
export default Card;