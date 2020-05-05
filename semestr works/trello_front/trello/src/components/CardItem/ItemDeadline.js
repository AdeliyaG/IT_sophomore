import React, {useState} from 'react';

export default function ItemDeadline() {

    // const [startDate, setStartDate] = useState(new Date());
    //
    // function handleChange(date) {
    //     setStartDate(date)
    // };

    return (
        <div>
            <div className="form-inline mb-2 mt-3">
                <label htmlFor="boardName" className="col-form-label mr-2">Срок: </label>
            </div>

            {/*<div className="custom-control custom-checkbox">*/}
            {/*    <input type="checkbox" className="custom-control-input" id="customCheck1"/>*/}
            {/*    <label className="custom-control-label" htmlFor="customCheck1">*/}
            {/*        <DatePicker selected={startDate}  onChange={handleChange}/>*/}
            {/*    </label>*/}
            {/*</div>*/}
        </div>
    )
}