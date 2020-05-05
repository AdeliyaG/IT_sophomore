import React, {useState} from 'react';
import CardList from "./CardList"
import CardHeader from "./CardHeader"
import CardItem from "./CardItem";
import CardFooter from "./CardFooter";

import Context from "../../context";

const style = {
    card: {
        minWidth: 300 + "px"
    }
};

export default function Card({card}) {

    const [cardItems, setCardItems] = useState([
        {id: 1, name: "Item"},
        {id: 2, name: "Item2"},
        {id: 3, name: "Item3"}
    ]);

    function saveItem(name) {
        if (name.trim()) {
            let elem = {
                id: Date.now(),
                name: name
            };
            setCardItems(cardItems.concat([elem]));
        }
    }


    return (
        <Context.Provider value={{ saveItem }}>
            <div id="draggable-revert" className="card border-light mt-1 mw-25 mr-3 shadow" style={style.card}>
                <CardHeader name={card.name}/>
                <CardList cardItems={cardItems}>
                    <div className="card-body " style={style.scroll}>
                        {cardItems.map((item) =>
                            <CardItem item={item} key={item.id}/>)}
                    </div>
                </CardList>
                <CardFooter/>
            </div>
        </Context.Provider>
    )
}