import { Link } from "react-router-dom";

let NavBar = () => {
  return (
    <nav className="nav-bar">
      <div className="logo-div">
        <div className="logo"></div>
        <div className="logo-text">
          <p>
            <i>tHe inGHub</i>{" "}
          </p>
        </div>
      </div>
      <ul className="nav-items">
        <Link to="/" className="nav-item home">
          home
        </Link>
        <Link to="/profile" className="nav-item profile">
          profile
        </Link>
        <Link to="" className="nav-item request">
          logout
        </Link>
      </ul>
    </nav>
  );
};

export default NavBar;
