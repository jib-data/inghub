import { useCallback, useContext, useState } from "react";
import HomeData from "../TimelineDataContext";
import axios from "axios";
// import { format } from "date-fns";

const Hero = () => {
  const [firstName, setFirstname] = useState(localStorage.getItem("firstName"));
  const { followers, users, posts, setPosts } = useContext(HomeData);
  const [postText, setPostText] = useState("");

  const handlePostAdd = () => {
    // const person = {
    //   Id: localStorage.getItem("userId"),
    // };
    const data = {
      postText,
      dateTimeCreated: new Date().toISOString().slice(0, -1), // Removes 'Z' (UTC marker)
    };

    axios
      .post(
        "http://localhost:8080/posts/" + localStorage.getItem("userId"),
        data,
        {
          headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
            "Content-Type": "application/json",
          },
        }
      )
      .then((res) => {
        setPosts((prevPosts) => [res.data, ...prevPosts]);
        setPostText("");
      })
      .catch((error) => console.log(error.response));
  };

  return (
    <>
      <section className="hero">
        <div className="img"></div>
        <div className="banner">
          <h2 className="welcome-message">
            Welcome <span>{firstName}</span>
          </h2>
          {/* <h5 className="followers">
            Followers <span className="num-followers">{followers.length}</span>
          </h5> */}
          {/* <h5 className="following">
            Following <span className="num-following">6k</span>
          </h5> */}
          <input
            className="post-input"
            type="text"
            placeholder="share your thoughts..."
            value={postText}
            onChange={(e) => setPostText(e.target.value)}
          />
          <button className="add-post" onClick={handlePostAdd}>
            Post
          </button>
        </div>
      </section>
    </>
  );
};

export default Hero;
