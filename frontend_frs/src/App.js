import { Route, Routes, useNavigate } from "react-router-dom";
import "./App.css";
import Signup from "./Pages/Signup";
import { useEffect, useState } from "react";
import { getCurrentUser } from "./Services/Worker";
import { ACCESS_TOKEN } from "./constants";
import Dashboard from "./Pages/Dashboard";
import Home from "./Pages/Home";
import Login from "./Pages/Login";

function App() {
  const nav = useNavigate();
  const [Data, setData] = useState({
    currentUser: null,
    isAuthenticated: false,
    isLoading: true,
  });
  const loadCurrentUser = () => {
    getCurrentUser()
      .then((response) => {
        setData({
          currentUser: response,
          isAuthenticated: true,
          isLoading: false,
        });
      })
      .catch((error) => {
        setData({
          isLoading: false,
        });
      });
  };

  useEffect(() => {
    loadCurrentUser();
  }, []);

  const handleLogOut = () => {
    nav("/");
    localStorage.removeItem(ACCESS_TOKEN);
    setData({
      currentUser: null,
      isAuthenticated: false,
    });
  };

  const handleLogin = () => {
    loadCurrentUser();
  };
  if (Data.isLoading == true) {
    return (
      <h2 style={{ position: "absolute", top: "40%", left: "45%" }}>
        Loading...
      </h2>
    );
  }

  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Login onLogin={handleLogin} />} />
        <Route
          path="/Dashboard"
          element={
            <Dashboard
              isAuthenticated={Data.isAuthenticated}
              currentUser={Data.currentUser}
              handleLogout={handleLogOut}
            />
          }
        />

        <Route path="/signup" element={<Signup />} />
        <Route path="/Home" element={<Home />} />
      </Routes>
    </div>
  );
}

export default App;
