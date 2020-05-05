import React, {useState} from 'react';


export default function ParticipantsList(props) {
    return (
        <div className="row custom-control-inline mb-1">
            <div className="col-11">
                <a className="dropdown-item disabled">{props.participant.name}</a>
            </div>
            <div className="col-1 p-0">
                <button type="button" className="close"><span aria-hidden="true">&times;</span></button>
            </div>
        </div>
    )
}