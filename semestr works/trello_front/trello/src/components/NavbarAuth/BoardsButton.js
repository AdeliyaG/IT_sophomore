import React, {useState} from 'react';

export default function BoardsButton(props) {
    return (
        <button className="btn btn-primary ml-3" type="button" id="dropdownMenuButton"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Доски
        </button>
    )
}