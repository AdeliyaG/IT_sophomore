import React, {useEffect, useState} from 'react';
import BoardParticipants from "./Header/BoardParticipants";
import Archive from "./Header/Archive";
import api from "../../axios/api-auth";
import Context from "../../context";

export default function BoardHeader({board}) {

    const [participants, setParticipants] = useState([]);
    const [archive, setArchive] = useState([]);

    useEffect(() => {
        api.get("/boardParticipants" + window.location.search).then((response) => {
            setParticipants(response.data);
        });

        api.get("/boardArchive" + window.location.search).then((response) => {
            setArchive(response.data);
        });

    },[]);

    function addParticipants(username) {
        api.put("/board=" + board.id + "/p", {
            username: username
        }).then((response) => {
            if (response.status !== 200) {
                alert("Bad response")
            }
        })
    }

    function deleteParticipants(username) {
        api.delete("/board=" + board.id + "/pd", { data: {
            username: username
        }}).then((response) => {
            if (response.status !== 200) {
                alert("Bad response")
            }
        })
    }

    function unarchiveItem(id) {
        api.put("/item=" + id + "/unarchive")
            .then((response) => {
            if (response.status !== 200) {
                alert("Bad response")
            }
        })
    }

    return (
        <Context.Provider value={{addParticipants, deleteParticipants, unarchiveItem}}>

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
        </Context.Provider>
    )


    // function deleteArchivedItem(id) {
    //     setArchive(archive.filter(item => item.id !== id));
    // }
}