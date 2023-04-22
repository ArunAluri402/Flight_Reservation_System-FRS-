import { Route, Routes, useNavigate } from "react-router-dom";
import "./App.css";
import Signup from "./Pages/Signup";
import { useEffect, useState } from "react";
import { getCurrentUser } from "./Services/Worker";
import { ACCESS_TOKEN } from "./constants";
import Login from "./Pages/Login";
import DeleteFlight from "./Pages/DeleteFlight";
import AddFlight from "./Pages/AddFlight";
import ViewFlights from "./Pages/ViewFlights";
import ModifyFlight from "./Pages/ModifyFlight";
import AddFlightRoute from "./Pages/AddFlightRoute";
import UserProfile from "./Pages/UserProfile";
import ViewRoute from "./Pages/ViewRoute";
import DeleteFlightRoute from "./Pages/DeleteFlightRoute";
import ViewSchedules from "./Pages/ViewSchedules";
import DeleteSchedule from "./Pages/DeleteSchedule";
import AddSchedule from "./Pages/AddSchedule";
import ViewReservations from "./Pages/ViewReservations";
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
        <Route path="/" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/Home" element={<UserProfile />} />
        {/* Flight */}
        <Route path="/deleteflight" element={<DeleteFlight />} />
        <Route path="/addflight" element={<AddFlight />} />
        <Route path="/viewflight" element={<ViewFlights />} />
        <Route path="/modifyflight" element={<ModifyFlight />} />
        {/* Route */}
        <Route path="/addflightroute" element={<AddFlightRoute />} />
        <Route path="/delflightroute" element={<DeleteFlightRoute />} />
        <Route path="/viewflightroute" element={<ViewRoute />} />
        {/* Schedule */}
        <Route path="/viewschedules" element={<ViewSchedules />} />
        <Route path="/deleteschedule" element={<DeleteSchedule />} />
        <Route path="/addschedule" element={<AddSchedule />} />
        {/* reservations */}
        <Route path="/viewreservation" element={<ViewReservations />} />
      </Routes>
    </div>
  );
}

export default App;
