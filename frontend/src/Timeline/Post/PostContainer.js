import { useContext } from "react";
import PostCard from "./PostCard";
import HomeData from "../TimelineDataContext";

let PostContainer = () => {
  // extract posts
  // loop through the list then render
  const { posts, setPosts } = useContext(HomeData);

  return (
    <div className="post-container">
      <h4 className="post-header">Posts</h4>
      <input
        type="text"
        className="post-search"
        placeholder="search posts by author"
      />
      {posts.map((post) => {
        return <PostCard key={post.postId} post={post} setPosts={setPosts} />;
      })}
    </div>
  );
};
export default PostContainer;
