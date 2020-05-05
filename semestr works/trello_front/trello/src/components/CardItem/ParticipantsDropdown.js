import React, {useState} from 'react';
import ParticipantsList from "./ParticipantsList";


export default function ParticipantsDropdown(props) {
    const [participants, setParticipants] = useState([
        {id: 1, name: "Participant1"},
        {id: 2, name: "Participant2"},
        {id: 3, name: "Participant3"}
    ]);


    return (
        <div className="dropdown-menu dropdown-menu border-primary shadow" aria-labelledby="participantsDropdown">
            {participants.map((participant) =>
                <ParticipantsList participant={participant} key={participants.id}/>
                )}
        </div>
    )
}