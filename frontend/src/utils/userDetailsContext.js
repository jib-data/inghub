// to grab user details
//  login
// save jwt
// simply to save relevant user detail;
// userId
// firstName

import { createContext, useContext, useState, useEffect } from "react";
export const UserDetailsContext = createContext(null);

export const useUserDetailsContext = () => {
  const context = useContext(UserDetailsContext);
  if (context === null) {
    throw new Error("useUserData must be used within a UserProvider");
  }
  return context;
};

export const UserDetailsProvider = ({ children }) => {
  let [userData, setUserData] = useState("");

  useEffect(() => {
    if (!userData) {
    }
  }, []);
};
