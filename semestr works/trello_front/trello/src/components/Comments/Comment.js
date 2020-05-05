import React, {useState} from 'react';

export default function Comment() {
    return (
        <div>
            <div className="container-fluid mt-3 shadow-sm p-3 mb-2 bg-white border rounded">
                <button type="button" className="close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h6>props.username</h6>
                <span>комментарий</span>
            </div>
        </div>
    )
}