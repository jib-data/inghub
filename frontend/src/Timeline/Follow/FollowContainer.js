import FollowListItem from "./FollowListItem";

let FollowContainer = ({ title, data }) => {
  // Make a get request here to get the users followers
  // I will need a function to accept followers
  // I will need a function
  return (
    <aside className="follow-container">
      <h5 className="follow-head">{title}</h5>
      <ul className="follow-list">
        {data.map((follow) => {
          return <FollowListItem key={follow.id} follow={follow} />;
        })}
      </ul>
    </aside>
  );
};
export default FollowContainer;
