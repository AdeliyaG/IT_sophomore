import React, {useState} from 'react';

export default function ItemHeader() {
    return (
        <div className="modal-header">
            <h5 className="modal-title" id="itemLabel">props.itemName</h5>
            <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    )
}