import React, { useState } from 'react';
import { DownOutlined } from '@ant-design/icons';
import { Dropdown, message, Space } from 'antd';
import { NavLink } from "react-router-dom";
import { Input, Menu } from 'antd';
import { QuestionCircleOutlined, UserOutlined } from '@ant-design/icons';
import logo from '../assets/logo-remove.png'
import { Button, Modal } from 'antd';
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

const handleAccountClick = ({ key }) => {
    message.info(`Click on item ${key}`);
};
const onSearch = (value, _e, info) => console.log(info?.source, value);
const HeaderMenu = () => {
    const [open, setOpen] = useState(false)
    return (
        <>
            <div className="header-left">
                <NavLink className={"navlink-header"} to={"/showtime"}>Lịch chiếu</NavLink>
                <Dropdown
                    menu={{
                        items: filmItems,
                        onClick: handleAccountClick,
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
                    menu={{ items: cinemaItems }}
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
                        onClick: () => setOpen(true),
                    }}
                >
                    <a onClick={(e) => e.preventDefault()}>
                        <Space>
                            <UserOutlined />
                        </Space>
                    </a>
                </Dropdown>
            </div>
            <Modal
                title="Modal 1000px width"
                centered
                open={open}
                onOk={() => setOpen(false)}
                onCancel={() => setOpen(false)}
                width={1000}

            >
                <p>some contents...</p>
                <p>some contents...</p>
                <p>some contents...</p>
            </Modal>
        </>
    )
};
export default HeaderMenu;