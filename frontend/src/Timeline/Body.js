import NavBar from "../Navigation/NavBar";
import Content from "./Content";
import Hero from "./Hero/Hero";

let Body = () => {
  return (
    <main className="main-body">
      <NavBar />
      <Hero />
      <Content />
    </main>
  );
};
export default Body;
