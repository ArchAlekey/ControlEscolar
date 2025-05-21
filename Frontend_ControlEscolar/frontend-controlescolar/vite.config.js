import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {    
    allowedHosts: [
      'localhost',
      '127.0.0.1',
      '8b81-132-248-180-174.ngrok-free.app' // <-- agrega tu URL de ngrok aquí
  ],
    proxy: {
      '/api': {
        target: 'http://localhost:8082', // tu backend corre en 8082
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, '') // elimina "/api" al mandar la petición real
      }
    }
  }
})
