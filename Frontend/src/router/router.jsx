import React from "react";
import { Route, Routes } from "react-router-dom";
import Homepage from "../pages/homepage";
import Showtime from "../pages/showtime";
import Promotion from "../pages/promotion";

const router = <Routes>
    <Route path="/" element={<Homepage />} />
    <Route path="/showtime" element={<Showtime />} />
    <Route path="/promotion" element={<Promotion />} />
</Routes>


export default router;