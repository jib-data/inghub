import { useState } from "react";
import Comment from "./Comment";
import NameCard from "./NameCard";

const Post = ({ post }) => {
  const [disable, setDisable] = useState(true);
  const [postLikes, setPostlike] = useState(post.postLikes);

  const handleHide = () => {
    setDisable(!disable);
  };
  return (
    <>
      <NameCard name={post.personName} />
      <p className="post-text">{post.postText}</p>
      <div className="post-reactions">
        <p className="number-comments">{post.postComments.length} Comments</p>
        <p className="view-comments" onClick={handleHide}>
          {disable ? "View " : "Hide "}Comments
        </p>
        <p className="number-likes">{postLikes} Likes</p>
        <p
          className="like-post"
          onClick={() => {
            setPostlike(postLikes + 1);
          }}
        >
          Like Post
        </p>
      </div>
      <div className={disable ? "comment-section hide" : "comment-section"}>
        <h5 className="comment-header">Comments</h5>
        {post.postComments.map((comment) => {
          return <Comment key={comment.commentId} comment={comment} />;
        })}
      </div>
    </>
  );
};

export default Post;
