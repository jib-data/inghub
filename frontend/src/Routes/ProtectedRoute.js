import { useAuth } from "../utils/authProvider";
import { Navigate, Outlet } from "react-router-dom";

// Function to guard unauthorized requests
export const ProtectedRoute = () => {
  const { token } = useAuth();

  if (!token) {
    return <Navigate to="sign-in" />;
  }

  return <Outlet />;
};
