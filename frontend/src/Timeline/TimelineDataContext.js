import { createContext, useState, useEffect } from "react";
import axios from "axios";
const HomeData = createContext();

export const HomeDataProvider = ({ children }) => {
  const [posts, setPosts] = useState([]);
  const [followers, setFollowers] = useState([]);
  const [users, setUsers] = useState([]);

  useEffect(function effectFunction() {
    console.log("Inside useEffect - first line");
    try {
      let userId = localStorage.getItem("userId");

      if (!userId) {
        console.log("No userId found in localStorage");
        return;
      }

      axios
        .get("http://localhost:8080/" + userId, {
          headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
            "Content-Type": "application/json",
          },
        })
        .then((res) => {
          if (res.data) {
            setPosts(res.data.posts);
            setFollowers(res.data.followers);
            setUsers(res.data.users);
            console.log("users from HomeDataProvider");
            console.log(res.data.users);
          }
        })
        .catch((error) => {
          console.log("request didn't go through");
          console.error(error); // Log the full error
        });
    } catch (err) {
      console.error("Error in useEffect:", err);
    }
  }, []);

  console.log("After useEffect");

  return (
    <HomeData.Provider
      value={{
        posts,
        followers,
        users,
        setPosts,
        setFollowers,
        setUsers,
      }}
    >
      {children}
    </HomeData.Provider>
  );
};

export default HomeData;
