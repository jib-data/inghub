import NavBar from "../Navigation/NavBar";
import Content from "./Content";
import Hero from "./Hero/Hero";
import { HomeDataProvider } from "./TimelineDataContext";

const Body = () => {
  return (
    <main className="main-body">
      <HomeDataProvider>
        <NavBar />
        <Hero />
        <Content />
      </HomeDataProvider>
    </main>
  );
};
export default Body;
