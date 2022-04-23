
function Pagination({ previous, next, pageBack, pageNext }) {
  return <ul className="pagination pagination-sm">
    <li className={`page-item ${!previous && "disabled"}`}>
      <a className="page-link" href="#" onClick={pageBack}>Previous</a>
    </li>
    <li className={`page-item ${!next && "disabled"}`}>
      <a className="page-link" href="#" onClick={pageNext}>Next</a>
    </li>
  </ul>;
}

export default Pagination;