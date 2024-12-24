import { useContext, useState, useEffect } from "react";
import PostCard from "./PostCard";
import HomeData from "../TimelineDataContext";

const PostContainer = () => {
  const { posts, setPosts } = useContext(HomeData);

  const [filteredPosts, setFilteredPosts] = useState([]);

  useEffect(() => {
    setFilteredPosts(posts || []);
  }, [posts]);

  const handleSearch = (e) => {
    const query = e.target.value.toLowerCase();
    setFilteredPosts(
      posts.filter((post) => post.personName.toLowerCase().includes(query))
    );
  };

  return (
    <div className="post-container">
      <h4 className="post-header">Posts</h4>
      <input
        type="text"
        className="post-search"
        placeholder="Search posts by author"
        onChange={handleSearch}
      />
      {filteredPosts.length > 0 ? (
        filteredPosts.map((post) => (
          <PostCard
            key={post.postId}
            post={post}
            setFilteredPosts={setFilteredPosts}
          />
        ))
      ) : (
        <p>No posts available</p>
      )}
    </div>
  );
};

export default PostContainer;
