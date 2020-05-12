import React, {useState} from 'react';
import CardHeader from "./CardHeader"
import CardItem from "./CardItem";
import CardFooter from "./CardFooter";

import Context from "../../context";
import api from "../../axios/api-auth";
import CardList from "./CardList";

const style = {
    card: {
        minWidth: 300 + "px",
        height: "auto",
        alignSelf: "start"
    }
};

export default function Card({card}) {

    const [cardItems, setCardItems] = useState(card.items.filter(item => item.itemStatus === "OPENED"));

    function saveItem(name) {
        api.post("/card="+card.id, {
            title: name
        }).then((response) => {
            if (response.status === 200) {
                setCardItems(cardItems.concat(response.data));
            } else {
                alert("Bad response")
            }
        });
    }


    return (
        <Context.Provider value={{ saveItem }}>
            <div id="draggable-revert" className="card border-light mt-1 mw-25 mr-3 shadow" style={style.card}>
                <CardHeader name={card.title}/>
                <CardList cardItems={cardItems}/>
                <CardFooter/>
            </div>
        </Context.Provider>
    )
}