import { createContext, useState, useEffect } from "react";
import axios from "axios";
const HomeData = createContext();

export const HomeDataProvider = ({ children }) => {
  const [posts, setPosts] = useState([]);
  const [followers, setFollowers] = useState([]);
  const [following, setFollowing] = useState([]);
  let userId = localStorage.getItem("userId");

  useEffect(() => {
    axios
      .get("http://localhost:8080/" + userId, {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("token"),
          "Content-Type": "application/json",
        },
      })
      .then((res) => {
        setPosts(res.data.posts);
        setFollowers(res.data.followers);
        setFollowing(res.data.following);
      })
      .catch((error) => console.log(error.response));
  }, [userId]);

  return (
    <HomeData.Provider
      value={{
        posts,
        followers,
        following,
        setPosts,
        setFollowers,
        setFollowing,
      }}
    >
      {children}
    </HomeData.Provider>
  );
};

export default HomeData;
