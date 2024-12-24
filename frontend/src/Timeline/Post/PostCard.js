import CommentTextArea from "./CommentTextArea";
import Post from "./Post";

const PostCard = ({ filteredPost, setFilteredPost }) => {
  return (
    <div className="post-card">
      <Post filteredPost={filteredPost} />
      <CommentTextArea
        filteredPost={filteredPost}
        setFilteredPost={setFilteredPost}
      />
    </div>
  );
};

export default PostCard;
