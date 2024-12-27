import { useContext } from "react";
import FollowContainer from "./Following/FollowingContainer";
import PostContainer from "./Post/PostContainer";
import HomeData from "./TimelineDataContext";
import UsersContainer from "./Users/UsersContainer";

const Content = () => {
  const { followers, users, setUsers } = useContext(HomeData);
  console.log("users from content component");
  console.log(users);

  const followerTitle = "Following";

  return (
    <section className="content-section">
      {followers && <FollowContainer title={followerTitle} data={followers} />}
      <PostContainer />
      {users && <UsersContainer users={users} setUsers={setUsers} />}
    </section>
  );
};

export default Content;
