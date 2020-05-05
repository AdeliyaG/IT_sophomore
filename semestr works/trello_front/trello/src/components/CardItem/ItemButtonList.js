import React, {useContext, useState} from 'react';
import Context from "../../context";
import ParticipantsDropdown from "./ParticipantsDropdown";
import Card from "../Card/Сard";

export default function ItemButtonList() {

    const {setShowFileAdd} = useContext(Context);
    const {showFileAdd} = useContext(Context);



    return (
        <div>
            <div className="btn-group-vertical">
                <button type="button" className="btn btn-outline-primary" id="participantsDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Участники
                </button>
                <ParticipantsDropdown/>

                <button type="button" className="btn btn-outline-primary"
                        onClick={() => setShowFileAdd(!showFileAdd)}>Прикрепить файл
                </button>
                <button type="button" className="btn btn-outline-primary">Срок</button>
                <button type="button" className="btn btn-outline-primary">Чек-лист</button>
                <button type="button" className="btn btn-outline-primary">Чат</button>
                <button type="button" className="btn btn-outline-secondary">Архивация</button>
            </div>
        </div>
    )
}