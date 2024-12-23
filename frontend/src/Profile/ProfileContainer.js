import NavBar from "../Navigation/NavBar";
import ProfileInputContainer from "./ProfileInputContainer";

let ProfileContainer = () => {
  return (
    <>
      <NavBar />
      <main className="profile-body">
        <ProfileInputContainer />
      </main>
    </>
  );
};
export default ProfileContainer;
