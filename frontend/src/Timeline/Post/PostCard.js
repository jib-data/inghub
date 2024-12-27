import CommentTextArea from "./CommentTextArea";
import Post from "./Post";

const PostCard = ({ filteredPost, setFilteredPosts, setPosts }) => {
  return (
    <div className="post-card">
      <Post filteredPost={filteredPost} />
      <CommentTextArea
        filteredPost={filteredPost}
        setFilteredPosts={setFilteredPosts}
        setPosts={setPosts}
      />
    </div>
  );
};

export default PostCard;
