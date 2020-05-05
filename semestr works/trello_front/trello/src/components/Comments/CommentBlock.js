import React, {useState} from 'react';
import Comment from "./Comment";

export default function CommentBlock() {
    return (
        <div>
            <div className="form-inline mb-2 mt-3">
                <label htmlFor="boardName" className="col-form-label mr-2">Комментарии:</label>
            </div>
            <input type="text" className="form-control" placeholder="Добавить комментарий"/>
            <Comment/>
            <Comment/>
        </div>
    )
}