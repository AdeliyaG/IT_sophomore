import React, {useState} from 'react';

const style = {
    img: {
        maxHeight: 200 + "px",
        minHeight: 200 + "px",
    }
};

export default function ItemFileAdd() {

    const [files, setFiles] = useState([
        {id: 1, src: "https://bipbap.ru/wp-content/uploads/2017/10/0_8eb56_842bba74_XL.jpg"},
        {id: 5, src: "https://www.ecopetit.cat/wpic/mpic/28-280294_-.png"},
    ]);


    return (
        <div>
            <div className="form-inline mb-2 mt-3">
                <label htmlFor="boardName" className="col-form-label mr-2">Вложения: </label>
            </div>
            <div className="input-group">
                <div className="input-group-prepend">
                    <button className="btn btn-outline-primary input-group-text" id="inputGroupFile">Добавить</button>
                </div>
                <div className="custom-file">
                    <input type="file" className="custom-file-input" id="inputGroupFile"  aria-describedby="inputGroupFile"/>
                    <label className="custom-file-label" htmlFor="inputGroupFile">Выбрать файл</label>
                </div>
            </div>
            <div className="mt-3 text-center">
                {files.map((item) =>
                    <img key={item.id} src={item.src} className="img-thumbnail m-1" style={style.img}/>)}
            </div>
        </div>
    )
}