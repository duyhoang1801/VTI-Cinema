import React, { useState } from 'react';
import { DownOutlined } from '@ant-design/icons';
import { Dropdown, message, Space } from 'antd';
import { NavLink } from "react-router-dom";
import { Input, Menu } from 'antd';
import { QuestionCircleOutlined, UserOutlined } from '@ant-design/icons';
import logo from '../assets/logo-remove.png'
import { Drawer } from 'antd';
const { Search } = Input;

const filmItems = [
    {
        label: 'Phim đang chiếu',
        key: 'now-showing',
    },
    {
        label: 'Phim sắp chiếu',
        key: 'coming-soon',
    },
];
const cinemaItems = [
    {
        label: 'Rạp 1',
        key: 'cinema-1',
    },
    {
        label: 'Rạp 2',
        key: 'Cinema-2',
    },
];
const accountItem = [
    {
        label: 'Đăng nhập',
        key: 'login',
    },
    {
        label: 'Đăng ký',
        key: 'signin',
    },
];

const handleClick = ({ key }) => {
    message.info(`Click on item ${key}`);
};

const onSearch = (value, _e, info) => console.log(info?.source, value);
const HeaderMenu = () => {
    const [openLoginDrawer, setOpenLoginDrawer] = useState(false)
    const [openSigninDrawer, setOpenSigninDrawer] = useState(false)
    const handleAccountClick = ({ key }) => {
        switch (key) {
            case "login":
                setOpenLoginDrawer(true);
                break;
            case "signin":
                setOpenSigninDrawer(true);
                break;
        }
    };
    const onClose = () => {
        setOpenLoginDrawer(false);
        setOpenSigninDrawer(false);
    };

    return (
        <>
            <div className="header-left">
                <NavLink className={"navlink-header"} to={"/showtime"}>Lịch chiếu</NavLink>
                <Dropdown
                    menu={{
                        items: filmItems,
                        onClick: handleClick,
                    }}
                >
                    <a onClick={(e) => e.preventDefault()}>
                        <Space>
                            Phim
                            <DownOutlined />
                        </Space>
                    </a>
                </Dropdown>
                <Dropdown
                    menu={{
                        items: cinemaItems,
                        onClick: handleClick,
                    }}
                >
                    <a onClick={(e) => e.preventDefault()}>
                        <Space>
                            Rạp
                            <DownOutlined />
                        </Space>
                    </a>
                </Dropdown>
                <NavLink className={"navlink-header"} to={"/promotion"}>Ưu đãi</NavLink>
            </div>
            <div className="header-mid">
                <img src={logo}></img>
            </div>
            <div className="header-right">
                <Search
                    placeholder="Tìm phim"
                    onSearch={onSearch}
                    style={{
                        width: 250,
                    }}
                />
                <div>
                    <QuestionCircleOutlined />
                    <a>Hỗ trợ</a>
                </div>
                <Dropdown
                    menu={{
                        items: accountItem,
                        onClick: handleAccountClick,
                    }}
                >
                    <a onClick={(e) => e.preventDefault()}>
                        <Space>
                            <UserOutlined />
                        </Space>
                    </a>
                </Dropdown>
            </div>
            <Drawer
                title="Đăng nhập"
                placement='left'
                closable={false}
                onClose={onClose}
                open={openLoginDrawer}
            >
                <p>Some contents...</p>
                <p>Some contents...</p>
                <p>Some contents...</p>
            </Drawer>
            <Drawer
                title="Đăng ký"
                placement='left'
                closable={false}
                onClose={onClose}
                open={openSigninDrawer}
            >
                <p>Some contents...</p>
                <p>Some contents...</p>
                <p>Some contents...</p>
            </Drawer>
        </>
    )
};
export default HeaderMenu;