import React, {useEffect, useState} from 'react';
import BoardHeader from "./BoardHeader";
import Navbar from "../NavbarAuth/Navbar";
import api from "../../axios/api-auth";


const style = {
    bg: {
        // backgroundImage: "url(" + "https://images.pexels.com/photos/3473569/pexels-photo-3473569.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" + ")",
        // backgroundImage: "url(" + "https://images.pexels.com/photos/3774057/pexels-photo-3774057.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" + ")",
        backgroundImage: "url(" + "https://images.pexels.com/photos/1054201/pexels-photo-1054201.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" + ")",
        backgroundPosition: 'center',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        height: 509
        // height: 100+"%"
    },

    card: {
        flexWrap: "none",
    }
}

export default function Board(props) {

    const [board, setBoard] = useState([]);

    useEffect(() => {
        api.get("/board" + props.location.search).then((response) => {
            setBoard(response.data);
        });
    }, []);

    return (
        <>
            <Navbar user={localStorage.getItem("currentUser")}/>
            <div className="overflow-auto" style={style.bg}>
                <BoardHeader board={board}/>
                <div className="container-fluid flex-nowrap">
                    <div id="cardContainer" className="row flex-nowrap ml-2" style={style.card}>
                        {/*{board.map((card) =>*/}
                        {/*    <Card card={card} key={card.id}/>)}*/}

                        <button className="btn btn-outline-primary w-25 h-25 mt-1">Добавить колонку
                            +
                        </button>

                        {/*onClick={addNewCard}*/}
                    </div>
                </div>
            </div>
        </>
    )

    // function addNewCard() {
    //     let newCard = {
    //         id: Date.now(),
    //         name: "newName"
    //     };
    //     setCards(cards.concat(newCard))
    // }

}