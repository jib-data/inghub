let Hero = () => {
  return (
    <>
      <section className="hero">
        <div className="img"></div>
        <div className="banner">
          <h2 className="welcome-message">
            Welcome <span>Jibril</span>
          </h2>
          <h5 className="follwers">
            Followers <span className="num-followers">500k</span>
          </h5>
          <h5 className="following">
            Following <span className="num-following">500k</span>
          </h5>
          <input
            className="post-input"
            type="text"
            placeholder="share your thoughts..."
          />
        </div>
      </section>
    </>
  );
};

export default Hero;
