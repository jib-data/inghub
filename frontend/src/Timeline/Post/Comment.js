import { useState } from "react";
import NameCard from "./NameCard";

let Comment = ({ comment }) => {
  const [commentlikes, setCommentLikes] = useState(comment.commentLikes);

  return (
    <>
      <NameCard />
      <p className="comment-text">{comment.commentText}</p>
      <div className="comment-reactions">
        <p className="number-likes">{commentlikes} Likes</p>
        <p
          className="like-comment"
          onClick={() => {
            setCommentLikes(commentlikes + 1);
          }}
        >
          Like Comment
        </p>
      </div>
    </>
  );
};

export default Comment;
