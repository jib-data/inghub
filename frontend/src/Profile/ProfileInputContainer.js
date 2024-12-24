import axios from "axios";
import { useEffect, useState } from "react";

let ProfileInputContainer = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [render, setRender] = useState(false);
  useEffect(() => {
    axios
      .get("http://localhost:8080/profile/" + localStorage.getItem("userId"), {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("token"),
        },
      })
      .then((res) => {
        setFirstName(res.data.firstName);
        setLastName(res.data.lastName);
        setEmail(res.data.email);
        setUsername(res.data.username);
      })
      .catch((error) => console.log(error.response));
  }, [render]);
  const onHandleProfileUpdate = () => {
    const updatedData = {
      Id: localStorage.getItem("userId"),
      firstName,
      lastName,
      email,
      password,
      username,
    };
    console.log(updatedData);
    axios
      .put(
        "http://localhost:8080/user/" + localStorage.getItem("userId"),
        updatedData,
        {
          headers: { Authorization: "Bearer " + localStorage.getItem("token") },
        }
      )
      .then((res) => {
        setFirstName(res.data.firstName);
        setLastName(res.data.lastName);
        setUsername(res.data.username);
        setEmail(res.data.email);
        localStorage.setItem("firstName", res.data.firstName);
        setFirstName("");
        setEmail("");
        setLastName("");
        setUsername("");
        setPassword("");
        setRender(true);
        console.log("requs");
      })
      .catch((error) => console.log(error.response));
  };

  return (
    <div className="profile-container">
      <h4 className="profile-header">User Profile</h4>
      <h5 className="sign-subhead">edit and submit</h5>
      <div className="profile-input">
        <div className="sign-left-input">
          <input
            className="input"
            type="text"
            placeholder="enter first name"
            value={firstName}
            onChange={(e) => {
              setFirstName(e.target.value);
            }}
          />
          <input
            className="input"
            type="text"
            placeholder="enter username"
            value={username}
            onChange={(e) => {
              setUsername(e.target.value);
            }}
          />
          <input
            className="input"
            type="text"
            placeholder="email"
            value={email}
            onChange={(e) => {
              setEmail(e.target.value);
            }}
          />
        </div>
        <div className="sign-right-input">
          <input
            className="input"
            type="text"
            placeholder="last name"
            value={lastName}
            onChange={(e) => {
              setLastName(e.target.value);
            }}
          />
          <input
            className="input"
            type="password"
            placeholder="password"
            value={password}
            onChange={(e) => {
              setPassword(e.target.value);
            }}
          />
        </div>
      </div>

      <button className="sign-submit" onClick={onHandleProfileUpdate}>
        Submit Edit
      </button>
    </div>
  );
};

export default ProfileInputContainer;
