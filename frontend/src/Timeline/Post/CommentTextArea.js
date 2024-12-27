import axios from "axios";
import { useState } from "react";

let CommentTextArea = ({ filteredPost, setFilteredPosts, setPosts }) => {
  const [commentText, setCommentText] = useState("");
  const filteredPostId = filteredPost.postId;
  const newCommentData = {
    post: { postId: filteredPostId },
    commentText,
    person: {
      Id: localStorage.getItem("userId"),
    },
  };

  const onAddComments = () => {
    axios
      .post("http://localhost:8080/comment", newCommentData, {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("token"),
        },
      })
      .then((res) => {
        const newComment = res.data;

        // Update the filteredPosts array in the parent state
        setFilteredPosts((prevPosts) =>
          prevPosts.map((post) =>
            post.postId === filteredPostId
              ? { ...post, postComments: [...post.postComments, newComment] }
              : post
          )
        );

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
