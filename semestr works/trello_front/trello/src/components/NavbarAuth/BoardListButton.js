import React, {useState} from 'react';


export default function BoardListButton(props) {
    return (
        <button type="button" className="list-group-item list-group-item-action rounded mb-0">
            <h6>{props.name}</h6>
        </button>
    )
}