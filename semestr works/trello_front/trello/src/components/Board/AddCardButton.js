import React, {useState} from 'react';
import AddCard from "./AddCard";


const style = {
    btn: {
        minWidth: 300 + "px"
    }
};

export default function AddCardButton(props) {
    const [isUserClickedAddButton, setClick] = useState(false);

    function handler() {
        setClick(true);
    }

    function handlerAdd() {
        setClick(false);
    }

    if (isUserClickedAddButton === true) {
        return <AddCard setClick={handlerAdd}/>
    } else {
        return (
                <button className="btn btn-outline-primary w-25 h-25 mt-1" style={style.btn}
                        onClick={()=> handler()}>
                    Добавить колонку +
                </button>
        )
    }
}