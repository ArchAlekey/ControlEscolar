import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import './index.css';
import Login from './pages/Login/Login.jsx';
import LayoutAlumno from './layouts/LayoutAlumno/LayoutAlumno.jsx';
import LayoutProfesor from './layouts/LayoutProfesor/LayoutProfesor.jsx';
import RutaProtegida from './components/RutaProtegida/RutaProtegida.jsx';
import { AuthProvider } from './components/Auth/AuthProvider.jsx';


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
        index: true,
        element: <LayoutAlumno />
      }
    ]
  },
  {
    path: "/Profesor",
    element: <RutaProtegida idcategoria={2} />,
    children:[
      {
        index: true,
        element: <LayoutProfesor />
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
)
