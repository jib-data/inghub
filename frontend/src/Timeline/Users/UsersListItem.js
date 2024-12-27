let UsersListItem = ({ user }) => {
  return (
    <>
      <li className="follow-list-item">
        <div className="follow-image"></div>
        <div>
          <h6 className="follow-name">
            {user.firstName + " " + user.lastName}
            {console.log(user.id)}
          </h6>
          <p className="num-followers">5 Followers</p>
          <button>Follow User</button>
        </div>
      </li>
    </>
  );
};

export default UsersListItem;
