import PostCard from "./PostCard";

let PostContainer = () => {
  return (
    <div className="post-container">
      <h4 className="post-header">Posts</h4>
      <input
        type="text"
        className="post-search"
        placeholder="search posts by author"
      />
      <PostCard />
    </div>
  );
};
export default PostContainer;
