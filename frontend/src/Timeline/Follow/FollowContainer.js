import FollowList from "./FollowList";

let FollowContainer = () => {
  return (
    <aside className="follow-container">
      <h5 className="follow-head">Following</h5>
      <div>
        <FollowList />
      </div>
    </aside>
  );
};
export default FollowContainer;
