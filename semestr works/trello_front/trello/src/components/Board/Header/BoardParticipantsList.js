import React from 'react';
import Participant from "./Participant";

export default function BoardParticipantsList({participants}) {

    return (
        <div>
            <div className="text-center">
                <table className="table table-borderless">
                    <tbody>
                    {participants.map(participant => {
                        return <Participant participant={participant} key={participant.id}/>
                    })}
                    </tbody>
                </table>
            </div>
        </div>

    )
}