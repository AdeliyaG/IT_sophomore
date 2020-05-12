import React, {useState} from 'react';
import CardItem from "./CardItem"

const style = {
    scroll: {
        maxHeight: 310 + "px",
        overflowY: "auto"
    }
};

export default function CardList({cardItems}) {
    return (
        <div className="card-body " style={style.scroll}>
            {cardItems.map(item => {
                return <CardItem item={item} key={item.id}/>
            })}
        </div>
    )

}