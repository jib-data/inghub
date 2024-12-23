import NameCard from "./NameCard";

let Comment = () => {
  return (
    <>
      <NameCard />
      <p className="comment-text">
        This is a comment section.... facere possimus, omnis voluptas assumenda
        est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis
        debitis aut rerum necessitatibus saepe eveniet ut et voluptates
        repudiandae sint et molestiae non recusandae.
      </p>
      <div className="comment-reactions">
        <p className="number-likes">5k Likes</p>
        <p className="like-comment">Like Comment</p>
      </div>
    </>
  );
};

export default Comment;
