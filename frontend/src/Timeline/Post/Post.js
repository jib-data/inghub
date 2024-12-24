import { useState } from "react";
import Comment from "./Comment";
import NameCard from "./NameCard";

const Post = ({ filteredPost }) => {
  const [disable, setDisable] = useState(true);
  const [postLikes, setPostlike] = useState(filteredPost.postLikes);
  const onHandlePostLike = () => {
    setPostlike(postLikes + 1);
  };

  const handleHide = () => {
    setDisable(!disable);
  };
  return (
    <>
      <NameCard name={filteredPost.personName} />
      <p className="post-text">{filteredPost.postText}</p>
      <div className="post-reactions">
        <p className="number-comments">
          {filteredPost.postComments.length} Comments
        </p>
        <p className="view-comments" onClick={handleHide}>
          {disable ? "View " : "Hide "}Comments
        </p>
        <p className="number-likes">{filteredPost.postLikes} Likes</p>
        <p className="like-post" onClick={onHandlePostLike}>
          Like Post
        </p>
      </div>
      <div className={disable ? "comment-section hide" : "comment-section"}>
        <h5 className="comment-header">Comments</h5>
        {filteredPost.postComments.map((comment) => {
          return <Comment key={comment.commentId} comment={comment} />;
        })}
      </div>
    </>
  );
};

export default Post;
