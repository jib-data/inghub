let ProfileInputContainer = () => {
  //  grab access token from global and user ID
  // Make get request to get user date and populate values with it

  return (
    <div className="profile-container">
      <h4 className="profile-header">User Profile</h4>
      <h5 className="sign-subhead">edit and submit</h5>
      <div className="profile-input">
        <div className="sign-left-input">
          <input className="input" type="text" placeholder="enter first name" />
          <input className="input" type="text" placeholder="enter username" />
          <input className="input" type="text" placeholder="email" />
        </div>
        <div className="sign-right-input">
          <input className="input" type="text" placeholder="last name" />
          <input className="input" type="password" placeholder="password" />
        </div>
      </div>

      <button className="sign-submit">Submit Edit</button>
    </div>
  );
};

export default ProfileInputContainer;
