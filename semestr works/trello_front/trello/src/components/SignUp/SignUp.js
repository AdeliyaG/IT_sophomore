import React, {useState} from 'react';
import NavbarAnon from "../NavbarAnon/NavbarAnon";
import api from "../../axios/api-anon";

const style = {
    bg: {
        backgroundImage: "url(" + "https://images.pexels.com/photos/3759098/pexels-photo-3759098.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" + ")",
        backgroundPosition: 'center',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        height: 509
        // height: 100+"%"
    },

    input: {
        width: 250 + "px"
    }
};

export default function SignUp(props) {

    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const [validation, setValidation] = useState([]);

    function submitHandler(event) {
        event.preventDefault();

        api.post("/signUp", {
            username: username,
            email: email,
            password: password
        }).then((response) => {
            window.location = "/signIn"
        }).catch(error => setValidation(error.response.data));
    }

    return (
        <>
            <NavbarAnon/>
            <div style={style.bg}>
                <div className="d-flex justify-content-center pt-5 pl-2">
                    <form onSubmit={submitHandler}>
                        <div className="form-group" style={style.input}>
                            <label htmlFor="loginInput" className="col-form-label font-weight-bold">Имя
                                пользователя</label>
                            <input type="text" className="form-control shadow-lg" id="loginInput"
                                   placeholder="Login"
                                   value={username}
                                   onChange={event => setUsername(event.target.value)}
                            />
                            <small id="passwordHelpBlock" className="form-text text-center text-danger">
                                {validation.username}
                            </small>

                            <label htmlFor="loginInput" className="col-form-label font-weight-bold">Email</label>
                            <input type="email" className="form-control shadow-lg" id="loginInput"
                                   placeholder="Email"
                                   value={email}
                                   onChange={event => setEmail(event.target.value)}
                            />
                            <small id="passwordHelpBlock" className="form-text text-center text-danger">
                                {validation.email}
                            </small>

                            <label htmlFor="passwordInput"
                                   className="col-form-label font-weight-bold">Пароль</label>
                            <input type="password" className="form-control shadow-lg" id="passwordInput"
                                   placeholder="Password"
                                   value={password}
                                   onChange={event => setPassword(event.target.value)}
                            />

                            <small id="passwordHelpBlock" className="form-text text-center text-danger">
                                {validation.password}
                            </small>
                        </div>

                        <div className="form-group text-center" style={style.input}>
                            <button type="submit"
                                    className="btn btn-outline-primary font-weight-bold shadow-lg">Зарегистрироваться
                            </button>
                        </div>
                    </form>

                </div>
            </div>
        </>
    )
}