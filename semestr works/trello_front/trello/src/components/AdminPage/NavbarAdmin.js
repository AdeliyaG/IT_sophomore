import React, {useState} from 'react';
import {NavLink} from "react-router-dom";

const style = {
    nav: {
        backgroundColor: "rgba(37,35,37,0.95)"
    }
};

export default function NavbarAdmin(props) {
    return (
        <div>
            <nav className="navbar navbar-light justify-content-between" style={style.nav}>
                <div className="navbar-brand ml-3 text-white p-0">
                    <span>Trello mirror</span>
                </div>

                <div className="row">
                    <a className="btn btn-outline-primary mr-3 text-white" id="signInButton"
                             href="/logout" onClick={()=> localStorage.clear()}>
                        Выйти
                    </a>
                </div>
            </nav>
        </div>
    )
}