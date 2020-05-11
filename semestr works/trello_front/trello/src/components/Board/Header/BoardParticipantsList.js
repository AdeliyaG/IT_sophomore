import React from 'react';
import Participant from "./Participant";

export default function BoardParticipantsList({participants, deleteParticipants}) {

    return (
        <div>
            <div className="text-center">
                <table className="table table-borderless">
                    <tbody>
                    {participants.map(participant => {
                        return <Participant participant={participant} key={participant.id} deleteButtonHandler={deleteParticipants}/>
                    })}
                    </tbody>
                </table>
            </div>
        </div>

    )
}