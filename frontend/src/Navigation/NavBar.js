import { Link, useNavigate } from "react-router-dom";

let NavBar = () => {
  const navigate = useNavigate();
  const handleLogout = () => {
    localStorage.clear();
    navigate("/sign-in");
  };
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
        <Link to="/sign-in" className="nav-item request" onClick={handleLogout}>
          logout
        </Link>
      </ul>
    </nav>
  );
};

export default NavBar;
