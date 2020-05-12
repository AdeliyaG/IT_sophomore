import React, {useState} from 'react';

export default function ItemHeader(props) {
    return (
        <div className="modal-header">
            <h5 className="modal-title ml-3" id="itemLabel">{props.item.title}</h5>
            <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    )
}