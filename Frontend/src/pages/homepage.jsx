import React, { useState } from "react";
import { NavLink } from "react-router-dom";
import logo from '../assets/logo-remove.png'
import '../styles/homepage.css';
import { Menu } from 'antd';
import { QuestionCircleOutlined, UserOutlined } from '@ant-design/icons';
import { Input, Space } from 'antd';
import HeaderMenu from "../component/headerMenu";
const { Search } = Input;

function getItem(label, key, icon, children, type) {
    return {
        key,
        icon,
        children,
        label,
        type,
    };
}
const accountItem = [
    getItem(null, null, <UserOutlined />, [
        getItem('Đăng nhập', 'login'),
        getItem('Đăng ký', 'singup')
    ])
];

const onClick = (e) => {
    console.log('click', e);
};
const onSearch = (value, _e, info) => console.log(info?.source, value);


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