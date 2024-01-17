import React from 'react';
import './Header.css';
import { FaCartPlus } from "react-icons/fa";
import { GiMedicines } from "react-icons/gi";
import { MdAssignmentAdd } from "react-icons/md";
import {Link} from "react-router-dom";

const Header = ({openCart}) => {
    return (
        <header className="header-container">
            <GiMedicines className="pharmacy-logo"/>
            <div className="title">
                <h1>Farmacia Online</h1>
            </div>
            <div className="icons-container">
                <Link to="/add">
                    <MdAssignmentAdd className="cart-icon"/>
                </Link>
                <FaCartPlus className="cart-icon" onClick={openCart}/>
            </div>

        </header>
    );
};

export default Header;
