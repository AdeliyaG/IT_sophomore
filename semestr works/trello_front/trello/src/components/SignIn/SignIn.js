import React, {useState} from 'react';
import NavbarAnon from "../NavbarAnon/NavbarAnon";

const style = {
    bg: {
        backgroundImage: "url(" + "https://images.pexels.com/photos/1679768/pexels-photo-1679768.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" + ")",
        // backgroundImage: "url(" + "https://images.pexels.com/photos/1054201/pexels-photo-1054201.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" + ")",
        backgroundPosition: 'center',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        height: 509,
        opacity: 0.85,
        // height: 100+"%"
    },

    input: {
        width: 250 + "px"
    }
}

export default function SignIn() {
    return (
        <>
            <NavbarAnon/>
            <div style={style.bg}>
                <div className="d-flex justify-content-center pt-5 pl-3">
                    <form action="/signIn" method="POST">
                        <div className="form-group" style={style.input}>
                            <label htmlFor="loginInput" className="col-form-label text-white font-weight-bold">Имя
                                пользователя</label>
                            <input type="text" className="form-control shadow-lg" id="loginInput"
                                   placeholder="Username"/>
                        </div>

                        <div className="form-group" style={style.input}>
                            <label htmlFor="passwordInput"
                                   className="col-form-label text-white font-weight-bold">Пароль</label>
                            <input type="password" className="form-control shadow-lg" id="passwordInput"
                                   placeholder="Password"/>
                        </div>
                        <div className="form-group row text-center" style={style.input}>
                            <div className="col-9">
                                <button type="submit" className="btn btn-primary shadow-lg">Войти через facebook
                                </button>
                            </div>
                            <div className="col-3 p-0">
                                <button type="submit"
                                        className="btn btn-outline-light font-weight-bold shadow-lg">Войти
                                </button>
                            </div>

                        </div>
                    </form>

                </div>
            </div>
        </>
)
}