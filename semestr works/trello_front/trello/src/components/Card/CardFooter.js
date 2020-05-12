import React, {useState} from 'react';
import AddItem from "./AddItem";

export default function CardFooter(props) {
    const [isUserClickedAddButton, setClick] = useState(false);

    function handler() {
        setClick(true);
    }

    function handlerAdd() {
        setClick(false);
    }

    if (isUserClickedAddButton === true) {
        return <AddItem setClick={handlerAdd}/>
    } else {
        return (
            <div className="card-footer">
                <button className="btn btn-light w-100 text-muted" onClick={()=> handler()}>
                    Добавить карточку +
                </button>
            </div>
        )
    }
}