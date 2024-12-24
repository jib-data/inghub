import axios from "axios";
import { useState } from "react";

let CommentTextArea = ({ post }) => {
  const [commentText, setCommentText] = useState("");
  const [receivedComments, setReceivedComments] = useState(post.postComments);
  const postId = post.postId;

  const onAddComments = () => {
    const data = {
      post: { postId },
      commentText,
    };
    axios
      .post("http://localhost:8080/comment", data, {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("token"),
        },
      })
      .then((res) => {
        const newComment = res.data;
        console.log("request went through");
        setReceivedComments((prevComments) => [
          newComment,
          ...receivedComments,
        ]);
        setCommentText("");
      })
      .catch((error) => console.log(error.response));
  };

  return (
    <>
      <textarea
        className="comment-textarea"
        placeholder="add comment..."
        value={commentText}
        onChange={(e) => {
          setCommentText(e.target.value);
        }}
      ></textarea>
      <button onClick={onAddComments}>Add Comment</button>
    </>
  );
};

export default CommentTextArea;
