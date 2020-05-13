import React, {useEffect, useState} from 'react';
import BoardHeader from "./BoardHeader";
import Navbar from "../NavbarAuth/Navbar";
import api from "../../axios/api-auth";
import Card from "../Card/Сard";
import AddBoardButton from "../NavbarAuth/AddBoardButton";
import Context from "../../context";
import AddCardButton from "./AddCardButton";


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
    },

    btn: {
        minWidth: 300 + "px"
    }
};

export default function Board(props) {
    const [boards, setBoards] = useState([]); // for navbar

    const [board, setBoard] = useState([]);
    const [cards, setCards] = useState([]);

    useEffect(() => {
        api.get("/board" + props.location.search).then((response) => {
            setBoard(response.data);
            setCards(response.data.cards);
        });
    }, []);

    useEffect(() => {
        api.get("/").then((response) => {
            setBoards(response.data);
        });
    }, []);

    function addNewCard(name) {
        api.post("/board=" + board.id + "/addCard", {
            title: name
        }).then((response) => {
            if (response.status !== 200) {
                alert("Bad response")
            }
        });
    }

    return (
        <Context.Provider value={{addNewCard}}>
            <Navbar user={localStorage.getItem("currentUser")} boards={boards}/>
            <div className="overflow-auto" style={style.bg}>
                <BoardHeader board={board}/>
                <div className="container-fluid flex-nowrap">
                    <div id="cardContainer" className="row flex-nowrap ml-2" style={style.card}>

                        {cards.map((card) =>
                            <Card card={card} key={card.id}/>)
                        }

                        <AddCardButton/>
                    </div>
                </div>
            </div>
        </Context.Provider>
    )
}