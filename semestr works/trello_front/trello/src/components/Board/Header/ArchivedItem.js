import React, {useContext} from 'react';
import Context from "../../../context";

export default function ArchivedItem({item}) {
    const {unarchiveItem} = useContext(Context);

    function deleteButtonHandler(id) {
        unarchiveItem(id);
    }

    return (
        <tr>
            <td className="text-info">Карточка:</td>
            <td>{item.title}</td>
            <td>
                <button className="btn btn-outline-primary btn-sm" type="submit"
                        onClick={() => deleteButtonHandler(item.id)}>
                    Разархивировать
                </button>
            </td>
        </tr>
    )
}