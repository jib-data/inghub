import NavBar from "../Navigation/NavBar";
import Content from "./Content";
import Hero from "./Hero/Hero";
import { HomeDataProvider } from "./TimelineDataContext";

const Body = () => {
  if (!localStorage.getItem("token") || !localStorage.getItem("userId")) {
    window.location.href = "/sign-in";
  }
  return (
    <main className="main-body">
      {localStorage.getItem("token") && localStorage.getItem("userId") && (
        <>
          <HomeDataProvider>
            <NavBar />
            <Hero />
            <Content />
          </HomeDataProvider>
        </>
      )}
    </main>
  );
};
export default Body;
