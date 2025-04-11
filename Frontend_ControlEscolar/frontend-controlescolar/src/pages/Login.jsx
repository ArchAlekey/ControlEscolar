import { use, useState } from "react";
import BotonLogin from '../components/IniciarSesion.jsx';
import './Login.css'

function Login(){
    const [usuario, setUsuario] = useState('');
    const [contrasenia, setContrasenia] = useState('');
    const [mensaje, setMensaje] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();
        setMensaje("");

        try{
            const respone = await fetch("http://localhost:8082/usuario/valida",{
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify({usuario, contrasenia}),
            });

            const data = await respone.json();
            console.log("Respuesta del servidor:", data);

            if (data.error){
                setMensaje(`Error: ${data.error}`);
            } else {
                setMensaje("Login exitoso");
                console.log(setMensaje);
            }
        } catch(error){
            setMensaje("Error al conectar con el servidor");
        }
    };

    return (
        <div className="login-container">
            <h2 className="title-login">Iniciar Sesión</h2>
            <form onSubmit={handleLogin}>
                <div className="input-login">
                    <input 
                        type="text"
                        value={usuario}
                        onChange={(e)=> setUsuario(e.target.value)}
                        required
                        placeholder="Usuario"
                    />
                </div>
                <div className="input-login">
                    <input 
                        type="password"
                        value={contrasenia}
                        onChange={(e)=> setContrasenia(e.target.value)}
                        required
                        placeholder="Contraseña"
                    />
                </div>
                <div className="input-login">
                    <>
                    <BotonLogin />
                    </>
                </div>
            </form>
        </div>
    );
}

export default Login;