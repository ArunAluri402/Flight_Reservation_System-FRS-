import React from "react";
import { useNavigate } from "react-router-dom";

function Header({ buttonclassName, buttonName }) {
  const nav = useNavigate();
  const handleLogout = () => {
    nav("/");
  };

  return (
    <div>
      <div className="header">
        <img className="header_logo" src="./Assets/logo.png" />

        <div className="options">
          <h5 className={buttonclassName} onClick={handleLogout}>
            {buttonName}
          </h5>
        </div>
      </div>
    </div>
  );
}

export default Header;
