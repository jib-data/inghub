import { Route, Routes } from "react-router-dom";
import "./App.css";
import ProfileContainer from "./Profile/ProfileContainer";
import SignInContainer from "./SignIn/SignInContainer";
import SignUpContainer from "./SignUp/SignUpContainer";
import Body from "./Timeline/Body";

export default function App() {
  return (
    <>
      <Routes>
        <Route path="/sign-in" element={<SignInContainer />} />
        <Route path="/sign-up" element={<SignUpContainer />} />
        <Route path="/" element={<Body />} />
        <Route path="/profile" element={<ProfileContainer />} />
        <Route path="sign-in" element={<SignInContainer />} />
      </Routes>
    </>
  );
}
