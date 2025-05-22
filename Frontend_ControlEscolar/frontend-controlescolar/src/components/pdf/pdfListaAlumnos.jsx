// components/pdf/PDFListaAlumnos.jsx
import {
  Document,
  Page,
  Text,
  View,
  StyleSheet
} from "@react-pdf/renderer";

const styles = StyleSheet.create({
  page: {
    padding: 30,
    fontSize: 10,
    fontFamily: "Helvetica"
  },
  title: {
    fontSize: 16,
    marginBottom: 10,
    textAlign: "center",
    fontWeight: "bold"
  },
  subtitle: {
    fontSize: 12,
    marginBottom: 5,
    textAlign: "center"
  },
  table: {
    display: "table",
    width: "100%",
    borderStyle: "solid",
    borderWidth: 1,
    borderColor: "#000"
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
    width: "25%"
  }
});

const PDFListaAlumnos = ({ alumnos, grupoInfo }) => (
  <Document>
    <Page size="A4" style={styles.page}>
      <Text style={styles.title}>Lista de Alumnos</Text>
      <Text style={styles.subtitle}>
        {grupoInfo.cnombre_materia} | {grupoInfo.cgrupo} | {grupoInfo.cperiodo}
      </Text>

      <View style={styles.table}>
        <View style={[styles.row, styles.header]}>
          <Text style={styles.cell}>Nombre</Text>
          <Text style={styles.cell}>Núm. de Cuenta</Text>
          <Text style={styles.cell}>Correo Institucional</Text>
          <Text style={styles.cell}>Correo Personal</Text>
        </View>

        {alumnos.map((a, i) => (
          <View key={i} style={styles.row}>
            <Text style={styles.cell}>{a.Nombre}</Text>
            <Text style={styles.cell}>{a.cnumero_cuenta}</Text>
            <Text style={styles.cell}>{a.ccorreo_institucional}</Text>
            <Text style={styles.cell}>{a.ccorreo_personal}</Text>
          </View>
        ))}
      </View>
    </Page>
  </Document>
);

export default PDFListaAlumnos;
