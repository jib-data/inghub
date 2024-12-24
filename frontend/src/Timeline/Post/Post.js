import { useState } from "react";
import Comment from "./Comment";
import NameCard from "./NameCard";

let Post = ({ post }) => {
  let [disable, setDisable] = useState(true);

  let handleHide = () => {
    setDisable(!disable);
  };
  return (
    <>
      <NameCard name={post.personName} />
      <p className="post-text">{post.postText}</p>
      <div className="post-reactions">
        <p className="number-comments">{post.postComments.length}</p>
        <p className="view-comments" onClick={handleHide}>
          {disable ? "View " : "Hide "}Comments
        </p>
        <p className="number-likes">{post.likes}</p>
        <p className="like-post">Like Comment</p>
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
