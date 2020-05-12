import React, {useEffect, useState} from 'react';
import BoardParticipants from "./Header/BoardParticipants";
import Archive from "./Header/Archive";
import api from "../../axios/api-auth";

export default function BoardHeader({board}) {

    const [participants, setParticipants] = useState([]);
    const [archive, setArchive] = useState([]);


    useEffect(() => {
        api.get("/boardParticipants"+window.location.search).then((response) => {
            setParticipants(response.data);
        });

        api.get("/boardArchive"+window.location.search).then((response) => {
            setArchive(response.data);
        });
    }, []);


    return (
        <nav className="navbar navbar-expand">
            <span className="navbar-brand mb-0 h6 ml-2">{board.name}</span>
            <button className="btn btn-outline-dark" data-toggle="modal" data-target="#participants">
                Участники
            </button>
            <button className="btn btn-outline-dark ml-2" data-toggle="modal" data-target="#archive">
                Архив
            </button>


            <div className="modal fade" id="participants" tabIndex="-1" role="dialog"
                 aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <BoardParticipants participants={participants}/>
                    </div>
                </div>
            </div>

            <div className="modal fade" id="archive" tabIndex="-1" role="dialog"
                 aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <Archive archive={archive}/>
                    </div>
                </div>
            </div>

        </nav>
    )

    // function addParticipants(email) {
    //     // find user by email
    //     let id = Date.now();
    //     let elem = {
    //         id: id,
    //         username: "user.getUsername",
    //         email: email,
    //     };
    //     setParticipants(participants.concat([elem]));
    // }
    //
    // function deleteParticipants(id) {
    //     setParticipants(participants.filter(participant => participant.id !== id));
    // }




    // function deleteArchivedItem(id) {
    //     setArchive(archive.filter(item => item.id !== id));
    // }
}