import React from "react";
import '../styles/homepage.css';
import HeaderMenu from "../component/headerMenu";

const Homepage = () => {
    return (
        <div className="homepage-container">
            <div className="header-container">
                <HeaderMenu />
            </div>
        </div>
    )
}

export default Homepage;