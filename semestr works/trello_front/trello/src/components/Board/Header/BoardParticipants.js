import React from 'react';
import BoardParticipantsList from "./BoardParticipantsList";
import BoardParticipantAdd from "./BoardParticipantAdd";

export default function BoardParticipants({participants}) {

    return (
        <div>
            <div className="modal-header">
                <h5 className="modal-title" id="participants">Участники</h5>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div className="modal-body">
                <BoardParticipantAdd />
                <BoardParticipantsList participants={participants}/>
            </div>
            <div className="modal-footer">
                <button type="button" className="btn btn-secondary" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    )
}