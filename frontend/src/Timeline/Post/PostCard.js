import CommentTextArea from "./CommentTextArea";
import Post from "./Post";

let PostCard = () => {
  return (
    <div className="post-card">
      <Post />
      <CommentTextArea />
    </div>
  );
};
export default PostCard;
