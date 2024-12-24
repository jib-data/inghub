let FollowListItem = ({ follow }) => {
  return (
    <>
      <li className="follow-list-item">
        <div className="follow-image"></div>
        <div>
          <h6 className="follow-name">
            {follow.firstName + " " + follow.lastName}
          </h6>
          <p className="num-followers">5 Followers</p>
        </div>
      </li>
    </>
  );
};

export default FollowListItem;
