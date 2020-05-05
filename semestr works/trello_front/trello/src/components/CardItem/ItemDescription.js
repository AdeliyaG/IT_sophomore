import React, {useState} from 'react';

export default function ItemDescription() {
    return (
        <div>
            <div className="form-inline mb-2">
                <label htmlFor="boardName" className="col-form-label mr-2">Описание </label>
                <button type="button" className="btn btn-outline-primary" >Изменить</button>
            </div>
            <textarea class="form-control" placeholder="Добавить описание..."/>
        </div>
    )
}