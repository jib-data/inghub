import { useContext } from "react";
import FollowContainer from "./Follow/FollowContainer";
import PostContainer from "./Post/PostContainer";
import HomeData from "./TimelineDataContext";

const Content = () => {
  const { followers, following } = useContext(HomeData);
  const followerTitle = "Followers";
  const followingTitle = "Following";

  return (
    <section className="content-section">
      <FollowContainer title={followerTitle} data={followers} />
      <PostContainer />
      <FollowContainer title={followingTitle} data={following} />
    </section>
  );
};

export default Content;
