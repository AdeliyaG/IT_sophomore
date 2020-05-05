import React, {useState} from 'react';

export default function BoardHeaderForAnon() {
    return (
        <nav className="navbar navbar-expand">
            <span className="navbar-brand mb-0 h6 ml-2">props.BoardName</span>
            <button className="btn btn-outline-dark">Участники</button>
        </nav>
    )
}