import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import './index.css';
import Login from './pages/Login/Login.jsx';
import RutaProtegida from './components/RutaProtegida/RutaProtegida.jsx';
import { AuthProvider } from './components/Auth/AuthProvider.jsx';
import LayoutPrincipal from './layouts/LayoutPrincipal.jsx';
import DatosPersonales from './pages/Alumno/DatosPersonales.jsx'
import ConsultaHorario from './pages/Alumno/ConsultaHorarios.jsx';
import Inscripcion from './pages/Alumno/Inscripcion.jsx';
import ConsultaInscripcion from './pages/Alumno/ConsultaInscripcion.jsx';
import ConsultaCalificaciones from './pages/Alumno/ConsultaCalificaciones.jsx';
import ConsultaHistorial from './pages/Alumno/ConsultaHistorial.jsx';


const router = createBrowserRouter([
  {
    path: "/",
    element: <Login />,
  },
  {
    path: "/Alumno",
    element: <RutaProtegida idcategoria={1} />,
    children:[
      {
        /* index: true, */
        path: "",
        element: <LayoutPrincipal />,
        children: [
          {path: "datos", element: <DatosPersonales />},
          {path: "horarios", element: <ConsultaHorario />},
          {path: "inscripcion", element: <Inscripcion />},
          {path: "consulta-inscripcion", element: <ConsultaInscripcion />},
          {path: "consulta-calificaciones", element: <ConsultaCalificaciones />},
          {path: "consulta-historial", element: <ConsultaHistorial />},
        ]
      },
    ]
  },
  {
    path: "/Profesor",
    element: <RutaProtegida idcategoria={2} />,
    children:[
      {
        index: true,
        element: <LayoutPrincipal />
      },
    ]
  }, 
  {
    path: "/Administrador",
    element: <RutaProtegida idcategoria={3} />,
    children:[
      {
        index: true,
        element: <LayoutPrincipal/>
      }
    ]
  }
]);

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <AuthProvider>
      <RouterProvider router={router}/>
    </AuthProvider>
  </StrictMode>,
);
