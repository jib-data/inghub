import UsersListItem from "./UsersListItem";

let UsersContainer = ({ title, users, setUsers }) => {
  // Make a get request here to get the users followers
  // I will need a function to accept followers
  // I will need a function

  return (
    <aside className="follow-container">
      <h5 className="follow-head">Users</h5>
      <ul className="follow-list">
        {users &&
          users.map((user) => {
            return <UsersListItem key={users.id} user={user} />;
          })}
      </ul>
    </aside>
  );
};
export default UsersContainer;
