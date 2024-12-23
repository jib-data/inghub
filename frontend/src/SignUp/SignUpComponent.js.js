import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

let SignUpComponent = () => {
  let navigate = useNavigate();

  let [firstName, setFirstName] = useState("");
  let [lastName, setLastName] = useState("");
  let [username, setUserName] = useState("");
  let [email, setEmail] = useState("");
  let [password, setPassword] = useState("");
  let [dateOfBirth, setDateOfBirth] = useState("");

  let userData = {
    firstName: firstName,
    lastName: lastName,
    username: username,
    email: email,
    password: password,
    dateOfBirth: dateOfBirth,
  };

  let handleSubmitRequest = () => {
    if (
      !(
        firstName === "" ||
        lastName === "" ||
        password === "" ||
        username === "" ||
        email === null ||
        dateOfBirth === ""
      )
    ) {
      axios
        .post("http://localhost:8080/signup", userData)
        .then((res) => console.log(res.data))
        .catch((error) => console.log(error));
      setFirstName("");
      setLastName("");
      setPassword("");
      setUserName("");
      setEmail("");
      setDateOfBirth("");
    }
  };

  return (
    <div className="sign-component">
      <h4 className="sign-header">
        <span className="text-logo">inGHub...</span> where friends meet
      </h4>
      <h5 className="sign-subhead">Sign Up to inGHub</h5>
      <div className="sign-up-input">
        <div className="sign-left-input">
          <input
            className="input"
            type="text"
            placeholder="enter first name"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
          />
          <input
            className="input"
            type="text"
            placeholder="enter username"
            value={username}
            onChange={(e) => setUserName(e.target.value)}
          />
          <input
            className="input"
            type="text"
            placeholder="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
        <div className="sign-right-input">
          <input
            className="input"
            type="text"
            placeholder="last name"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
          />
          <input
            className="input"
            type="password"
            placeholder="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <input
            className="input"
            type="date"
            value={dateOfBirth}
            onChange={(e) => setDateOfBirth(e.target.value)}
          />
        </div>
      </div>

      <button className="sign-submit" onClick={handleSubmitRequest}>
        Sign Up
      </button>
      <p className="send-to-signup">
        already a user,
        <span className="sign-up-text" onClick={() => navigate("/sign-in")}>
          sign in!
        </span>
      </p>
    </div>
  );
};

export default SignUpComponent;
