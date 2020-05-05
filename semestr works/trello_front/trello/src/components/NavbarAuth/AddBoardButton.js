import React, {useState} from 'react';

export default function AddBoardButton() {
    return (
        <div>
            <button name="addBoard" className="btn btn-outline-primary ml-2" data-toggle="modal" data-target="#addBoard">+</button>

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
                        <div className="modal-body">
                            <form>
                                <div className="form-group">
                                    <label htmlFor="boardName" className="col-form-label">Введите название доски:</label>
                                    <input type="text" className="form-control" id="boardName"/>
                                </div>
                            </form>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-primary">Создать</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>


    )
}