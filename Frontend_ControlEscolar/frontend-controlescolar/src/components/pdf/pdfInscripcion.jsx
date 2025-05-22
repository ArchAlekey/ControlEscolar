// components/pdf/PDFInscripcion.jsx
import {
  Document,
  Page,
  Text,
  View,
  StyleSheet
} from "@react-pdf/renderer";

// 🎨 Estilos personalizados
const styles = StyleSheet.create({
  page: {
    padding: 30,
    fontSize: 10,
    fontFamily: 'Helvetica'
  },
  title: {
    fontSize: 16,
    marginBottom: 10,
    textAlign: "center",
    fontWeight: "bold"
  },
  usuario: {
    marginBottom: 10,
    textAlign: "right",
    fontSize: 12,
    fontStyle: "italic"
  },
  table: {
    display: "table",
    width: "100%",
    borderWidth: 1,
    borderColor: "#000",
    borderStyle: "solid"
  },
  row: {
    flexDirection: "row",
  },
  header: {
    backgroundColor: "#eee",
    fontWeight: "bold"
  },
  cell: {
    padding: 5,
    borderRightWidth: 1,
    borderBottomWidth: 1,
    borderColor: "#000",
    width: "14.28%" // 100 / 7 columnas
  }
});

const PDFInscripcion = ({ inscripciones, usuario }) => (
  <Document>
    <Page size="A4" style={styles.page}>
      <Text style={styles.title}>Reporte de Inscripción</Text>
      <Text style={styles.usuario}>Usuario: {usuario}</Text>

      <View style={styles.table}>
        {/* Encabezado */}
        <View style={[styles.row, styles.header]}>
          <Text style={styles.cell}>Materia</Text>
          <Text style={styles.cell}>Clave</Text>
          <Text style={styles.cell}>Carrera</Text>
          <Text style={styles.cell}>Grupo</Text>
          <Text style={styles.cell}>Profesor</Text>
          <Text style={styles.cell}>Correo</Text>
          <Text style={styles.cell}>Horario</Text>
        </View>

        {/* Datos */}
        {inscripciones.map((i, idx) => (
          <View key={idx} style={styles.row}>
            <Text style={styles.cell}>{i.cnombre_materia}</Text>
            <Text style={styles.cell}>{i.cclave_materia}</Text>
            <Text style={styles.cell}>{i.ccarrera}</Text>
            <Text style={styles.cell}>{i.cgrupo}</Text>
            <Text style={styles.cell}>{i.profesor}</Text>
            <Text style={styles.cell}>{i.ccorreo_institucional}</Text>
            <Text style={styles.cell}>{i.chorario}</Text>
          </View>
        ))}
      </View>
    </Page>
  </Document>
);

export default PDFInscripcion;
