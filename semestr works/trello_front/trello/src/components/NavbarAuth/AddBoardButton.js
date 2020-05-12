import React, {useState} from 'react';
import api from "../../axios/api-auth";

export default function AddBoardButton() {
    const [newBoardTitle, setNewBoardTitle] = useState("");

    function submitHandler(event) {
        event.preventDefault();

        api.post("/createBoard", {
            name: newBoardTitle,
        }).then((response) => {
            if (response.status === 200) {
                window.location = "/board?b=" + response.data.id
            } else {
                alert("Bad response")
            }
        });

        setNewBoardTitle("")
    }

    return (
        <div>
            <button name="addBoard" className="btn btn-outline-primary ml-2" data-toggle="modal"
                    data-target="#addBoard">+
            </button>

            <div className="modal fade" id="addBoard" tabIndex="-1" role="dialog"
                 aria-labelledby="modalLabel" aria-hidden="true">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="modalLabel">Создать доску</h5>
                            <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <form onSubmit={submitHandler}>
                            <div className="modal-body">
                                <div className="form-group">
                                    <label htmlFor="boardName" className="col-form-label">Введите название
                                        доски:</label>
                                    <input type="text" className="form-control" id="boardName"
                                           value={newBoardTitle}
                                           onChange={event => setNewBoardTitle(event.target.value)}
                                    />
                                </div>
                            </div>
                            <div className="modal-footer">
                                <button type="submit" className="btn btn-primary">Создать</button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>

        </div>


    )
}