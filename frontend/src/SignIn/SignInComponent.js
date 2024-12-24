import { useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import axios from "axios";

let SignInComponent = () => {
  let navigate = useNavigate();
  let [username, setUsername] = useState("");
  let [password, setPassword] = useState("");

  // userId
  // firstname
  // username
  // jwt token

  //   User details
  // let userDetails = JSON.parse({
  //   username: "lucaslee",
  //   password: "Lucas@789",
  // });

  let handleLogin = () => {
    let userData = {
      username,
      password,
    };

    axios
      .post("http://localhost:8080/login", userData)
      .then((response) => {
        localStorage.setItem("token", response.data.jwt);
        localStorage.setItem("userId", response.data.userId);
        localStorage.setItem("firstName", response.data.firstName);
        console.log(response.data.jwt);
        setUsername("");
        setPassword("");
        navigate("/");
      })
      .catch((error) => console.log(error));
  };
  let handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };
  let handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  return (
    <div className="sign-component">
      <h3 className="sign-header">
        <span className="text-logo">inGHub...</span> Where friends meet
      </h3>
      <h5 className="sign-subhead">Sign in to inGHub</h5>
      <input
        className="input"
        type="text"
        placeholder="enter username"
        value={username}
        onChange={handleUsernameChange}
      />
      <input
        className="input"
        type="password"
        placeholder="enter password"
        value={password}
        onChange={handlePasswordChange}
      />
      <button className="sign-submit" onClick={handleLogin}>
        sign in
      </button>
      <p className="send-to-signup">
        new user?
        <span className="sign-up-text" onClick={() => navigate("/sign-up")}>
          sign up!
        </span>
      </p>
    </div>
  );
};
export default SignInComponent;
