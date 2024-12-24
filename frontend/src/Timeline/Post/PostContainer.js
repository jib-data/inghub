import { useContext, useState, useEffect } from "react";
import PostCard from "./PostCard";
import HomeData from "../TimelineDataContext";

const PostContainer = () => {
  // Extract posts from context
  const { posts, setPosts } = useContext(HomeData);

  // State for filtered posts
  const [filteredPosts, setFilteredPosts] = useState([]);

  // Update filteredPosts whenever posts changes
  useEffect(() => {
    setFilteredPosts(posts || []);
  }, [posts]); // Dependency ensures filteredPosts is updated when posts changes

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
          <PostCard key={post.postId} post={post} setPosts={setPosts} />
        ))
      ) : (
        <p>No posts available</p>
      )}
    </div>
  );
};

export default PostContainer;
