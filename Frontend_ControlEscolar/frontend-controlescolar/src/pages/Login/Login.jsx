import { useState } from "react";
import { useNavigate } from "react-router-dom";
import BotonLogin from '../../components/boton/boton';
import './Login.css';
import Swal from 'sweetalert2';
import { useAuth } from "../../components/Auth/AuthProvider";

function Login({ setLogeado }){
    const [usuario, setUsuario] = useState('');
    const [contrasenia, setContrasenia] = useState('');
    const [mensaje, setMensaje] = useState('');
    const navigate = useNavigate();
    const {setAuth} = useAuth();

    const handleLogin = async (e) => {
        e.preventDefault();
        setMensaje("");

        Swal.fire({
            title: 'Validando...',
            text: 'Porfavor, espere',
            allowOutsideClick: false,
            allowEscapeKey: false,
            didOpen: ()=>{
                Swal.showLoading();
            }
        })

        try{
            const respone = await fetch("http://localhost:8082/usuario/valida",{
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify({usuario, contrasenia}),
            });

            const data = await respone.json();

            if (data.success){
                /* setMensaje('Login exitoso'); */
                setTimeout(()=>{
                    Swal.close();

                    Swal.fire({
                        icon: 'success',
                        title: 'Bienvenido',
                        text: `${data.usuario}`,
                        timer: 2000,
                        showConfirmButton: false,
                    });

                    localStorage.setItem("token", data.token);
                    localStorage.setItem("usuario", data.usuario);
                    localStorage.setItem("id", data.id);
                    localStorage.setItem("idcategoria", data.idcategoria);

                    setAuth({
                        token: data.token,
                        idcategoria: data.idcategoria,
                        usuario: data.usuario,
                        id: data.id
                    })
    
                    if (data.idcategoria === 1){
                        navigate("/Alumno");
                    } else if (data.idcategoria === 2){
                        navigate("/Profesor");
                    } else if( data.idcategoria === 3){
                        navigate("/Administrador");
                    } else {
                        setMensaje("No encontrado");
                    }
                }, 2500);

            } else {
                /* setMensaje(data.mensaje || "Usuario o Contraseña incorrectos"); */
                setTimeout(()=>{
                    Swal.fire({
                        icon: 'warning',
                        title: 'Credenciales incorrectas.',
                        text: data.mensaje || 'Usuario o contraseña invalido',
                        timer: 2000,
                    },3500);
                });
            }

        } catch(error){
            /* setMensaje("Error al conectar con el servidor"); */
            Swal.fire({
                icon: 'error',
                title: 'Error de conexión.',
                text: 'Contacte a su administrador.',
                timer: 5000
            })
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
                    <BotonLogin titulo="Iniciar Sesión" />
                    </>
                </div>
            </form>
        </div>
    );
}

export default Login;