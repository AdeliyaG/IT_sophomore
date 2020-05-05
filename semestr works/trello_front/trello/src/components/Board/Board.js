import React, {useState} from 'react';
import BoardHeader from "./BoardHeader";
import Card from "../Card/Сard";
import Navbar from "../NavbarAuth/Navbar";


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

    const [cards, setCards] = useState([
        {id: 1, name: "Card"}
    ]);

    function addNewCard() {
        let newCard = {
            id: Date.now(),
            name: "newName"
        };
        setCards(cards.concat(newCard))
    }

    return (
        <>
            <Navbar/>
            <div className="overflow-auto" style={style.bg}>
                <BoardHeader/>
                <div className="container-fluid flex-nowrap">
                    <div id="cardContainer" className="row flex-nowrap ml-2" style={style.card}>
                        {cards.map((card) =>
                            <Card card={card} key={card.id}/>)}

                        <button className="btn btn-outline-primary w-25 h-25 mt-1" onClick={addNewCard}>Добавить колонку
                            +
                        </button>
                    </div>
                </div>
            </div>
        </>
    )
}