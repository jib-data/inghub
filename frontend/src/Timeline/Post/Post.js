import { useState } from "react";
import Comment from "./Comment";
import NameCard from "./NameCard";

let Post = () => {
  let [disable, setDisable] = useState("true");

  let handleHide = () => {
    setDisable(!disable);
  };
  return (
    <>
      <NameCard />
      <p className="post-text">
        This is post... At vero eos et accusamus et iusto odio dignissimos
        ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti
        quos dolores et quas molestias excepturi sint occaecati cupiditate non
        provident, similique sunt in culpa qui officia deserunt mollitia animi,
        id est laborum et dolorum fuga. Et harum quidem rerum facilis est et
        expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi
        optio cumque nihil impedit quo minus id quod maxime placeat facere
        possimus.
      </p>
      <div className="post-reactions">
        <p className="number-comments">5k Comments</p>
        <p className="view-comments" onClick={handleHide}>
          {disable ? "View " : "Hide "}Comments
        </p>
        <p className="number-likes">5k Likes</p>
        <p className="like-post">Like Comment</p>
      </div>
      <div className={disable ? "comment-section hide" : "comment-section"}>
        <h5 className="comment-header">Comments</h5>
        <Comment />
        <Comment />
        <Comment />
      </div>
    </>
  );
};

export default Post;
