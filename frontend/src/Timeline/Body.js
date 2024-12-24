import { useContext } from "react";
import NavBar from "../Navigation/NavBar";
import Content from "./Content";
import Hero from "./Hero/Hero";
import HomeData, { HomeDataProvider } from "./TimelineDataContext";

const Body = () => {
  // Access the token from local storage
  // Make the API call to get posts.
  // Set state to data received
  // pass needed data to respective children

  // 1. for friend and friend request
  // data for requests
  // data for friends friends
  // handle to accept friends

  // 2. for posts
  // data for posts
  // handler for adding posts
  // each post has comments
  // handler for adding comments

  // Create a useContext to get the posts data and

  //
  return (
    <main className="main-body">
      <HomeDataProvider>
        <NavBar />
        <Hero />
        <Content />
      </HomeDataProvider>
    </main>
  );
};
export default Body;
