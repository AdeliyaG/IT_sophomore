import React from 'react';
import ItemHeader from "../CardItem/ItemHeader";
import ItemBody from "../CardItem/ItemBody";

const styles = {
    button: {
        radius: "30px"
    },

};

export default function CardItem(props) {
    return (
        <div>
            <a type="button" className="list-group-item list-group-item-action " data-toggle="modal"
               data-target="#cardItemBody" style={styles.button}>
                {props.item.name}
            </a>
            <div className="modal fade" id="cardItemBody" tabIndex="-1" role="dialog"
                 aria-labelledby="itemLabel" aria-hidden="true">
                <div className="modal-dialog modal-lg" role="document">
                    <div className="modal-content">

                        <ItemHeader/>

                        <ItemBody/>

                        <div className="modal-footer">
                            <button type="button" className="btn btn-primary">Сохранить</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    )
};