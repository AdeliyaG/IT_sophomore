import React, {useState} from 'react';


export default function BoardListButton({board}) {
    return (
        <button type="button" className="list-group-item list-group-item-action rounded mb-0">
            <a href={"/board?b="+board.id}>{board.name}</a>
        </button>
    )
}