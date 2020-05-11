import React, {useState} from 'react';
import BoardParticipants from "./Header/BoardParticipants";
import Archive from "./Header/Archive";

export default function BoardHeader() {
    return (
        <nav className="navbar navbar-expand">
            <span className="navbar-brand mb-0 h6 ml-2">props.BoardName</span>
            <button className="btn btn-outline-dark" data-toggle="modal" data-target="#participants">Участники</button>
            <button className="btn btn-outline-dark ml-2" data-toggle="modal" data-target="#archive">Архив</button>




            <div className="modal fade" id="participants" tabIndex="-1" role="dialog"
                 aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <BoardParticipants/>
                    </div>
                </div>
            </div>

            <div className="modal fade" id="archive" tabIndex="-1" role="dialog"
                 aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <Archive/>
                    </div>
                </div>
            </div>

        </nav>
    )
}