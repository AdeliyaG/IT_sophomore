import React, {useState} from 'react';
import NavbarAnon from "../NavbarAnon/NavbarAnon";

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
}

export default function SignUp() {
    return (
        <>
            <NavbarAnon/>
            <div style={style.bg}>
                <div className="d-flex justify-content-center pt-5 pl-2">
                    <form action="/signUp" method="POST">
                        <div className="form-group" style={style.input}>
                            <label htmlFor="loginInput" className="col-form-label font-weight-bold">Имя
                                пользователя</label>
                            <input type="text" className="form-control shadow-lg" id="loginInput"
                                   placeholder="Login" required/>

                            <label htmlFor="loginInput" className="col-form-label font-weight-bold">Email</label>
                            <input type="email" className="form-control shadow-lg" id="loginInput"
                                   placeholder="Email" required/>

                            <label htmlFor="passwordInput"
                                   className="col-form-label font-weight-bold">Пароль</label>
                            <input type="password" className="form-control shadow-lg" id="passwordInput"
                                   placeholder="Password" required/>
                            <small id="passwordHelpBlock" className="form-text text-center">
                                Пароль должен содержать не менее 8 символов, цифры и заглавные буквы.
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