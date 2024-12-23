import FollowContainer from "./Follow/FollowContainer";
import PostContainer from "./Post/PostContainer";

let Content = () => {
  return (
    <section className="content-section">
      <FollowContainer />
      <PostContainer />
      <FollowContainer />
    </section>
  );
};

export default Content;
