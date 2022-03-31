
function Numbers(props) {
    function count() {
        let items = [];
        for (let i = props.min; i <= props.max; i++){
            items.push(i);
        }
        return items.map(num =>(
        <li>{num}</li>));
    }
    return(
        <>
        <ul>
        {count()}
        </ul>
        </>
    );
}

export default Numbers;