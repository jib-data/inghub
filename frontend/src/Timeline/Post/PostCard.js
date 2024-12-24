import CommentTextArea from "./CommentTextArea";
import Post from "./Post";

let PostCard = ({ post }) => {
  return (
    <div className="post-card">
      <Post post={post} />
      <CommentTextArea post={post} />
    </div>
  );
};

export default PostCard;
