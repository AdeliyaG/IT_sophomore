import React, {useState} from 'react';
import ArchiveList from "./ArchiveList";
import BoardParticipantsList from "./BoardParticipantsList";

export default function Archive() {
    const [archive, setArchive] = useState([
        {id: 1, itemTitle: "item1", card:"card1", status: "ARCHIVED"},
        {id: 2, itemTitle: "item2", card:"card1", status: "OPENED"},
        {id: 3, itemTitle: "item2", card:"card2", status: "ARCHIVED"}
    ]);

    function deleteArchivedItem(id) {
        setArchive(archive.filter(item => item.id !== id));
    }

    return (
        <div>
            <div className="modal-header">
                <h5 className="modal-title" id="participants">Архив карточек</h5>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div className="modal-body">
                <ArchiveList archive={archive.filter(item => item.status !== "OPENED")}
                             deleteArchivedItem={deleteArchivedItem}/>
            </div>
            <div className="modal-footer">
                <button type="button" className="btn btn-secondary" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    )
}