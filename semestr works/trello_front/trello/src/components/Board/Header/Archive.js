import React, {useState} from 'react';
import ArchiveList from "./ArchiveList";
import BoardParticipantsList from "./BoardParticipantsList";

export default function Archive({archive}) {

    return (
        <div>
            <div className="modal-header">
                <h5 className="modal-title" id="participants">Архив карточек</h5>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div className="modal-body">
                <ArchiveList archive={archive.filter(item => item.itemStatus !== "OPENED")}/>
            </div>
            <div className="modal-footer">
                <button type="button" className="btn btn-secondary" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    )
}