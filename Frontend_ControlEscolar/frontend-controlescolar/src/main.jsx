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
import ConsultarHistorial from './pages/Alumno/ConsultarHistorial.jsx';
import GruposAsignados from './pages/Profesor/GruposAsignados.jsx';
import CalificarAlumnos from './pages/Profesor/CalificarAlumnos.jsx';
import AdministraUsuarios from './pages/Administrador/Usuarios/AdministraUsuarios.js';
import AdministraAlumno from './pages/Administrador/Usuarios/Alumnos/AdministraAlumno.js';
import AdministrarProfesor from './pages/Administrador/Usuarios/Profesores/AdministrarProfesor.jsx';
import Carreras from './pages/Administrador/Carreras/Carreras.jsx'
import Periodos from './pages/Administrador/Periodos/Periodos.jsx'
import AdministraCarrera from './pages/Administrador/Carreras/AdministraCarrera.js'
import AdministraMaterias from './pages/Administrador/Carreras/AdministraMaterias.js';
import AdministraGrupos from './pages/Administrador/Carreras/AdministraGrupos.js';
import Horarios from './pages/Administrador/Horarios/Horarios.js';
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
          /* {path: "consulta-calificaciones", element: <ConsultaRCalificaciones />}, */
          {path: "consulta-historial", element: <ConsultarHistorial /> },
        ]
      },
    ]
  },
  {
    path: "/Profesor",
    element: <RutaProtegida idcategoria={2} />,
    children:[
      {
        path: "",
        element: <LayoutPrincipal />,
        children: [
          {path: "datos", element: <DatosPersonales />},
          {path: "gruposAsignados", element: <GruposAsignados />},
          {path: "calificarAlumnos", element: <CalificarAlumnos />},
        ]
      },
    ]
  }, 
  {
    path: "/Administrador",
    element: <RutaProtegida idcategoria={3} />,
    children:[
      {
        path: "", 
        element: <LayoutPrincipal/>,
        children: [
          {
            path: "datos",
            element: <DatosPersonales />,
          },
          { 
            path: "usuario", 
            element: <AdministraUsuarios />,
              children: [
                {
                  path: "alumno",
                  element: <AdministraAlumno/> 
                },
                { 
                  path: "profesor", 
                  element: <AdministrarProfesor/>
                }
              ]
          },
          {
            path: "carrera",
            element: <Carreras />,
            children: [
              {
                path: "carreras",
                element: <AdministraCarrera/>
              },
              {
                path: "grupos",
                element: <AdministraGrupos/>
              },
              {
                path: "materias",
                element: <AdministraMaterias/>
              },
              {
              path: "horarios",
              element: < Horarios/>,
              }
            ]
          },
          {
            path: "periodos",
            element: < Periodos/>,
          }
        ]
        
      }
    ]
  },
  {
    path: "/SuperUs",
    element: <RutaProtegida idcategoria={4} />,
    children:[
      {
        path: "/SuperUs",
        element: <LayoutPrincipal/>,
        children:[
          {path: "horarios", element: <ConsultaHorario />},
          {path: "inscripcion", element: <Inscripcion />},
          {path: "consulta-inscripcion", element: <ConsultaInscripcion />},
         /*  {path: "consulta-calificaciones", element: <ConsultaCalificaciones />}, */
          {path: "consulta-historial", element: <ConsultarHistorial />},
          {path: "datos", element: <DatosPersonales />},
        ]
      }
    ]
  }
]);

createRoot(document.getElementById('root')).render(
/*   <StrictMode>
    <AuthProvider>
      <RouterProvider router={router}/>
    </AuthProvider>
  </StrictMode>, */
  <AuthProvider>
    <RouterProvider router={router}/>
  </AuthProvider>
);

