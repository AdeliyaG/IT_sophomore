import React, {useState} from 'react';
import BoardParticipantsList from "./BoardParticipantsList";
import BoardParticipantAdd from "./BoardParticipantAdd";

export default function BoardParticipants() {
    const [participants, setParticipants] = useState([
        {id: 1, username: "user1", email: "user1@mail.ru"},
        {id: 2, username: "user2", email: "user2@mail.ru"}
    ]);

    function addParticipants(email) {
        // find user by email
        let id = Date.now();
        let elem = {
            id: id,
            username: "user.getUsername",
            email: email,
        };
        setParticipants(participants.concat([elem]));
    }

    function deleteParticipants(id) {
        setParticipants(participants.filter(participant => participant.id !== id));
    }

    return (
        <div>
            <div className="modal-header">
                <h5 className="modal-title" id="participants">Участники</h5>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div className="modal-body">
                <BoardParticipantAdd addParticipants={addParticipants} />
                <BoardParticipantsList participants={participants} deleteParticipants={deleteParticipants}/>
            </div>
            <div className="modal-footer">
                <button type="button" className="btn btn-secondary" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    )
}