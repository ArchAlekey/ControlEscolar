-- Active: 1739329630699@@127.0.0.1@3306@db_onepiece

INSERT INTO cat_carreras(ccarrera, bhabilitado, dfecha_alta)
VALUES  ('Matemáticas Aplicadas y Computación', 1, NOW()),
        ('Filosofía', 1, NOw()),
        ('Arquitectura', 1, NOW()),
        ('Física Aplciada', 1, NOW()),
        ('Actuación', 1, NOW()),
        ('Químico Farmacéutico Biólogo', 1, now()),
        ('Historia y Antropología', 1, Now()),
        ('Medicina', 1, NOW());

INSERT INTO cat_semestres(nsemestre, bpar_impar, bhabilitado, dfecha_alta)
VALUES  (1, 0, 1, NOW()),
        (2, 1, 1, NOW()),
        (3, 0, 1, NOW()),
        (4, 1, 1, NOW()),
        (5, 0, 1, NOW()),
        (6, 1, 1, NOW()),
        (7, 0, 1, NOW()),
        (8, 1, 1, NOW()),
        (9, 0, 1, NOW()),
        (10, 1, 1, NOW()),
        (11, 0, 1, NOW()),
        (12, 1, 1, NOW());

INSERT INTO cat_materias(nid_carrera, nid_semestre, cnombre_materia, cclave_materia, bhabilitado, dfecha_alta) -- Inserta para carrera de MAC
VALUES  (1, 1, 'Programación 1', '01PRO1', 1, NOW()),
        (1, 1, 'Cálculo 1', '01CAL1', 1, NOW()),
        (1, 1, 'Lógica', '01LOG0', 1, NOW()),
        (1, 1, 'Organización de computadoras', '01ORG0', 1, NOW()),
        (1, 2, 'Calculo 2', '02CAL2', 1, NOW()),
        (1, 2, 'Programacíon 2', '02PRO2', 1, NOW()),
        (1, 2, 'Redes de computo', '02RED0', 1, now()),
        (1, 2, 'Ingles 1', '02ING1', 1, now()),
        (1, 3, 'Programación orientada a objetos', '03POO0', 1, NOW()),
        (1, 3, 'Matemáticas discretas', '03MAT', 1, NOW()),
        (1, 3, 'Ingles 2', '03ING2', 1, NOW()),
        (1, 3, 'Cálculo 3', '03CAL3', 1, NOW()),
        (1, 4, 'Base de datos', '04BAS0', 1, NOW()),
        (1, 4, 'Cálculo 4', '04CAL4', 1, NOW()),
        (1, 4, 'Ingles 3', '04ING3', 1, NOW()),
        (1, 4, 'Probabilidad', '04PROB0', 1, NOW()),
        (1, 5, 'Ingenieria de software', '05INGS0', 1, NOW()),
        (1, 5, 'Ecuaciones difereciales 1', '05ECU1', 1, NOW()),
        (1, 5, 'Optimización 1', '05OPT1', 1, now()),
        (1, 5, 'Ingles 4', '05ING4', 1, NOW()),
        (1, 6, 'Desarrollo web', '06DES0', 1, now()),
        (1, 6, 'Ecuaciones difereciales 2', '06ECU2', 1, NOW()),
        (1, 6, 'Optimización 2', '06OPT2', 1, now()),
        (1, 6, 'Seminario de ética', '06SEM0', 1, NOW()),
        (1, 7, 'Administración de base de datos', '07ADM0', 1, now()),
        (1, 7, 'Desarrollo de aplicaciones moviles', '07DESA0', 1, NOW()),
        (1, 7, 'IMAC', '07IMAC0', 1, NOW()),
        (1, 7, 'Sistemas Operativos', '07SIS0', 1, now()),
        (1, 8, 'Seguridad Computacional', '08SEG0', 1, NOW()),
        (1, 8, 'Desarrollo de APIS', '08DESA0', 1, now()),
        (1, 8, 'Administración de redes', '08ADMR0', 1, now()),
        (1, 8, 'Ciencia de datos', '08CIE0', 1, now());

INSERT INTO cat_materias(nid_carrera, nid_semestre, cnombre_materia, cclave_materia, bhabilitado, dfecha_alta) -- Inserta para la carrera de filosofía
VALUES  
    (2, 1, 'Introducción a la Filosofía', '01INF0', 1, NOW()),
    (2, 1, 'Lógica', '01LOG0', 1, NOW()),
    (2, 1, 'Historia de la Filosofía Antigua', '01HFA0', 1, NOW()),
    (2, 1, 'Ética General', '01ETG0', 1, NOW()),

    (2, 2, 'Historia de la Filosofía Medieval', '02HFM0', 1, NOW()),
    (2, 2, 'Metafísica', '02MET0', 1, NOW()),
    (2, 2, 'Antropología Filosófica', '02ANT0', 1, NOW()),
    (2, 2, 'Filosofía Política', '02FIP0', 1, NOW()),

    (2, 3, 'Historia de la Filosofía Moderna', '03HFM0', 1, NOW()),
    (2, 3, 'Gnoseología', '03GNO0', 1, NOW()),
    (2, 3, 'Ética Aplicada', '03ETA0', 1, NOW()),
    (2, 3, 'Filosofía de la Ciencia', '03FIC0', 1, NOW()),

    (2, 4, 'Historia de la Filosofía Contemporánea', '04HFC0', 1, NOW()),
    (2, 4, 'Epistemología', '04EPI0', 1, NOW()),
    (2, 4, 'Hermenéutica Filosófica', '04HER0', 1, NOW()),
    (2, 4, 'Filosofía del Lenguaje', '04FIL0', 1, NOW()),

    (2, 5, 'Filosofía de la Mente', '05FIM0', 1, NOW()),
    (2, 5, 'Estética', '05EST0', 1, NOW()),
    (2, 5, 'Filosofía de la Historia', '05FIH0', 1, NOW()),
    (2, 5, 'Seminario de Ética y Sociedad', '05SES0', 1, NOW()),

    (2, 6, 'Filosofía del Derecho', '06FID0', 1, NOW()),
    (2, 6, 'Filosofía de la Religión', '06FIR0', 1, NOW()),
    (2, 6, 'Filosofía y Globalización', '06FIG0', 1, NOW()),
    (2, 6, 'Filosofía Latinoamericana', '06FLL0', 1, NOW()),

    (2, 7, 'Seminario de Filosofía Social', '07SFS0', 1, NOW()),
    (2, 7, 'Corrientes Contemporáneas de Filosofía', '07CCF0', 1, NOW()),
    (2, 7, 'Filosofía Analítica', '07FIA0', 1, NOW()),
    (2, 7, 'Seminario de Investigación Filosófica', '07SIF0', 1, NOW()),

    (2, 8, 'Filosofía y Tecnología', '08FIT0', 1, NOW()),
    (2, 8, 'Ontología', '08ONT0', 1, NOW()),
    (2, 8, 'Teoría del Conocimiento', '08TDC0', 1, NOW()),
    (2, 8, 'Filosofía del Arte', '08FIA0', 1, NOW());

INSERT INTO cat_materias(nid_carrera, nid_semestre, cnombre_materia, cclave_materia, bhabilitado, dfecha_alta) -- Inserta para la carrera de arquitectura
VALUES  
    (3, 1, 'Introducción a la Arquitectura', '01INA0', 1, NOW()),
    (3, 1, 'Dibujo Arquitectónico', '01DIA0', 1, NOW()),
    (3, 1, 'Geometría Descriptiva', '01GED0', 1, NOW()),
    (3, 1, 'Historia de la Arquitectura I', '01HAI0', 1, NOW()),

    (3, 2, 'Teoría de la Arquitectura', '02TEA0', 1, NOW()),
    (3, 2, 'Materiales y Construcción I', '02MAC1', 1, NOW()),
    (3, 2, 'Historia de la Arquitectura II', '02HAII0', 1, NOW()),
    (3, 2, 'Topografía', '02TOP0', 1, NOW()),

    (3, 3, 'Diseño Arquitectónico I', '03DAI0', 1, NOW()),
    (3, 3, 'Estructuras I', '03EST1', 1, NOW()),
    (3, 3, 'Instalaciones en Edificaciones I', '03IEI0', 1, NOW()),
    (3, 3, 'Urbanismo I', '03URB1', 1, NOW()),

    (3, 4, 'Diseño Arquitectónico II', '04DAII0', 1, NOW()),
    (3, 4, 'Estructuras II', '04EST2', 1, NOW()),
    (3, 4, 'Materiales y Construcción II', '04MAC2', 1, NOW()),
    (3, 4, 'Historia de la Arquitectura III', '04HAIII0', 1, NOW()),

    (3, 5, 'Diseño Arquitectónico III', '05DAIII0', 1, NOW()),
    (3, 5, 'Estructuras III', '05EST3', 1, NOW()),
    (3, 5, 'Instalaciones en Edificaciones II', '05IEII0', 1, NOW()),
    (3, 5, 'Urbanismo II', '05URB2', 1, NOW()),

    (3, 6, 'Diseño Arquitectónico IV', '06DAIV0', 1, NOW()),
    (3, 6, 'Estructuras IV', '06EST4', 1, NOW()),
    (3, 6, 'Administración de Obras', '06ADM0', 1, NOW()),
    (3, 6, 'Sustentabilidad y Medio Ambiente', '06SMA0', 1, NOW()),

    (3, 7, 'Diseño Arquitectónico V', '07DAV0', 1, NOW()),
    (3, 7, 'Taller de Construcción', '07TAC0', 1, NOW()),
    (3, 7, 'Paisajismo', '07PAI0', 1, NOW()),
    (3, 7, 'Urbanismo III', '07URB3', 1, NOW()),

    (3, 8, 'Diseño Arquitectónico VI', '08DAVI0', 1, NOW()),
    (3, 8, 'Legislación Urbana', '08LEU0', 1, NOW()),
    (3, 8, 'Restauración Arquitectónica', '08REA0', 1, NOW()),
    (3, 8, 'Tesis de Arquitectura', '08TES0', 1, NOW());

INSERT INTO cat_materias(nid_carrera, nid_semestre, cnombre_materia, cclave_materia, bhabilitado, dfecha_alta) -- Inserta para la carrera de fisica aplicada
VALUES  
    (4, 1, 'Introducción a la Física', '01INF0', 1, NOW()),
    (4, 1, 'Matemáticas I', '01MAT1', 1, NOW()),
    (4, 1, 'Mecánica Clásica I', '01MEC1', 1, NOW()),
    (4, 1, 'Laboratorio de Física I', '01LAB1', 1, NOW()),

    (4, 2, 'Matemáticas II', '02MAT2', 1, NOW()),
    (4, 2, 'Mecánica Clásica II', '02MEC2', 1, NOW()),
    (4, 2, 'Electricidad y Magnetismo I', '02ELM1', 1, NOW()),
    (4, 2, 'Laboratorio de Física II', '02LAB2', 1, NOW()),

    (4, 3, 'Ecuaciones Diferenciales', '03ECU0', 1, NOW()),
    (4, 3, 'Electricidad y Magnetismo II', '03ELM2', 1, NOW()),
    (4, 3, 'Termodinámica', '03TER0', 1, NOW()),
    (4, 3, 'Laboratorio de Física III', '03LAB3', 1, NOW()),

    (4, 4, 'Mecánica Cuántica I', '04MCQ1', 1, NOW()),
    (4, 4, 'Métodos Matemáticos de la Física', '04MMF0', 1, NOW()),
    (4, 4, 'Óptica', '04OPT0', 1, NOW()),
    (4, 4, 'Laboratorio de Física IV', '04LAB4', 1, NOW()),

    (4, 5, 'Mecánica Cuántica II', '05MCQ2', 1, NOW()),
    (4, 5, 'Electrodinámica', '05ELD0', 1, NOW()),
    (4, 5, 'Física del Estado Sólido', '05FES0', 1, NOW()),
    (4, 5, 'Laboratorio de Física V', '05LAB5', 1, NOW()),

    (4, 6, 'Mecánica Estadística', '06MES0', 1, NOW()),
    (4, 6, 'Física Nuclear', '06FNU0', 1, NOW()),
    (4, 6, 'Nanotecnología', '06NAN0', 1, NOW()),
    (4, 6, 'Laboratorio de Física VI', '06LAB6', 1, NOW()),

    (4, 7, 'Física de Partículas', '07FPA0', 1, NOW()),
    (4, 7, 'Astrofísica', '07AST0', 1, NOW()),
    (4, 7, 'Computación Científica', '07COM0', 1, NOW()),
    (4, 7, 'Laboratorio de Física VII', '07LAB7', 1, NOW()),

    (4, 8, 'Electrónica Aplicada', '08ELA0', 1, NOW()),
    (4, 8, 'Física Médica', '08FME0', 1, NOW()),
    (4, 8, 'Métodos Numéricos en Física', '08MNF0', 1, NOW()),
    (4, 8, 'Tesis en Física Aplicada', '08TES0', 1, NOW());

INSERT INTO cat_materias(nid_carrera, nid_semestre, cnombre_materia, cclave_materia, bhabilitado, dfecha_alta) -- Inserta para la carrera de actuación
VALUES  
    (5, 1, 'Introducción a la Actuación', '01INA0', 1, NOW()),
    (5, 1, 'Expresión Corporal I', '01EXP1', 1, NOW()),
    (5, 1, 'Historia del Teatro', '01HIT0', 1, NOW()),
    (5, 1, 'Voz y Dicción I', '01VOZ1', 1, NOW()),

    (5, 2, 'Actuación I', '02ACT1', 1, NOW()),
    (5, 2, 'Expresión Corporal II', '02EXP2', 1, NOW()),
    (5, 2, 'Análisis de Textos Dramáticos', '02ATD0', 1, NOW()),
    (5, 2, 'Voz y Dicción II', '02VOZ2', 1, NOW()),

    (5, 3, 'Actuación II', '03ACT2', 1, NOW()),
    (5, 3, 'Teatro Clásico', '03TCL0', 1, NOW()),
    (5, 3, 'Improvisación I', '03IMP1', 1, NOW()),
    (5, 3, 'Montaje Teatral I', '03MT1', 1, NOW()),

    (5, 4, 'Actuación para Cine', '04APC0', 1, NOW()),
    (5, 4, 'Teatro Contemporáneo', '04TCO0', 1, NOW()),
    (5, 4, 'Improvisación II', '04IMP2', 1, NOW()),
    (5, 4, 'Montaje Teatral II', '04MT2', 1, NOW()),

    (5, 5, 'Actuación III', '05ACT3', 1, NOW()),
    (5, 5, 'Guion y Dramaturgia', '05GDR0', 1, NOW()),
    (5, 5, 'Expresión Vocal', '05EXV0', 1, NOW()),
    (5, 5, 'Lenguaje Cinematográfico', '05LCI0', 1, NOW()),

    (5, 6, 'Actuación frente a Cámara', '06AFC0', 1, NOW()),
    (5, 6, 'Dirección Escénica', '06DES0', 1, NOW()),
    (5, 6, 'Técnicas de Casting', '06TCA0', 1, NOW()),
    (5, 6, 'Montaje de Cortometraje', '06MCT0', 1, NOW()),

    (5, 7, 'Creación de Personajes', '07CPR0', 1, NOW()),
    (5, 7, 'Actuación en TV', '07ATV0', 1, NOW()),
    (5, 7, 'Producción Teatral', '07PT0', 1, NOW()),
    (5, 7, 'Gestión Cultural', '07GCU0', 1, NOW()),

    (5, 8, 'Taller de Montaje Final', '08TMF0', 1, NOW()),
    (5, 8, 'Actuación para Doblaje', '08ADO0', 1, NOW()),
    (5, 8, 'Metodologías Actorales', '08MET0', 1, NOW()),
    (5, 8, 'Tesis en Actuación', '08TES0', 1, NOW());


INSERT INTO cat_materias(nid_carrera, nid_semestre, cnombre_materia, cclave_materia, bhabilitado, dfecha_alta) -- Inserta para QFB
VALUES  
    (6, 1, 'Química General', '01QG0', 1, NOW()),
    (6, 1, 'Biología Celular', '01BC0', 1, NOW()),
    (6, 1, 'Matemáticas para QFB', '01MAT0', 1, NOW()),
    (6, 1, 'Introducción a la Farmacia', '01IF0', 1, NOW()),
    (6, 2, 'Química Orgánica I', '02QO1', 1, NOW()),
    (6, 2, 'Bioquímica I', '02BQI', 1, NOW()),
    (6, 2, 'Fisiología Humana', '02FH0', 1, NOW()),
    (6, 2, 'Microbiología I', '02MI1', 1, NOW()),
    (6, 3, 'Química Orgánica II', '03QO2', 1, NOW()),
    (6, 3, 'Bioquímica II', '03BQ2', 1, NOW()),
    (6, 3, 'Farmacología I', '03FA1', 1, NOW()),
    (6, 3, 'Microbiología II', '03MI2', 1, NOW()),
    (6, 4, 'Análisis Instrumental', '04AI0', 1, NOW()),
    (6, 4, 'Farmacología II', '04FA2', 1, NOW()),
    (6, 4, 'Toxicología', '04TOX0', 1, NOW()),
    (6, 4, 'Parasitología', '04PAR0', 1, NOW()),
    (6, 5, 'Química Analítica', '05QA0', 1, NOW()),
    (6, 5, 'Bromatología', '05BRO0', 1, NOW()),
    (6, 5, 'Inmunología', '05INM0', 1, NOW()),
    (6, 5, 'Tecnología Farmacéutica', '05TF0', 1, NOW()),
    (6, 6, 'Legislación Farmacéutica', '06LF0', 1, NOW()),
    (6, 6, 'Farmacognosia', '06FAR0', 1, NOW()),
    (6, 6, 'Biofarmacia', '06BIO0', 1, NOW()),
    (6, 6, 'Química Medicinal', '06QM0', 1, NOW()),
    (6, 7, 'Desarrollo de Fármacos', '07DF0', 1, NOW()),
    (6, 7, 'Patología General', '07PG0', 1, NOW()),
    (6, 7, 'Biotecnología Farmacéutica', '07BF0', 1, NOW()),
    (6, 7, 'Control de Calidad', '07CC0', 1, NOW()),
    (6, 8, 'Prácticas Profesionales', '08PP0', 1, NOW()),
    (6, 8, 'Terapia Génica', '08TG0', 1, NOW()),
    (6, 8, 'Nanotecnología Farmacéutica', '08NF0', 1, NOW()),
    (6, 8, 'Seminario de Investigación', '08SI0', 1, NOW());

INSERT INTO cat_materias(nid_carrera, nid_semestre, cnombre_materia, cclave_materia, bhabilitado, dfecha_alta) -- Inserta para historia y antropología
VALUES  
    (7, 1, 'Introducción a la Historia', '01IH0', 1, NOW()),
    (7, 1, 'Teoría Antropológica I', '01TA1', 1, NOW()),
    (7, 1, 'Geografía Humana', '01GH0', 1, NOW()),
    (7, 1, 'Historia de América I', '01HA1', 1, NOW()),
    (7, 2, 'Historia del Mundo Antiguo', '02HMA', 1, NOW()),
    (7, 2, 'Teoría Antropológica II', '02TA2', 1, NOW()),
    (7, 2, 'Etnografía y Trabajo de Campo', '02ETC', 1, NOW()),
    (7, 2, 'Historia de América II', '02HA2', 1, NOW()),
    (7, 3, 'Historia de México I', '03HM1', 1, NOW()),
    (7, 3, 'Antropología Social', '03AS0', 1, NOW()),
    (7, 3, 'Arqueología General', '03AG0', 1, NOW()),
    (7, 3, 'Historia Económica', '03HEC', 1, NOW()),
    (7, 4, 'Historia de México II', '04HM2', 1, NOW()),
    (7, 4, 'Antropología Biológica', '04AB0', 1, NOW()),
    (7, 4, 'Métodos de Investigación Histórica', '04MIH', 1, NOW()),
    (7, 4, 'Historia Cultural', '04HC0', 1, NOW()),
    (7, 5, 'Historia Contemporánea', '05HCO', 1, NOW()),
    (7, 5, 'Lingüística Antropológica', '05LA0', 1, NOW()),
    (7, 5, 'Etnología de México', '05EMX', 1, NOW()),
    (7, 5, 'Historiografía', '05HIS', 1, NOW()),
    (7, 6, 'Historia del Arte', '06HAR', 1, NOW()),
    (7, 6, 'Antropología Política', '06APO', 1, NOW()),
    (7, 6, 'Antropología Urbana', '06AU0', 1, NOW()),
    (7, 6, 'Historia Oral', '06HOR', 1, NOW()),
    (7, 7, 'Historia y Memoria Colectiva', '07HMC', 1, NOW()),
    (7, 7, 'Etnografía Contemporánea', '07EC0', 1, NOW()),
    (7, 7, 'Antropología de la Religión', '07AR0', 1, NOW()),
    (7, 7, 'Seminario de Historia y Sociedad', '07SHS', 1, NOW()),
    (7, 8, 'Técnicas de Archivo', '08TAR', 1, NOW()),
    (7, 8, 'Análisis de Fuentes Históricas', '08AFH', 1, NOW()),
    (7, 8, 'Seminario de Investigación Histórica', '08SIH', 1, NOW()),
    (7, 8, 'Antropología Aplicada', '08AA0', 1, NOW());

INSERT INTO cat_materias(nid_carrera, nid_semestre, cnombre_materia, cclave_materia, bhabilitado, dfecha_alta) -- Inserta para la carrea de medicina
VALUES  
    (8, 1, 'Anatomía Humana', '01ANA0', 1, NOW()),
    (8, 1, 'Histología', '01HIS0', 1, NOW()),
    (8, 1, 'Embriología', '01EMB0', 1, NOW()),
    (8, 1, 'Bioquímica', '01BIOQ', 1, NOW()),
    (8, 2, 'Fisiología Humana', '02FIS0', 1, NOW()),
    (8, 2, 'Genética Médica', '02GEN0', 1, NOW()),
    (8, 2, 'Microbiología', '02MIC0', 1, NOW()),
    (8, 2, 'Inmunología', '02INM0', 1, NOW()),
    (8, 3, 'Farmacología I', '03FAR1', 1, NOW()),
    (8, 3, 'Patología General', '03PAT0', 1, NOW()),
    (8, 3, 'Propedéutica Clínica', '03PRO0', 1, NOW()),
    (8, 3, 'Nutrición Clínica', '03NUT0', 1, NOW()),
    (8, 4, 'Farmacología II', '04FAR2', 1, NOW()),
    (8, 4, 'Patología Especial', '04PATE', 1, NOW()),
    (8, 4, 'Imagenología', '04IMG0', 1, NOW()),
    (8, 4, 'Bioética Médica', '04BIOE', 1, NOW()),
    (8, 5, 'Medicina Interna I', '05MIN1', 1, NOW()),
    (8, 5, 'Cirugía General I', '05CIR1', 1, NOW()),
    (8, 5, 'Pediatría I', '05PED1', 1, NOW()),
    (8, 5, 'Gineco-Obstetricia I', '05GOB1', 1, NOW()),
    (8, 6, 'Medicina Interna II', '06MIN2', 1, NOW()),
    (8, 6, 'Cirugía General II', '06CIR2', 1, NOW()),
    (8, 6, 'Pediatría II', '06PED2', 1, NOW()),
    (8, 6, 'Gineco-Obstetricia II', '06GOB2', 1, NOW()),
    (8, 7, 'Urgencias Médicas', '07URG0', 1, NOW()),
    (8, 7, 'Traumatología y Ortopedia', '07TRA0', 1, NOW()),
    (8, 7, 'Psiquiatría', '07PSI0', 1, NOW()),
    (8, 7, 'Medicina Legal', '07MLEG', 1, NOW()),
    (8, 8, 'Oftalmología', '08OFT0', 1, NOW()),
    (8, 8, 'Otorrinolaringología', '08OTO0', 1, NOW()),
    (8, 8, 'Dermatología', '08DERM', 1, NOW()),
    (8, 8, 'Anestesiología', '08ANES', 1, NOW()),
    (8, 9, 'Medicina Familiar', '09MFAM', 1, NOW()),
    (8, 9, 'Geriatría', '09GERI', 1, NOW()),
    (8, 9, 'Medicina del Trabajo', '09MTAB', 1, NOW()),
    (8, 9, 'Epidemiología', '09EPID', 1, NOW()),
    (8, 10, 'Rotación Hospitalaria I', '10ROT1', 1, NOW()),
    (8, 10, 'Rotación Comunitaria', '10ROC0', 1, NOW()),
    (8, 10, 'Terapia Intensiva', '10TERI', 1, NOW()),
    (8, 10, 'Investigación Clínica', '10INV0', 1, NOW()),
    (8, 11, 'Rotación Hospitalaria II', '11ROT2', 1, NOW()),
    (8, 11, 'Neurociencias', '11NEUR', 1, NOW()),
    (8, 11, 'Oncología', '11ONCO', 1, NOW()),
    (8, 11, 'Medicina Preventiva', '11MPRE', 1, NOW()),
    (8, 12, 'Internado Médico', '12INTM', 1, NOW()),
    (8, 12, 'Seminario de Tesis', '12SEMT', 1, NOW()),
    (8, 12, 'Deontología Médica', '12DEON', 1, NOW()),
    (8, 12, 'Preparación para Examen Profesional', '12PEP0', 1, NOW());


INSERT INTO cat_categorias(ccategoria, bhabilitado, dfecha_alta)
VALUES  ('Alunmo', 1, NOW()),
        ('Profesor', 1, NOW()),
        ('Administrador', 1, NOW()),
        ('SuperUs', 1, now());

INSERT into cat_grupos(cgrupo, bhabilitado, dfecha_alta)
VALUES
('A-11', 1, NOW()), ('A-12', 1, NOW()), ('A-13', 1, NOW()), ('A-14', 1, NOW()), ('A-21', 1, NOW()), ('A-22', 1, NOW()), ('A-23', 1, NOW()), ('A-24', 1, NOW()), ('A-31', 1, NOW()), ('A-32', 1, NOW()), ('A-33', 1, NOW()), ('A-34', 1, NOW()),
('A-41', 1, NOW()), ('A-42', 1, NOW()), ('A-43', 1, NOW()), ('A-44', 1, NOW()), ('A-51', 1, NOW()), ('A-52', 1, NOW()), ('A-53', 1, NOW()), ('A-54', 1, NOW()), ('A-61', 1, NOW()), ('A-62', 1, NOW()), ('A-63', 1, NOW()), ('A-64', 1, NOW()),
('A-71', 1, NOW()), ('A-72', 1, NOW()), ('A-73', 1, NOW()), ('A-74', 1, NOW()), ('A-81', 1, NOW()), ('A-82', 1, NOW()), ('A-83', 1, NOW()), ('A-84', 1, NOW());

INSERT INTO cat_grupos (cgrupo, bhabilitado, dfecha_alta)
VALUES
('B-11', 1, NOW()), ('B-12', 1, NOW()), ('B-13', 1, NOW()), ('B-14', 1, NOW()), ('B-21', 1, NOW()), ('B-22', 1, NOW()), ('B-23', 1, NOW()), ('B-24', 1, NOW()), 
('B-31', 1, NOW()), ('B-32', 1, NOW()), ('B-33', 1, NOW()), ('B-34', 1, NOW()), ('B-41', 1, NOW()), ('B-42', 1, NOW()), ('B-43', 1, NOW()), ('B-44', 1, NOW()), 
('B-51', 1, NOW()), ('B-52', 1, NOW()), ('B-53', 1, NOW()), ('B-54', 1, NOW()), ('B-61', 1, NOW()), ('B-62', 1, NOW()), ('B-63', 1, NOW()), ('B-64', 1, NOW()), 
('B-71', 1, NOW()), ('B-72', 1, NOW()), ('B-73', 1, NOW()), ('B-74', 1, NOW()), ('B-81', 1, NOW()), ('B-82', 1, NOW()), ('B-83', 1, NOW()), ('B-84', 1, NOW());

INSERT INTO cat_grupos (cgrupo, bhabilitado, dfecha_alta)
VALUES
('C-11', 1, NOW()), ('C-12', 1, NOW()), ('C-13', 1, NOW()), ('C-14', 1, NOW()), ('C-21', 1, NOW()), ('C-22', 1, NOW()), ('C-23', 1, NOW()), ('C-24', 1, NOW()), 
('C-31', 1, NOW()), ('C-32', 1, NOW()), ('C-33', 1, NOW()), ('C-34', 1, NOW()), ('C-41', 1, NOW()), ('C-42', 1, NOW()), ('C-43', 1, NOW()), ('C-44', 1, NOW()), 
('C-51', 1, NOW()), ('C-52', 1, NOW()), ('C-53', 1, NOW()), ('C-54', 1, NOW()), ('C-61', 1, NOW()), ('C-62', 1, NOW()), ('C-63', 1, NOW()), ('C-64', 1, NOW()), 
('C-71', 1, NOW()), ('C-72', 1, NOW()), ('C-73', 1, NOW()), ('C-74', 1, NOW()), ('C-81', 1, NOW()), ('C-82', 1, NOW()), ('C-83', 1, NOW()), ('C-84', 1, NOW());

-- Grupos con la letra D
INSERT INTO cat_grupos (cgrupo, bhabilitado, dfecha_alta)
VALUES
('D-11', 1, NOW()), ('D-12', 1, NOW()), ('D-13', 1, NOW()), ('D-14', 1, NOW()), ('D-21', 1, NOW()), ('D-22', 1, NOW()), ('D-23', 1, NOW()), ('D-24', 1, NOW()), 
('D-31', 1, NOW()), ('D-32', 1, NOW()), ('D-33', 1, NOW()), ('D-34', 1, NOW()), ('D-41', 1, NOW()), ('D-42', 1, NOW()), ('D-43', 1, NOW()), ('D-44', 1, NOW()), 
('D-51', 1, NOW()), ('D-52', 1, NOW()), ('D-53', 1, NOW()), ('D-54', 1, NOW()), ('D-61', 1, NOW()), ('D-62', 1, NOW()), ('D-63', 1, NOW()), ('D-64', 1, NOW()), 
('D-71', 1, NOW()), ('D-72', 1, NOW()), ('D-73', 1, NOW()), ('D-74', 1, NOW()), ('D-81', 1, NOW()), ('D-82', 1, NOW()), ('D-83', 1, NOW()), ('D-84', 1, NOW());

-- Grupos con la letra E
INSERT INTO cat_grupos (cgrupo, bhabilitado, dfecha_alta)
VALUES
('E-11', 1, NOW()), ('E-12', 1, NOW()), ('E-13', 1, NOW()), ('E-14', 1, NOW()), ('E-21', 1, NOW()), ('E-22', 1, NOW()), ('E-23', 1, NOW()), ('E-24', 1, NOW()), 
('E-31', 1, NOW()), ('E-32', 1, NOW()), ('E-33', 1, NOW()), ('E-34', 1, NOW()), ('E-41', 1, NOW()), ('E-42', 1, NOW()), ('E-43', 1, NOW()), ('E-44', 1, NOW()), 
('E-51', 1, NOW()), ('E-52', 1, NOW()), ('E-53', 1, NOW()), ('E-54', 1, NOW()), ('E-61', 1, NOW()), ('E-62', 1, NOW()), ('E-63', 1, NOW()), ('E-64', 1, NOW()), 
('E-71', 1, NOW()), ('E-72', 1, NOW()), ('E-73', 1, NOW()), ('E-74', 1, NOW()), ('E-81', 1, NOW()), ('E-82', 1, NOW()), ('E-83', 1, NOW()), ('E-84', 1, NOW());

-- Grupos con la letra F
INSERT INTO cat_grupos (cgrupo, bhabilitado, dfecha_alta)
VALUES
('F-11', 1, NOW()), ('F-12', 1, NOW()), ('F-13', 1, NOW()), ('F-14', 1, NOW()), ('F-21', 1, NOW()), ('F-22', 1, NOW()), ('F-23', 1, NOW()), ('F-24', 1, NOW()), 
('F-31', 1, NOW()), ('F-32', 1, NOW()), ('F-33', 1, NOW()), ('F-34', 1, NOW()), ('F-41', 1, NOW()), ('F-42', 1, NOW()), ('F-43', 1, NOW()), ('F-44', 1, NOW()), 
('F-51', 1, NOW()), ('F-52', 1, NOW()), ('F-53', 1, NOW()), ('F-54', 1, NOW()), ('F-61', 1, NOW()), ('F-62', 1, NOW()), ('F-63', 1, NOW()), ('F-64', 1, NOW()), 
('F-71', 1, NOW()), ('F-72', 1, NOW()), ('F-73', 1, NOW()), ('F-74', 1, NOW()), ('F-81', 1, NOW()), ('F-82', 1, NOW()), ('F-83', 1, NOW()), ('F-84', 1, NOW());

-- Grupos con la letra G
INSERT INTO cat_grupos (cgrupo, bhabilitado, dfecha_alta)
VALUES
('G-11', 1, NOW()), ('G-12', 1, NOW()), ('G-13', 1, NOW()), ('G-14', 1, NOW()), ('G-21', 1, NOW()), ('G-22', 1, NOW()), ('G-23', 1, NOW()), ('G-24', 1, NOW()), 
('G-31', 1, NOW()), ('G-32', 1, NOW()), ('G-33', 1, NOW()), ('G-34', 1, NOW()), ('G-41', 1, NOW()), ('G-42', 1, NOW()), ('G-43', 1, NOW()), ('G-44', 1, NOW()), 
('G-51', 1, NOW()), ('G-52', 1, NOW()), ('G-53', 1, NOW()), ('G-54', 1, NOW()), ('G-61', 1, NOW()), ('G-62', 1, NOW()), ('G-63', 1, NOW()), ('G-64', 1, NOW()), 
('G-71', 1, NOW()), ('G-72', 1, NOW()), ('G-73', 1, NOW()), ('G-74', 1, NOW()), ('G-81', 1, NOW()), ('G-82', 1, NOW()), ('G-83', 1, NOW()), ('G-84', 1, NOW());

-- Grupos con la letra H
INSERT INTO cat_grupos (cgrupo, bhabilitado, dfecha_alta)
VALUES
('H-11', 1, NOW()), ('H-12', 1, NOW()), ('H-13', 1, NOW()), ('H-14', 1, NOW()), ('H-21', 1, NOW()), ('H-22', 1, NOW()), ('H-23', 1, NOW()), ('H-24', 1, NOW()), 
('H-31', 1, NOW()), ('H-32', 1, NOW()), ('H-33', 1, NOW()), ('H-34', 1, NOW()), ('H-41', 1, NOW()), ('H-42', 1, NOW()), ('H-43', 1, NOW()), ('H-44', 1, NOW()), 
('H-51', 1, NOW()), ('H-52', 1, NOW()), ('H-53', 1, NOW()), ('H-54', 1, NOW()), ('H-61', 1, NOW()), ('H-62', 1, NOW()), ('H-63', 1, NOW()), ('H-64', 1, NOW()), 
('H-71', 1, NOW()), ('H-72', 1, NOW()), ('H-73', 1, NOW()), ('H-74', 1, NOW()), ('H-81', 1, NOW()), ('H-82', 1, NOW()), ('H-83', 1, NOW()), ('H-84', 1, NOW());


INSERT INTO cat_horarios(chorario, bhabilitado, dfecha_alta)
VALUES  
    ('7:00 AM - 9:00 AM', 1, NOW()),  
    ('9:00 AM - 11:00 AM', 1, NOW()),  
    ('11:00 AM - 1:00 PM', 1, NOW()),  
    ('2:00 PM - 4:00 PM', 1, NOW()),  
    ('4:00 PM - 6:00 PM', 1, NOW()),  
    ('6:00 PM - 8:00 PM', 1, NOW()),  
    ('8:00 PM - 10:00 PM', 1, NOW());

INSERT INTO cat_periodos(cperiodo, canio, bhabilitado, dfecha_alta)
VALUES  
    ('2025-1', '2025', 1, NOW()), ('2025-2', '2025', 1, NOW()),
    ('2026-1', '2026', 1, NOW()), ('2026-2', '2026', 1, NOW()),
    ('2027-1', '2027', 1, NOW()), ('2027-2', '2027', 1, NOW()),
    ('2028-1', '2028', 1, NOW()), ('2028-2', '2028', 1, NOW()),
    ('2029-1', '2029', 1, NOW()), ('2029-2', '2029', 1, NOW()),
    ('2030-1', '2030', 1, NOW()), ('2030-2', '2030', 1, NOW()),
    ('2031-1', '2031', 1, NOW()), ('2031-2', '2031', 1, NOW()),
    ('2032-1', '2032', 1, NOW()), ('2032-2', '2032', 1, NOW()),
    ('2033-1', '2033', 1, NOW()), ('2033-2', '2033', 1, NOW()),
    ('2034-1', '2034', 1, NOW()), ('2034-2', '2034', 1, NOW()),
    ('2035-1', '2035', 1, NOW()), ('2035-2', '2035', 1, NOW());


