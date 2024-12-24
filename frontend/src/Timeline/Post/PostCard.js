import CommentTextArea from "./CommentTextArea";
import Post from "./Post";

let PostCard = ({ post, setFilteredPost }) => {
  // Destructuring the comment in this section
  // The comment add handler I go pass the comment list to the post and down to where we are rendering the comments

  return (
    <div className="post-card">
      <Post post={post} />
      <CommentTextArea post={post} setFilteredPost={setFilteredPost} />
    </div>
  );
};

export default PostCard;
