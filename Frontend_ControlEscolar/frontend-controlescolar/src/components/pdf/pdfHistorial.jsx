// components/pdf/PDFHistorial.jsx
import {
  Document,
  Page,
  Text,
  View,
  StyleSheet
} from "@react-pdf/renderer";

// Estilos
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
    marginBottom: 5,
    textAlign: "right",
    fontSize: 12,
    fontStyle: "italic"
  },
  promedio: {
    marginBottom: 10,
    textAlign: "right",
    fontSize: 12,
    fontWeight: "bold"
  },
  table: {
    display: "table",
    width: "100%",
    borderWidth: 1,
    borderColor: "#000",
    borderStyle: "solid"
  },
  row: {
    flexDirection: "row"
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
    width: "14.28%" // 100% / 7 columnas
  }
});

const PDFHistorial = ({ historial, usuario, promedio }) => (
  <Document>
    <Page size="A4" style={styles.page}>
      <Text style={styles.title}>Historial Académico</Text>
      <Text style={styles.usuario}>Usuario: {usuario}</Text>
      <Text style={styles.promedio}>Promedio: {promedio ?? "N/A"}</Text>

      <View style={styles.table}>
        <View style={[styles.row, styles.header]}>
          <Text style={styles.cell}>ID</Text>
          <Text style={styles.cell}>Materia</Text>
          <Text style={styles.cell}>Clave</Text>
          <Text style={styles.cell}>Calificación</Text>
          <Text style={styles.cell}>Semestre</Text>
          <Text style={styles.cell}>Periodo</Text>
          <Text style={styles.cell}>Año</Text>
        </View>
        {historial.map((item, idx) => (
          <View key={idx} style={styles.row}>
            <Text style={styles.cell}>{item.nid_insc_alumno}</Text>
            <Text style={styles.cell}>{item.cnombre_materia}</Text>
            <Text style={styles.cell}>{item.cclave_materia}</Text>
            <Text style={styles.cell}>{item.ncalificación}</Text>
            <Text style={styles.cell}>{item.nsemestre}</Text>
            <Text style={styles.cell}>{item.cperiodo}</Text>
            <Text style={styles.cell}>{item.canio}</Text>
          </View>
        ))}
      </View>
    </Page>
  </Document>
);

export default PDFHistorial;
