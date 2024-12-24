import axios from "axios";
import { useState } from "react";

let CommentTextArea = ({ filteredPost, setFilteredPost }) => {
  const [commentText, setCommentText] = useState("");
  const filteredPostId = filteredPost.postId;

  const onAddComments = () => {
    const data = {
      post: { postId: filteredPostId },
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
        // // console.log(res.data);
        // setFilteredPost((filteredPost) => {
        //   const updatedPost = {
        //     ...filteredPost,
        //     postComments: [...filteredPost.postComments, newComment],
        //   };
        //   return updatedPost;
        // });
        setCommentText("");
      })
      .catch((error) => console.log(error));
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
